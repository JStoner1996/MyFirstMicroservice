package com.tsi.jake.stoner.program;

import javax.persistence.*;

@Entity
@Table(name="film_category")

public class FilmCategory {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "film_id")
    int filmId;
    @Column (name = "category_id")
    int categoryId;
    // Constructor

    public FilmCategory(int filmId, int categoryId) {
        this.filmId = filmId;
        this.categoryId = categoryId;
    }

    public FilmCategory(){}

    // Getters
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
