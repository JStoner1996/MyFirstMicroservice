
package com.tsi.jake.stoner.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootApplication
@RestController // Handles GET, POST, DELETE, PUT requests
@RequestMapping("/filmRandomizer") //base url,  so url would be: localhost:8080/home/{Mapping}
@CrossOrigin


public class RandomFilmSelector {

	//@Autowired - To my understanding links together classes to the database
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private FilmCategoryRepository filmCategoryRepository;
	@Autowired
	private FilmActorRepository filmActorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private LanguageRepository languageRepository;

	private Random random = new Random();

	static final String ACTOR_STRING = "Actor ";
	static final String FILM_STRING = "Film ";
	static final String DOES_NOT_EXIST = " does not exist";
	static final String NO_MATCHING_FILM = "No films exist that match the search.";

	public static void main(String[] args) {
		SpringApplication.run(RandomFilmSelector.class, args);
	}

	public RandomFilmSelector(
			ActorRepository actorRepository,
			FilmRepository filmRepository,
			FilmCategoryRepository filmCategoryRepository,
			FilmActorRepository filmActorRepository,
			CategoryRepository categoryRepository,
			LanguageRepository languageRepository
			){

		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
		this.filmCategoryRepository = filmCategoryRepository;
		this.filmActorRepository = filmActorRepository;
		this.categoryRepository = categoryRepository;
		this.languageRepository = languageRepository;
	}


	/*-----------------------------------------------------------
	 					Mappings (CRUD)
	@PostMapping - mapping HTTP 'POST' requests (CREATE)
	@GetMapping - mapping HTTP 'GET' requests (READ)
	@PutMapping - mapping HTTP 'Put' requests (UPDATE)
	@DeleteMapping - mapping HTTP 'Delete' requests (DELETE)
	-----------------------------------------------------------*/

	@GetMapping("/actor/actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	// Gets actor by id
	@GetMapping("/actor/{actor_id}")
	public @ResponseBody Optional<Actor> getActorById (@PathVariable int actor_id){
		if (actorRepository.existsById(actor_id)){
			return actorRepository.findById(actor_id);

		} else throw new ResourceNotFoundException(ACTOR_STRING + actor_id + DOES_NOT_EXIST);
	}

	// Adds Actor
	@PostMapping("/actor/add")
	public @ResponseBody String addActor (@RequestParam String first_name, @RequestParam String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return ACTOR_STRING +  "added.";
	}


	// Deletes actor with a message if actor not found
	@DeleteMapping("/actor/delete")
	public @ResponseBody String removeActorByID (@RequestParam int actor_id){

		if (actorRepository.existsById(actor_id)){
			actorRepository.deleteById(actor_id);
			return ACTOR_STRING + actor_id + " deleted. ";
		} else throw new ResourceNotFoundException(ACTOR_STRING + actor_id + DOES_NOT_EXIST);
	}

	 //Updates actor with new names
	@PutMapping ("/updateActor/{actor_id}")
	public @ResponseBody String updateActor(@PathVariable int actorId, @RequestParam String firstName, @RequestParam String lastName){

			if(actorRepository.existsById(actorId)){
				Actor actor = actorRepository.findById(actorId).get();
				actor.setFirstName(firstName);
				actor.setLastName(lastName);
				actorRepository.save(actor);
				return ACTOR_STRING + actorId + " updated.";
			} else return ACTOR_STRING + actorId + DOES_NOT_EXIST;
	}


	// ---------------------Films---------------------
	// Returns a list of all films
	@GetMapping("/film/films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	// Returns a list of all film ids their category ids
	@GetMapping("/film/filmCategories")
	public @ResponseBody
	Iterable<FilmCategory>getAllFilmCategories(){
		return filmCategoryRepository.findAll();
	}

	// Returns a list of all categories and their ids
	@GetMapping("/film/categories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();
	}

	// returns a film's information by its ID
	@GetMapping("/film/{film_id}")
	public @ResponseBody Optional<Film> getFilmById (@PathVariable int film_id){

		if (filmRepository.existsById(film_id)){
			return filmRepository.findById(film_id);
		} else throw new ResourceNotFoundException(FILM_STRING + film_id + DOES_NOT_EXIST);

	}

	// Random by Keyword
	@GetMapping("/film/randomByKeyword/{keyword}")
	public Film getRandomFilmByKeyword(@PathVariable String keyword){

		// Creates a list of films that contain the keyword
		List<Film> filmsByWord = getFilmByKeyword(keyword);
		//  Used to get size of list, to set a max number
		int max = filmsByWord.size();

		// Chooses a random element from this list and set's title and description to that of the random film
		Film randomFilm = filmsByWord.get(random.nextInt(max));
		if (randomFilm != null){
			return randomFilm;
		} else throw new ResourceNotFoundException(NO_MATCHING_FILM);
	}

//	// Random by Keyword String
//	@GetMapping("/film/randomByKeyword/{keyword}")
//	public String getRandomFilmByKeyword(@PathVariable String keyword){
//
//		// Used to get size of list
//		List<Film> filmsByWord = getFilmByKeyword(keyword);
//		int max = filmsByWord.size();
//
//		// Chooses a random element from this list and set's title and description to that of the random film
//		Film randomElement = filmsByWord.get(rand.nextInt(max));
//		String title = randomElement.getTitle();
//		String description = randomElement.getDescription();
//		return title + ": " + description;
//	}

	// Returns a list of films that have the keyword
	public List<Film> getFilmByKeyword(String keyword){
		// Used for the SQL query:
		keyword = "%" + keyword + "%";
		return filmRepository.findByTitleLikeOrDescriptionLike(keyword,  keyword);
	}

	// Returns a list of actor id's and their film id's
	@GetMapping("/film/actors")
	public @ResponseBody
	Iterable<FilmActor>getAllFilmActors(){
		return filmActorRepository.findAll();
	}

	// Returns list of film ids by actor id - plan to use this to get film information
	// SQL Query:
	@GetMapping("/film/actor/{actorId}")
	public ResponseEntity <List<FilmActor>> getFilmByActor(@PathVariable int actorId){
		return new ResponseEntity<>(filmActorRepository.findByActorId(actorId),HttpStatus.OK);
	}


	// Random By Category
	@GetMapping ("/film/randomByCategory/{name}")
	public Film getFilmIdByCategory (@PathVariable String name){
		List <FilmCategory> filmCategories = getFilmsByCategoryName(name);
		FilmCategory randomElement = filmCategories.get(random.nextInt(filmCategories.size()));
		if (getFilmById(randomElement.getFilmId()).isPresent()){
			return getFilmById(randomElement.getFilmId()).get();
		} else throw new ResourceNotFoundException(NO_MATCHING_FILM);
	}

	public List<FilmCategory> getFilmsByCategoryName(@PathVariable String name){
		if (categoryRepository.findByName(name)!= null){
			return filmCategoryRepository.findByCategoryId(categoryRepository.findByName(name).getCategoryId());
		} else throw new ResourceNotFoundException("Category: " + name + DOES_NOT_EXIST);
	}


	// Random By Actor Name
	@GetMapping ("/film/randomByActor/{name}")
	public Film getFilmByActorId (@PathVariable String name){
		List <FilmActor> filmActors = getRandomActorId(name);
		FilmActor randomFilmActor = filmActors.get(random.nextInt(filmActors.size()));
		if (getFilmById(randomFilmActor.getFilmId()).isPresent()) {
			return getFilmById(randomFilmActor.getFilmId()).get();
		} else throw new ResourceNotFoundException(NO_MATCHING_FILM);
	}

	@GetMapping ("/actor/name/{name}")
	public List<Actor> getFilmByActorName(@PathVariable String name){
		return actorRepository.findByFirstNameLikeOrLastNameLike("%" + name + "%", "%" + name + "%");	// The % are Used for the SQL query
	}

	public List<FilmActor> getRandomActorId (String name){
		return filmActorRepository.findByActorId(getFilmByActorName(name).get(random.nextInt(getFilmByActorName(name).size())).getActorId());
	}




	// ---------------------Languages---------------------

	// Returns all languages
	@GetMapping("/allLanguages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}

	// Random By Language
	@GetMapping ("/film/randomByLanguage/{name}")
	public Film getFilmByLanguage (@PathVariable String name){
		List <Film> films = filmRepository.findByLanguageId(getLanguageIDByName(name));

		if (films.get(random.nextInt(films.size())) != null){
			return films.get(random.nextInt(films.size()));
		} else throw new ResourceNotFoundException(NO_MATCHING_FILM);
	}

	public int getLanguageIDByName (String name){
		if (languageRepository.findByName(name)!= null){
			return languageRepository.findByName(name).getLanguageId();
		} else throw new ResourceNotFoundException("Language: " + name + DOES_NOT_EXIST);
	}
	@GetMapping ("/film/randomByLength/{length}")
	public Film getFilmByLength (@PathVariable int length){

		List <Film> films = filmRepository.findByLength(length);

		if (films.get(random.nextInt(films.size())) != null){
			return films.get(random.nextInt(films.size()));
		} else throw new ResourceNotFoundException(NO_MATCHING_FILM);
 	}
}
