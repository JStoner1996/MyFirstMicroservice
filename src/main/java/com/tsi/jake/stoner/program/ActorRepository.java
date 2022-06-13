package com.tsi.jake.stoner.program;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
    List<Actor> findByFirstNameLikeOrLastNameLike(String firstName, String lastName);
}
