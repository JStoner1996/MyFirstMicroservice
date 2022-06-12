package com.tsi.jake.stoner.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class MockitoTest {

    // @Mock - States that the object will be mock data
    @Mock
    private RandomFilmSelector randomFilmSelector;

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
    @Mock
    Film testFilm = new Film ("Chicken Run", "Chicken's Run", 150, 1);

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
        randomFilmSelector = new RandomFilmSelector(actorRepository, filmRepository, filmCategoryRepository, filmActorRepository,categoryRepository, languageRepository);
    }

    // ---------------------Actors--------------------- //

    @Test
     void getAllActors(){
        randomFilmSelector.getAllActors();
        verify(actorRepository).findAll();

    }
    @Test
     void testAddActor(){
        Actual = randomFilmSelector.addActor(newActor.getFirst_name(), newActor.getLast_name());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class); //Allows you to capture arguments passed to a method in this case, its catching the Actor class
        verify(actorRepository).save(actorArgumentCaptor.capture()); // Verify checks to make sure the method has run
        actorArgumentCaptor.getValue(); // From my understanding, it would get the last value added to the actorArgumentCaptor, in this case the Actor class
        Expected = "Actor added.";
        Assertions.assertEquals(Expected, Actual, "Actor not saved in Database.");
    }
//    @Test void testDeleteActor(){
//
//        when(myFirstMicroserviceApplication.removeActorByID((0)).
//
//
//        Actual = myFirstMicroserviceApplication.removeActor(newActor.getActor_id());
//        Expected = "Actor " + newActor.getActor_id() + " deleted.";
//
//        Assertions.assertEquals(Expected, Actual, "Actor " + newActor.getActor_id() + " still exists");
//
//
//    }


//    @Test void testUpdateActor(){
//
//        String expected = "Actor " + newActor.getActor_id() + " updated.";
//        String Actual = myFirstMicroserviceApplication.updateActor(newActor.getActor_id(), "Steven", "Smith");
//        when(newActor.getActor_id()).thenReturn(1);
//        Assertions.assertEquals(expected, Actual, "Actor first name not updated");
//
//   }

    // ---------------------Films--------------------- //

    @Test
     void getFilmByKeyword(){
        String keyword = "Data";
        randomFilmSelector.getFilmByKeyword(keyword);
        verify(filmRepository).findByTitleLikeOrDescriptionLike("%"+ keyword + "%", "%" + keyword + "%");
    }

    @Test
     void getFilmByActor(){
        randomFilmSelector.getFilmByActor(1);
        verify(filmActorRepository).findByActorId(1);
    }
    @Test
     void getAllFilms(){
        List<Film> filmList = new ArrayList<>();
        filmList.add(testFilm);
        when(randomFilmSelector.getAllFilms()).thenReturn(filmList);
        Assertions.assertEquals(filmList, randomFilmSelector.getAllFilms());
    }

    @Test
     void getAllFilmCategories(){
        randomFilmSelector.getAllFilmCategories();
        verify(filmCategoryRepository).findAll();
    }
    @Test
     void getAllCategories(){
        randomFilmSelector.getAllCategories();
        verify(categoryRepository).findAll();
    }

//    @Test
//     void getFilmById(){
//        myFirstMicroserviceApplication.getFilmById(55);
//        verify(filmRepository).findById(55);
//    }

    // ---------------------Languages--------------------- //
    @Test
     void getAllLanguages(){
        randomFilmSelector.getAllLanguages();
        verify(languageRepository).findAll();
    }
}
