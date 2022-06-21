package com.tsi.jake.stoner.program.mockito;

import com.tsi.jake.stoner.program.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class MockitoTest {

    // @Mock - States that the object will be mock data
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

    private Random random;

    @Mock
    Actor newActor1 = new Actor(1, "Tom", "Shanks");
    @Mock
    Actor newActor2 = new Actor(2, "Tom", "Shanks");
    @Mock
    Film testFilm1 = new Film (1, "Chicken Run", "Chicken's Run", 150, 1);
    @Mock
    Film testFilm2 = new Film (2, "Shark's Tail", "Shark's Run", 150, 1);
    @Mock
    FilmCategory testFilmCategory1 = new FilmCategory (1, 1);
   @Mock
   FilmCategory testFilmCategory2 = new FilmCategory (2, 2);



    @Mock Category testCategoryAction = new Category(1, "Action");
    @Mock Category testCategoryAnimation = new Category(2, "Animation");

    //Used for Assertions
    String Expected;
    String Actual;


    // Ran before each Test, setting up mock repositories
    @BeforeEach
    void setUp(){
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
        Actual = randomFilmSelector.addActor(newActor1.getFirstName(), newActor1.getLastName());
        ArgumentCaptor<Actor> actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class); //Allows you to capture arguments passed to a method in this case, its catching the Actor class
        verify(actorRepository).save(actorArgumentCaptor.capture()); // Verify checks to make sure the method has run
        actorArgumentCaptor.getValue(); // From my understanding, it would get the last value added to the actorArgumentCaptor, in this case the Actor class
        Expected = "Actor added.";
        Assertions.assertEquals(Expected, Actual, "Actor not saved in Database.");
    }


    // ---------------------Films--------------------- //

//    @Test
//     void testGetFilmByKeyword(){
//        String keyword = "Chicken";
//        List<Film> filmList = new ArrayList<>();
//        filmList.add(testFilm1);
//        filmList.add(testFilm2);
//
//        randomFilmSelector.getFilmByKeyword(keyword);
//        verify(filmRepository).findByTitleLikeOrDescriptionLike("%"+ keyword + "%", "%" + keyword + "%");
//        Expected = "Chicken Run";
//        Film randomFilm = randomFilmSelector.getRandomFilmByKeyword(keyword);
//        Actual = randomFilm.getTitle();
//        Assertions.assertEquals(Expected, Actual, "Random by keyword, incorrect");
//    }

    @Test
     void getFilmByActor(){
        randomFilmSelector.getFilmByActor(1);
        verify(filmActorRepository).findByActorId(1);
    }
    @Test
     void getAllFilms(){
        List<Film> filmList = new ArrayList<>();
        filmList.add(testFilm1);
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

    @Test
    public void testGetCategory (){

       List<Category> categoryList = new ArrayList<>();
       categoryList.add(testCategoryAction);
       when(randomFilmSelector.getAllCategories()).thenReturn(categoryList);
       Assertions.assertEquals(categoryList, randomFilmSelector.getAllCategories(), "Category has failed");
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
