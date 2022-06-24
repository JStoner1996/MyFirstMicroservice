package com.tsi.jake.stoner.program.mockito;

import com.beust.ah.A;
import com.tsi.jake.stoner.program.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MockitoTests {

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

    @BeforeEach
    void setup(){
        actorRepository = mock(ActorRepository.class);
        filmRepository = mock(FilmRepository.class);
        filmCategoryRepository = mock(FilmCategoryRepository.class);
        filmActorRepository = mock(FilmActorRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        languageRepository = mock(LanguageRepository.class);

        randomFilmSelector = new RandomFilmSelector(
                actorRepository,
                filmRepository,
                filmCategoryRepository,
                filmActorRepository,
                categoryRepository,
                languageRepository);


    }

    // Get All Tests
    @Test
    void testGetAllFilms(){
        // Create list
        List <Film> filmList = new ArrayList<>();

        Film testFilm = new Film (1,"Test Film", "Film Test", 100, 1 );
        Film testFilm2 = new Film (2,"Test Film 2", "Film Test 2", 120, 1 );

        filmList.add(testFilm);
        filmList.add(testFilm2);

        // Creates iterable from the list
        Iterable <Film> filmIterable = filmList;

        // Defines behaviour of mock repos method
        when(filmRepository.findAll()).thenReturn(filmIterable);

        // Sets my expected and actual variables
        Iterable <Film> Expected = filmIterable;
        Iterable <Film> Actual = randomFilmSelector.getAllFilms();
        // For debugging purposes
        //System.out.println(randomFilmSelector.getAllFilms().iterator().next().getTitle());

        Assertions.assertEquals(Expected, Actual, "Get all films returns wrong");
    }

    @Test
    void testGetAllActors(){
        // Create list
        List <Actor> actorList = new ArrayList<>();

        Actor testActor = new Actor (1, "First", "Last");
        Actor testActor2 = new Actor (2,"Last", "First");

        actorList.add(testActor);
        actorList.add(testActor2);

        // Creates iterable from the list
        Iterable <Actor> actorIterable = actorList;

        // Defines behaviour of mock repos method
        when(actorRepository.findAll()).thenReturn(actorIterable);

        // Sets my expected and actual variables
        Iterable <Actor> Expected = actorIterable;
        Iterable <Actor> Actual = randomFilmSelector.getAllActors();

        // For debugging purposes
        //System.out.println(randomFilmSelector.getAllActors().iterator().next().getFirstName());

        Assertions.assertEquals(Expected, Actual, "Get all actors returns wrong");
    }

    @Test
    void testGetAllFilmCategories(){
        // Create list
        List <FilmCategory> filmCategoryList = new ArrayList<>();

        FilmCategory testFilmCategory = new FilmCategory (1, 1);
        FilmCategory testFilmCategory2 = new FilmCategory (2, 2);

        filmCategoryList.add(testFilmCategory);
        filmCategoryList.add(testFilmCategory2);

        // Creates iterable from the list
        Iterable <FilmCategory> filmCategoryIterable = filmCategoryList;

        // Defines behaviour of mock repos method
        when(filmCategoryRepository.findAll()).thenReturn(filmCategoryIterable);

        // Sets my expected and actual variables
        Iterable <FilmCategory> Expected = filmCategoryIterable;
        Iterable <FilmCategory> Actual = randomFilmSelector.getAllFilmCategories();

        // For debugging purposes
        //System.out.println(randomFilmSelector.getAllFilmCategories().iterator().next().getCategoryId());

        Assertions.assertEquals(Expected, Actual, "Get all film categories returns wrong");
    }

    @Test
    void testGetAllCategories(){
        // Create list
        List <Category> filmCategoryList = new ArrayList<>();

        Category category = new Category (1, "Action");
        Category category2 = new Category (2, "Animation");

        filmCategoryList.add(category);
        filmCategoryList.add(category2);

        // Creates iterable from the list
        Iterable <Category> filmCategoryIterable = filmCategoryList;

        // Defines behaviour of mock repos method
        when(categoryRepository.findAll()).thenReturn(filmCategoryIterable);

        // Sets my expected and actual variables
        Iterable <Category> Expected = filmCategoryIterable;
        Iterable <Category> Actual = randomFilmSelector.getAllCategories();;

        // For debugging purposes
        System.out.println(randomFilmSelector.getAllCategories().iterator().next().getName());

        Assertions.assertEquals(Expected, Actual, "Get all categories returns wrong");
    }

    @Test
    void testGetAllLanguages(){
        // Create list
        List <Language> languageList = new ArrayList<>();

        Language testLanguage = new Language (1, "English");
        Language testLanguage2 = new Language (2, "French");

        languageList.add(testLanguage);
        languageList.add(testLanguage2);

        // Creates iterable from the list
        Iterable <Language> languageIterable = languageList;

        // Defines behaviour of mock repos method
        when(languageRepository.findAll()).thenReturn(languageIterable);

        // Sets my expected and actual variables
        Iterable <Language> Expected = languageIterable;
        Iterable <Language> Actual = randomFilmSelector.getAllLanguages();

        // For debugging purposes
        System.out.println(randomFilmSelector.getAllLanguages().iterator().next().getName());

        Assertions.assertEquals(Expected, Actual, "Get all languages returns wrong");
    }

    @Test
    void testGetAllFilmActors(){
        // Create list
        List <FilmActor> filmActorList = new ArrayList<>();

        FilmActor testFilmActor = new FilmActor (1, 1);
        FilmActor testFilmActor2 = new FilmActor (2, 2);

        filmActorList.add(testFilmActor);
        filmActorList.add(testFilmActor2);
        // Creates iterable from the list
        Iterable <FilmActor> filmActorIterable = filmActorList;

        // Defines behaviour of mock repos method
        when(filmActorRepository.findAll()).thenReturn(filmActorIterable);

        // Sets my expected and actual variables
        Iterable <FilmActor> Expected = filmActorIterable;
        Iterable <FilmActor> Actual = randomFilmSelector.getAllFilmActors();

        // For debugging purposes
        System.out.println(randomFilmSelector.getAllFilmActors().iterator().next().getFilmId());

        Assertions.assertEquals(Expected, Actual, "Get all film actors returns wrong");
    }

// NOT WORKING CORRECT

    @Test
    void testGetFilmById(){
        // Create films and adds them to a list
        List <Film> filmList = new ArrayList<>();
        Film testFilm1 = new Film (1, "Test Film", "Film Test", 100, 1);
        Film testFilm2 = new Film (2, "Film Test", "Test Film", 100, 1);
        filmList.add(testFilm1);
        filmList.add(testFilm2);

        // Defines behaviour of mock repos method
        when(filmRepository.findById(1)).thenReturn(Optional.of(testFilm1));

        // Sets expected and actual variable
        Optional<Film> Expected = Optional.of(testFilm1);
        Optional<Film> Actual = randomFilmSelector.getFilmById(1);

        Assertions.assertEquals(Expected, Actual, "Get film by id, returned wrong film");
    }



    @Test
    void testGetFilmByKeyword(){
        String keyword ="Shark";
        List <Film> filmList = new ArrayList<>();
        Film testFilm1 = new Film (1, "Chicken Run", "Birds", 100, 1);
        Film testFilm2 = new Film (2, "Shark Tail", "Drama about fish", 100, 1);
        filmList.add(testFilm1);
        filmList.add(testFilm2);


        when(filmRepository.findByTitleLikeOrDescriptionLike("%" + keyword + "%", "%" + keyword + "%")).thenReturn(filmList);

        List <Film> Expected = filmList;
        List <Film> Actual = randomFilmSelector.getFilmByKeyword(keyword);

        Assertions.assertEquals(Expected, Actual, "Get film by keyword, returned wrong film");
    }

@Test
    void testGetLanguageIdByName (){
        String name = "English";
        Language testLanguage = new Language(1, "English");
        Language testLanguage2 = new Language(2, "French");

        when(languageRepository.findByName(name)).thenReturn(testLanguage);

        // Sets expected and actual variable
        int Expected = testLanguage.getLanguageId();
        int Actual = randomFilmSelector.getLanguageIDByName(name);

         Assertions.assertEquals(Expected, Actual, "Get language id by name, returned wrong film");
}
@Test
void testGetActorIdByName (){
    String name = "Bob";
    List <Actor> actorList = new ArrayList<>();

    Actor testActor = new Actor (1, "Bob", "Marley");
    Actor testActor2 = new Actor (2,"Last", "First");

    actorList.add(testActor);
    actorList.add(testActor2);

    when(actorRepository.findByFirstNameLikeOrLastNameLike("%" + name + "%", "%" + name + "%")).thenReturn(actorList);

    // Sets expected and actual variable
    int Expected = testActor.getActorId();
    int Actual = randomFilmSelector.getActorIdByName(name).get(0).getActorId();

    Assertions.assertEquals(Expected, Actual, "Get Actor id by name, returned wrong actor");
}

//@Test
//    void testRandomActorByName(){
//
//    List <Actor> actorList = new ArrayList<>();
//    Actor testActor = new Actor (1, "Bob", "Marley");
//    Actor testActor2 = new Actor (1, "Smith", "Rowe");
//    actorList.add(testActor);
//    actorList.add(testActor2);
//
//    when(randomFilmSelector.getRandomActorId("Bob")).thenReturn(actorList);
//
//}




//    @Test
//    void testUpdateActor (){
//        Actor testActor = new Actor(1, "Jim", "Bob");
//        String Expected = testActor.getFirstName();
//        when(randomFilmSelector.updateActor(1, "First", "Last")).thenReturn("Actor 1 updated.");
//        String firstName = testActor.getFirstName();
//        Assertions.assertEquals(Expected, firstName, "Get film by keyword, returned wrong film");
//
//    }
}
