package com.tsi.jake.stoner.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private FilmCategoryRepository filmCategoryRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private LanguageRepository languageRepository;

    @Mock
    Actor newActor = new Actor("Tom", "Shanks");



    // Set up temp db
    @BeforeEach
    void setUp(){
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, filmCategoryRepository, categoryRepository, languageRepository);
    }

    // ---------------------Actors--------------------- //
    @Test
    public void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }
    @Test
    public void testAddActor(){
        String Expected = "Actor added.";
        String Actual = myFirstMicroserviceApplication.addActor(newActor.getFirst_name(), newActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(Expected, Actual, "Actor not saved in Database.");

    }

    @Test void setActorId(){
        Actor testActor = new Actor("Test", "Test");
        testActor.setActor_id(3);
        Assertions.assertEquals(3, testActor.getActor_id(), "Actor ID not set");
    }

    @Test void testDeleteActor(){
        when(newActor.getActor_id()).thenReturn(1);
        String Actual = myFirstMicroserviceApplication.removeActor(newActor.getActor_id());
        Assertions.assertEquals("Actor " + newActor.getActor_id() + " deleted.", Actual, "Actor " + newActor.getActor_id() + " exists");

    }


//    @Test void testUpdateActor(){
//        when(newActor.getActor_id()).thenReturn(1);
//        actorRepository.save(newActor);
//        String expected = "Actor " + newActor.getActor_id() + " updated.";
//        String Actual = myFirstMicroserviceApplication.updateActor(newActor.getActor_id(), "Steven", "Smith");
//        Assertions.assertEquals(expected, Actual, "Actor first name not updated");
//
//    }

    // ---------------------Films--------------------- //
    @Test
    public void getAllFilms(){
        myFirstMicroserviceApplication.getAllFilms();
        verify(filmRepository).findAll();
    }

    @Test
    public void getAllFilmCategories(){
        myFirstMicroserviceApplication.getAllFilmCategories();
        verify(filmCategoryRepository).findAll();
    }
    @Test
    public void getAllCategories(){
        myFirstMicroserviceApplication.getAllCategories();
        verify(categoryRepository).findAll();
    }

    @Test
    public void getFilmById(){
        myFirstMicroserviceApplication.getFilmById(55);
        verify(filmRepository).findById(55);
    }

    // ---------------------Languages--------------------- //
    @Test
    public void getAllLanguages(){
        myFirstMicroserviceApplication.getAllLanguages();
        verify(languageRepository).findAll();
    }
}
