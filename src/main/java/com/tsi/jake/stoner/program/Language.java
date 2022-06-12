package com.tsi.jake.stoner.program;

import javax.persistence.*;

@Entity
@Table(name="language")

public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Attributes
    @Column (name = "language_id")
    int languageId;
    String name;
    // Constructor

    public Language(int languageId, String name) {
        this.languageId = languageId;
        this.name = name;
    }

    public Language(){}

    // Getters & Setters

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
