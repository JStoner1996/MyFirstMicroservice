package com.tsi.jake.stoner.controllers;

import com.tsi.jake.stoner.Actor;
import com.tsi.jake.stoner.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ActorController {
    @Autowired
    private ActorRepository actorRepository;

    static final String ACTOR_STRING = "Actor ";
    static final String DOES_NOT_EXIST = " does not exist";


    public ActorController(ActorRepository actorRepository){
        this.actorRepository = actorRepository;

    }

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
}
