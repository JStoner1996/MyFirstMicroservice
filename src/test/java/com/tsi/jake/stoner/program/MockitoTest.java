package com.tsi.jake.stoner.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmRepository filmRepository;



    // Set up temp db
    @BeforeEach
    void setUp(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository);
    }

    @Test
    public void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }

    @Test
    public void getAllFilms(){
        myFirstMicroserviceApplication.getAllFilms();
        verify(filmRepository).findAll();
    }

    @Test
    public void testAddActor(){
        Actor newActor = new Actor("Tom", "Shanks");
        String expected = "Saved";
        String Actual = myFirstMicroserviceApplication.addActor(newActor.getFirstName(), newActor.getLastName());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, Actual, "Actor not saved in Database.");
    }

    @Test void testDeleteActor(){
        Actor newActor = new Actor("Tom", "Shanks");
        String expected = "Saved";
        String Actual = myFirstMicroserviceApplication.removeActor(2);
        verify(actorRepository).deleteById(1);
        Assertions.assertEquals(expected, Actual, "Actor 1 still in Database");

    }
}
