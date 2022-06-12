package com.tsi.jake.stoner.program;

import javax.persistence.*;


@Entity
@Table(name="film")

public class Film{

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    int filmId;

    String title;
    String description;

    int length;

    @Column (name = "language_id")
    int languageId;

    //Constructors


    public Film(String title, String description, int length, int languageId) {
        this.title = title;
        this.description = description;
        this.length = length;
        this.languageId = languageId;
    }

    public Film(int filmId, String title, String description, int length, int languageId) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.length = length;
        this.languageId = languageId;
    }
    public Film(){}

    //Methods


    // Getters & Setters
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
