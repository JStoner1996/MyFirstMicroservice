package com.tsi.jake.stoner.program.cucumber;

import com.tsi.jake.stoner.program.FilmRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class getRandomFilmByKeyword {

    private WebDriver driver;
    private String HOME_URL= "http://localhost:3000/";
    private String Expected;
    private String Actual;

    private FilmRepository filmRepository;

    @Given("The chosen word exists in either title or description")
    public void theChosenWordExistsInEitherTitleOrDescription() {
        filmRepository.findByTitleLikeOrDescriptionLike("test", "test");

    }

    @When("I run the method")
    public void iRunTheMethod() {
    }

    @Then("I will be shown a list of movies that contain the keyword")
    public void iWillBeShownAListOfMoviesThatContainTheKeyword() {
    }


}
