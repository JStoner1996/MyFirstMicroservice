package com.tsi.jake.stoner.program;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="film")

public class Film{

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmID;

    String title;
    String description;

    java.sql.Date release_year;
    int length;
    int language_id;

    //Constructors


    public Film(String title, String description, Date release_year, int length, int language_id) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
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

    public Date getRelease_year() {
        return release_year;
    }

    public int getLength() {
        return length;
    }

    public int getLanguage_id() {
        return language_id;
    }
}
