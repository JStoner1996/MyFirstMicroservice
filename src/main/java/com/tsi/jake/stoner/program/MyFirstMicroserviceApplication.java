
package com.tsi.jake.stoner.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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
	public @ResponseBody String addActor (@RequestParam String firstName, @RequestParam String lastName){
		Actor addActor = new Actor(firstName, lastName);
		actorRepository.save(addActor);
		return saved;
	}
	@DeleteMapping("/Delete_Actor")
	public @ResponseBody String removeActor (@RequestParam int actorID){
		actorRepository.deleteById(actorID);
		return saved;
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
	public @ResponseBody Optional<Film> getFilmById (@RequestParam int filmID){

		return filmRepository.findById(filmID);
	}

	// ---------------------Languages---------------------
	@GetMapping("/All_Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}











}
