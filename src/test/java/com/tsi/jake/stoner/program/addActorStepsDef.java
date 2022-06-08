//package com.tsi.jake.stoner.program;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.mockito.Mock;
//
//public class addActorStepsDef {
//
//    private Actor testActor;
//    private String firstName;
//    private String lastName;
//
//
//
//    @Given("I have Actor information")
//    public void i_have_actor_information() {
//        firstName = "First";
//        lastName = "Last";
//
//    }
//    @When("The information is inputted")
//    public void the_information_is_inputted(String firstName, String lastName) {
//
//    }
//
//    @Then("I get a return string, confirming the success")
//    public void i_get_a_return_string_confirming_the_success() {
//
//
//
//        Assertions.assertEquals("Saved", "Saved", "Actor not added");
//        throw new io.cucumber.java.PendingException();
//    }
//}
