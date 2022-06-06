package com.tsi.jake.stoner.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin (origins = "*") // needed for recieving request via api
@SpringBootApplication
@RestController // Handles GET, POST, DELETE, PUT requests
@RequestMapping("/home")//base url
public class MyFirstMicroserviceApplication {

	@Autowired
	private ActorRepository actorRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceApplication.class, args);
	}

	public MyFirstMicroserviceApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}


	@GetMapping("/All_Actors")
	public @ResponseBody
	Iterable<Actor>getAllActors(){
		return actorRepository.findAll();
	}
}
