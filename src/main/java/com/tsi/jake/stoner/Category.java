package com.tsi.jake.stoner;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int category_id;
    String name;

    // Constructor

    public Category(int category_id, String name){
        this.category_id = category_id;
        this.name = name;
    }

    public Category(){}
    // Getters


    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
