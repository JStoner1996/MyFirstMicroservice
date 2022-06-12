package com.tsi.jake.stoner;

import javax.persistence.*;

@Entity
@Table(name="film_actor")

public class FilmActor {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int film_id;

    @Column (name = "actor_id")
    int actorId;
    // Constructor

    public FilmActor(int actorId, int film_id) {
        this.actorId = actorId;
        this.film_id = film_id;
    }

    public FilmActor(){}

    // Getters
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
