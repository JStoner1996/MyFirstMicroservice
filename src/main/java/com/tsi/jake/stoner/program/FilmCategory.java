package com.tsi.jake.stoner.program;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="film_category")

public class FilmCategory {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int film_id;
    int category_id;
    // Constructor
    public FilmCategory(){}
    // Getters


    public int getFilm_id() {
        return film_id;
    }

    public int getCategory_id() {
        return category_id;
    }
}
