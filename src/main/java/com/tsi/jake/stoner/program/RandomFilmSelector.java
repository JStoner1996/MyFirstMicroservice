
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

	static final String ACTOR_STRING = "Actor ";
	static final String FILM_STRING = "Film ";
	static final String DOES_NOT_EXIST = " does not exist";
	static final String NO_MATCHING_FILM = "No films exist that match the search.";


	Random rand = new Random();

	public static void main(String[] args) {
		SpringApplication.run(RandomFilmSelector.class, args);
	}

	public RandomFilmSelector(
			ActorRepository actorRepository,
			FilmRepository filmRepository,
			FilmCategoryRepository filmCategoryRepository,
			FilmActorRepository filmActorRepository,
			CategoryRepository categoryRepository,
			LanguageRepository languageRepository){

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
	// ---------------------Actors---------------------

	// Gets all actors
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

	// Updates actor with new names
//	@PutMapping ("/Update_Actor/{actor_id}")
//	public @ResponseBody String updateActor(@PathVariable int actor_id, @RequestParam String first_name, @RequestParam String last_name){
//
//			if(actorRepository.existsById(actor_id)){
//				Actor actor = actorRepository.findById(actor_id).get();
//				actor.setFirst_name(first_name);
//				actor.setLast_name(last_name);
//				actorRepository.save(actor);
//				return ACTOR_STRING + actor_id + " updated.";
//			} else return ACTOR_STRING + actor_id + DOES_NOT_EXIST;
//	}

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
	public String getRandomFilmByKeyword(@PathVariable String keyword){

		// Used to get size of list
		List<Film> filmsByWord = getFilmByKeyword(keyword);
		int max = filmsByWord.size();

		// Chooses a random element from this list and set's title and description to that of the random film
		Film randomElement = filmsByWord.get(rand.nextInt(max));
		String title = randomElement.getTitle();
		String description = randomElement.getDescription();
		return title + ": " + description;
	}

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
	public String getFilmIdByCategory (@PathVariable String name){
		List <FilmCategory> filmCats = getCategoryIDByName(name);
		int max = filmCats.size();

		FilmCategory randomElement = filmCats.get(rand.nextInt(max));
		Optional<Film> randomOptional = getFilmById(randomElement.getFilmId());

		if (randomOptional.isPresent()){
			Film randomFilm = randomOptional.get();
			String title = randomFilm.getTitle();
			String description = randomFilm.getDescription();
			return title + ": " + description;
		} else return NO_MATCHING_FILM;
	}

	public List<FilmCategory> getCategoryIDByName (@PathVariable String name){
		if (categoryRepository.findByName(name)!= null){
			int categoryId = categoryRepository.findByName(name).getCategoryId();

			return filmCategoryRepository.findByCategoryId(categoryId);
		} else throw new ResourceNotFoundException("Category: " + name + DOES_NOT_EXIST);
	}


	@GetMapping ("/film/randomByActor/{name}")
	public String getFilmByActorId (@PathVariable String name){
		List <FilmActor> filmActors = getRandomActorId(name);
		int max = filmActors.size();
		FilmActor randomFilmActor = filmActors.get(rand.nextInt(max));
		Optional<Film> randomOptional = getFilmById(randomFilmActor.getFilmId());
		if (randomOptional.isPresent()) {
			Film randomFilm = randomOptional.get();
			String title = randomFilm.getTitle();
			String description = randomFilm.getDescription();
			return title + ": " + description;
		} else return NO_MATCHING_FILM;
	}

	@GetMapping ("/actor/name/{name}")
	public List<Actor> getFilmByActorName(@PathVariable String name){
		// Used for the SQL query:
		name = "%" + name + "%";
		return actorRepository.findByFirstNameLikeOrLastNameLike(name,  name);
	}

	public List<FilmActor> getRandomActorId (String name){
		List<Actor> actors = getFilmByActorName(name);
		int max = actors.size();
		Actor randomActor = actors.get(rand.nextInt(max));
		int actorId = randomActor.getActorId();
		return filmActorRepository.findByActorId(actorId);
	}










	// ---------------------Languages---------------------

	// Returns all languages
	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}











}
