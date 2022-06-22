package com.tsi.jake.stoner.program.selenium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class getRandomFilmByCategoryStepsDef {

    private WebDriver driver;
    private String HOME_URL= "http://localhost:3000/";
    private String Expected;
    private String Actual;

    // Closes the window after a test is run

    @Given("The application is running")
    public void the_application_is_running() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @When("the category page is open")
    public void the_category_page_is_open() {
        driver.get("http://localhost:3000/Category");
    }

    @And ("The {string} button is clicked")
    public void the_button_is_clicked(String category) {
        System.out.println(category);
        Expected = driver.findElement(By.id("randomFilm")).getText();

        driver.findElement(By.id("randomBy" + category)).click(); // clicks certain button

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("randomFilm"), Expected));

        Actual = driver.findElement(By.id("randomFilm")).getText();

    }

    @Then("display a random film title and description")
    public void display_a_random_film_title_and_description() {

        Assertions.assertNotEquals(Expected, Actual, "randomFilm text not changed");
        //driver.navigate().refresh();
        driver.quit();
    }

//    WIP: Instead of manually writing each category name, get a list from the front end, get each element in that list, and use the text inside that element
//    List<WebElement> categoriesList = driver.findElements(By.id("categories"));
//      for(int i = 0; i < categoriesList.size() ; i++){
//        driver.findElement(By.id("randomBy" + categoriesList.get(i))).click();

}
