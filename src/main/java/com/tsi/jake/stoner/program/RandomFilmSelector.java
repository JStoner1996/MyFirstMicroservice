
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

@SpringBootApplication
@RestController // Handles GET, POST, DELETE, PUT requests
@RequestMapping("/home") //base url,  so url would be: localhost:8080/home/{Mapping}



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


	// CONST Variables
	static final String ACTOR_STRING = "Actor ";
	static final String DOES_NOT_EXIST = " does not exist.";
	static final String FILM_STRING = "Film ";


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
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	// Gets actor by id
	@GetMapping("/Actor_By_ID/{actor_id}")
	public @ResponseBody Optional<Actor> getActorById (@PathVariable int actor_id){
	if (actorRepository.existsById(actor_id)){
		return actorRepository.findById(actor_id);
	} else throw new ResourceNotFoundException(ACTOR_STRING + actor_id + DOES_NOT_EXIST);
	}

	// Adds Actor
	@PostMapping("/Add_Actor")
	public @ResponseBody String addActor (@RequestParam String first_name, @RequestParam String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return ACTOR_STRING +  "added.";
	}


	// Deletes actor with a message if actor not found
	@DeleteMapping("/Delete_Actor_By_ID")
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
	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}

	// Returns a list of all film ids their category ids
	@GetMapping("/All_FilmCategories")
	public @ResponseBody
	Iterable<FilmCategory>getAllFilmCategories(){
		return filmCategoryRepository.findAll();
	}

	// Returns a list of all categories and their ids
	@GetMapping("/All_Categories")
	public @ResponseBody
	Iterable<Category>getAllCategories(){
		return categoryRepository.findAll();
	}

	// returns a film's information by its ID
	@GetMapping("/Film_By_ID/{film_id}")
	public @ResponseBody Optional<Film> getFilmById (@PathVariable int film_id){

		if (filmRepository.existsById(film_id)){
			return filmRepository.findById(film_id);
		} else throw new ResourceNotFoundException(FILM_STRING + film_id + DOES_NOT_EXIST);

	}

	// Returns a list of films that have the keyword
	// SQL Query: SELECT * FROM sakila.film WHERE title LIKE '%{keyword}%' OR description LIKE '%{keyword}%’;
	// NEED TO CHANGE TO ADD FILM_TEXT TABLE AND USE THAT INSTEAD!
	@GetMapping("/Film_By_Keyword/{keyword}")
	public ResponseEntity <List<Film>> getFilmByKeyword(@PathVariable String keyword){
		// Used for the SQL query:
		keyword = "%" + keyword + "%";
		return new ResponseEntity<>(filmRepository.findByTitleLikeOrDescriptionLike(keyword,  keyword),HttpStatus.OK);
	}

	// Returns a list of actor id's and their film id's
	@GetMapping("/All_Film_Actors")
	public @ResponseBody
	Iterable<FilmActor>getAllFilmActors(){
		return filmActorRepository.findAll();
	}

	// Returns list of film ids by actor id - plan to use this to get film information
	// SQL Query:
	@GetMapping("/Film_By_Actor/{actorId}")
	public ResponseEntity <List<FilmActor>> getFilmByActor(@PathVariable int actorId){
		return new ResponseEntity<>(filmActorRepository.findByActorId(actorId),HttpStatus.OK);
	}

	// ---------------------Languages---------------------

	// Returns all languages
	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}











}
