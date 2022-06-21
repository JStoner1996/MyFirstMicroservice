package com.tsi.jake.stoner.program.cucumber;

import com.tsi.jake.stoner.program.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)

class addActorStepsDef {
//
//
//    //Creates mock or fake data
//    @Mock
//    private RandomFilmSelector randomFilmSelector;
//
//    @Mock
//    private ActorRepository actorRepository;
//    @Mock
//    private FilmRepository filmRepository;
//    @Mock
//    private FilmCategoryRepository filmCategoryRepository;
//    @Mock
//    private FilmActorRepository filmActorRepository;
//    @Mock
//    private CategoryRepository categoryRepository;
//    @Mock
//    private LanguageRepository languageRepository;
//
//    @Mock
//    Actor testActor = new Actor ();
//
//    //Used for Assertions
//    String Expected;
//    String Actual;
//
//    // Ran before each Test, setting up mock repositories
//    @BeforeEach
//    void setup(){
//
//        actorRepository= mock(ActorRepository.class);
//        filmRepository= mock(FilmRepository.class);
//        filmCategoryRepository= mock(FilmCategoryRepository.class);
//        filmActorRepository= mock(FilmActorRepository.class);
//        categoryRepository= mock(CategoryRepository.class);
//        languageRepository = mock(LanguageRepository.class);
//
//        randomFilmSelector = new RandomFilmSelector(actorRepository, filmRepository, filmCategoryRepository, filmActorRepository, categoryRepository, languageRepository);
//
//    }
//
//    @Given("I have Actor information")
//    public void i_have_actor_information() {
//        testActor.setFirstName("First");
//        testActor.setLastName("Last");
//        testActor.setActorId(1);
//
//    }
//
//    @When("The information is inputted")
//    public void the_information_is_inputted() {
//        setup();
//    Actual = randomFilmSelector.addActor(testActor.getFirstName(), testActor.getLastName());
//    }
//
//    @Then("I get a return string, confirming the success")
//    public void i_get_a_return_string_confirming_the_success() {
//    Expected = "Actor added.";
//    Assertions.assertEquals(Expected, Actual, "Actor not added.");
//    }

}
