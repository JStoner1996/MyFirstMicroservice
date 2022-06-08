package com.tsi.jake.stoner.program;

import javax.persistence.*;

@Entity
@Table(name="language")

public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Attributes
    int language_id;
    String name;
    // Constructor
    public Language(){}

    // Getters


    public int getLanguage_id() {
        return language_id;
    }

    public String getName() {
        return name;
    }
}
