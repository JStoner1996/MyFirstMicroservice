
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


	private String saved = "Saved";
	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository, FilmRepository filmRepository){
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;




	}



	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
	return actorRepository.findAll();
	}

	@PostMapping("/Add_Actor")
	public @ResponseBody String addActor (@RequestParam String firstName, String lastName){
		Actor addActor = new Actor(firstName, lastName);
		actorRepository.save(addActor);
		return saved;
	}

	@DeleteMapping("/Delete_Actor")
	public @ResponseBody String removeActor (@RequestParam int actorID){
		actorRepository.deleteById(actorID);
		return saved;
	}
	@GetMapping("/All_Films")
	public @ResponseBody
	Iterable<Film>getAllFilms(){
		return filmRepository.findAll();
	}





}
