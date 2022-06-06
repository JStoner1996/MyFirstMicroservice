package com.tsi.jake.stoner.program;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name="actor")

public class Actor {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorID;
    String firstName;
    String lastName;

    //Constructors
    public Actor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Actor(){}

    //Methods


    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
