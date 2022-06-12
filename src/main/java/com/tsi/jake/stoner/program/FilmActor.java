package com.tsi.jake.stoner.program;

import javax.persistence.*;

@Entity
@Table(name="film_actor")

public class FilmActor {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "film_id")
    int filmId;

    @Column (name = "actor_id")
    int actorId;
    // Constructor

    public FilmActor(int actorId, int filmId) {
        this.actorId = actorId;
        this.filmId = filmId;
    }

    public FilmActor(){}

    // Getters
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
