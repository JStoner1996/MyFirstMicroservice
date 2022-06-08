package com.tsi.jake.stoner.program;

import javax.persistence.*;


@Entity
@Table(name="film")

public class Film{

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmID;

    String title;
    String description;

    int length;
    int language_id;

    //Constructors


    public Film(String title, String description, int length, int language_id) {
        this.title = title;
        this.description = description;
        this.length = length;
        this.language_id = language_id;
    }

    public Film(){}

    //Methods

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public int getLength() {
        return length;
    }

    public int getLanguage_id() {
        return language_id;
    }
}
