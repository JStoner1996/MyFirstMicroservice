package com.tsi.jake.stoner.program;

import javax.persistence.*;

@Entity
@Table(name="film")
public class Category {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int category_id;
    String name;

    // Constructor
    public Category(){}
    // Getters


    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }
}
