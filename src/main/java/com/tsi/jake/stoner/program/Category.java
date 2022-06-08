package com.tsi.jake.stoner.program;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

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
