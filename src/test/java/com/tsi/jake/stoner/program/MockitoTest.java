package com.tsi.jake.stoner.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    // @Mock - States that the object will be mock data
    @Mock
    private MyFirstMicroserviceApplication myFirstMicroserviceApplication;

    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private FilmCategoryRepository filmCategoryRepository;
    @Mock
    private FilmActorRepository filmActorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private LanguageRepository languageRepository;

    @Mock
    Actor newActor = new Actor(1, "Tom", "Shanks");

    //Used for Assertions
    String Expected;
    String Actual;

    // Ran before each Test, setting up mock repositories
    @BeforeEach
    void setUp(){
        actorRepository= mock(ActorRepository.class);
        filmRepository= mock(FilmRepository.class);
        filmCategoryRepository= mock(FilmCategoryRepository.class);
        filmActorRepository= mock(FilmActorRepository.class);
        categoryRepository= mock(CategoryRepository.class);
        languageRepository = mock(LanguageRepository.class);
        myFirstMicroserviceApplication = new MyFirstMicroserviceApplication(actorRepository, filmRepository, filmCategoryRepository, filmActorRepository,categoryRepository, languageRepository);
    }

    // ---------------------Actors--------------------- //

    @Test
    public void getAllActors(){
        myFirstMicroserviceApplication.getAllActors();
        verify(actorRepository).findAll();

    }
    @Test
    public void testAddActor(){
        Actual = myFirstMicroserviceApplication.addActor(newActor.getFirst_name(), newActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Expected = "Actor added.";
        Assertions.assertEquals(Expected, Actual, "Actor not saved in Database.");

    }
//    @Test void testDeleteActor(){
//
//        Mockito.when(newActor.getActor_id()).thenReturn(1);
//        Actual = myFirstMicroserviceApplication.removeActor(newActor.getActor_id());
//        Expected = "Actor " + newActor.getActor_id() + " deleted.";
//        Assertions.assertEquals(Expected, Actual, "Actor " + newActor.getActor_id() + " still exists");
//
//
//    }


//    @Test void testUpdateActor(){
//        when(newActor.getActor_id()).thenReturn(1);
//        String expected = "Actor " + newActor.getActor_id() + " updated.";
//        String Actual = myFirstMicroserviceApplication.updateActor(newActor.getActor_id(), "Steven", "Smith");
//        Assertions.assertEquals(expected, Actual, "Actor first name not updated");
//
//   }

    // ---------------------Films--------------------- //

    @Test
    public void getFilmByKeyword(){
        String keyword = "Data";
        myFirstMicroserviceApplication.getFilmByKeyword(keyword);
        verify(filmRepository).findByTitleLikeOrDescriptionLike("%"+ keyword + "%", "%" + keyword + "%");
    }
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
