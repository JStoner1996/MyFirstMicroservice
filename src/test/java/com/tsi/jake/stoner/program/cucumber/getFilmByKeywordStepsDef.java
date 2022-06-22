package com.tsi.jake.stoner.program.cucumber;

import com.tsi.jake.stoner.program.Film;
import com.tsi.jake.stoner.program.FilmRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class getFilmByKeywordStepsDef {

    private WebDriver driver;
    private String HOME_URL= "http://localhost:3000/";
    private String Expected;
    private String Actual;


    private String keyword;

    List <Film> filmList;
    private FilmRepository filmRepository;

    @Given("I have inputted a word")
    public void iHaveInputtedAWord() {
        keyword = "data";
    }

    @When("I search for film")
    public void iSearchForFilm() {
        filmList =  filmRepository.findByTitleLikeOrDescriptionLike(keyword, keyword);
    }

    @And("The inputted word exists in title or description of a movie")
    public void theInputtedWordExistsInTitleOrDescriptionOfAMovie() {

        System.out.println(filmList);

        Assertions.assertEquals(false,  filmList != null, "Film list is empty");
    }

    @Then("I will be shown a list of movies that contain the keyword")
    public void iWillBeShownAListOfMoviesThatContainTheKeyword() {
    }


}
