package com.tsi.jake.stoner.program;

import javax.persistence.*;

@Entity
@Table(name="language")

public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Attributes
    @Column (name = "language_id")
    int language_id;
    String name;
    // Constructor

    public Language(int language_id, String name) {
        this.language_id = language_id;
        this.name = name;
    }

    public Language(){}

    // Getters & Setters

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
