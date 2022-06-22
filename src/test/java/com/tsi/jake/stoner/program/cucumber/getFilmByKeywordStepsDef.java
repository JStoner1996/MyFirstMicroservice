package com.tsi.jake.stoner.program.cucumber;

import com.tsi.jake.stoner.program.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class getFilmByKeywordStepsDef {

    private WebDriver driver;
    private String HOME_URL= "http://localhost:3000/";
    private String Expected;
    private String Actual;


    private String keyword;

    List <Film> keywordFilmList;
    List <Film> filmList;

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




    @Given("I have a repository")
    public void iHaveARepository() {
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

        Film testFilm = new Film (1,"Test Film", "Film Test", 100, 1 );
        Film testFilm2 = new Film (2,"Test Film 2", "Film Test 2", 120, 1 );
        filmList = new ArrayList<>();
        filmList.add(testFilm);
        filmList.add(testFilm2);
    }

    @When("The inputted word exists in title or description of a movie")
    public void theInputtedWordExistsInTitleOrDescriptionOfAMovie() {
        keyword = "Test";
        when(filmRepository.findByTitleLikeOrDescriptionLike(keyword, keyword)).thenReturn(filmList);
        keywordFilmList = randomFilmSelector.getFilmByKeyword(keyword);

    }

    @Then("A list of films that contain the keyword will be returned")
    public void aListOfFilmsThatContainTheKeywordWillBeReturned() {
        Assertions.assertEquals(true,  keywordFilmList != null, "Film list is empty");
    }
}
