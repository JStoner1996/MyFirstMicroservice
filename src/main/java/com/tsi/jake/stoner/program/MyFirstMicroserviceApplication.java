
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

@CrossOrigin (origins = "*") // needed for receiving request via api
@SpringBootApplication
@RestController // Handles GET, POST, DELETE, PUT requests
@RequestMapping("/home")//base url

public class MyFirstMicroserviceApplication {

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



	private String saved = "Saved";
	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(
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
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	// Gets actor by id
	@GetMapping("/Actor_By_ID/{actor_id}")
	public @ResponseBody Optional<Actor> getActorById (@PathVariable int actor_id){
		Actor actor = actorRepository.findById(actor_id)
				.orElseThrow(() -> new ResourceNotFoundException("Actor " + actor_id + " does not exist"));
		return actorRepository.findById(actor_id);
	}

	// Adds Actor
	@PostMapping("/Add_Actor")
	public @ResponseBody String addActor (@RequestParam String first_name, @RequestParam String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return "Actor added.";
	}


	// Deletes Actor
	@DeleteMapping("/Delete_Actor")
	public @ResponseBody String removeActor (@RequestParam int actor_id){

		Actor newActor = actorRepository.findById(actor_id).orElseThrow( () -> new ResourceNotFoundException("Actor " + actor_id + " not found."));

		actorRepository.delete(newActor);
		return "Actor " + newActor.getActor_id() + " deleted.";

	}

	// Deletes actor with a message if actor not found
	@DeleteMapping("/Delete_Actor_By_ID")
	public @ResponseBody String removeActorByID (@RequestParam int actor_id){

		if (actorRepository.existsById(actor_id)){
			actorRepository.deleteById(actor_id);
			return "Actor " + actor_id + " deleted.";
		} else {
			return "Actor not found";
		}
	}

	@PutMapping ("/Update_Actor/{actor_id}")
	public @ResponseBody String updateActor(@PathVariable int actor_id, @RequestParam String first_name, @RequestParam String last_name){

			Actor actor = actorRepository.findById(actor_id).get();
			actor.setFirst_name(first_name);
			actor.setLast_name(last_name);
			actorRepository.save(actor);
			return "Actor " + actor_id + " updated.";
	}

	// ---------------------Films---------------------
	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	@GetMapping("/All_FilmCategories")
	public @ResponseBody
	Iterable<FilmCategory>getAllFilmCategories(){
		return filmCategoryRepository.findAll();
	}

	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();
	}


	@GetMapping("/Film_By_ID/{film_id}")
	public @ResponseBody Optional<Film> getFilmById (@PathVariable int film_id){

		return filmRepository.findById(film_id);
	}


	// Returns a list of films that have the keyword
	@GetMapping("/Film_By_Keyword/{keyword}")
	public ResponseEntity <List<Film>> getFilmByKeyword(@PathVariable String keyword){
		// Used for the SQL query:
		keyword = "%" + keyword + "%";
		return new ResponseEntity<List<Film>>(filmRepository.findByTitleLikeOrDescriptionLike(keyword,  keyword),HttpStatus.OK);
	}

	@GetMapping("/All_Film_Actors")
	public @ResponseBody
	Iterable<FilmActor>getAllFilmActors(){
		return filmActorRepository.findAll();
	}


	// Returns list of films by actor id
	@GetMapping("/Film_By_Actor/{actorId}")
	public ResponseEntity <List<FilmActor>> getFilmByActor(@PathVariable int actorId){
		return new ResponseEntity<List<FilmActor>>(filmActorRepository.findByActorId(actorId),HttpStatus.OK);
	}



	// ---------------------Languages---------------------
	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}











}
