
package com.tsi.jake.stoner.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
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
			CategoryRepository categoryRepository,
			LanguageRepository languageRepository){

		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
		this.filmCategoryRepository = filmCategoryRepository;
		this.categoryRepository = categoryRepository;
		this.languageRepository = languageRepository;
	}


	// ---------------------Actors---------------------
	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}

	@PostMapping("/Add_Actor")
	public @ResponseBody String addActor (@RequestParam String first_name, @RequestParam String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return saved;
	}
	@DeleteMapping("/Delete_Actor")
	public @ResponseBody String removeActor (@RequestParam int actor_id){
		if(actorRepository.existsById(actor_id)) {
			Actor deleteActor = actorRepository.findById(actor_id).get();
			actorRepository.delete(deleteActor);
			return "Actor " + actor_id + " deleted.";
		} else {
			return "Actor " + actor_id + " not found.";
		}
	}

	@PutMapping ("/Update_Actor")
	public @ResponseBody String updateActor(@RequestParam int actor_id, String first_name, String last_name){

		if(actorRepository.existsById(actor_id)) {
			Actor actor = actorRepository.findById(actor_id).get();
			actor.setFirst_name(first_name);
			actor.setLast_name(last_name);
			actorRepository.save(actor);
			return "Actor " + actor_id + " updated.";
		} else {
			return "Actor " + actor_id + " not found.";
		}
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


	@GetMapping("/Film_By_ID")
	public @ResponseBody Optional<Film> getFilmById (@RequestParam int film_id){
		return filmRepository.findById(film_id);
	}




	// ---------------------Languages---------------------
	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}











}
