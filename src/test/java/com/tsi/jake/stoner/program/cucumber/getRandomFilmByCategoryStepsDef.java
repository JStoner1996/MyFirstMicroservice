package com.tsi.jake.stoner.program.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class getRandomFilmByCategoryStepsDef {

    private WebDriver driver;
    private String HOME_URL= "http://localhost:3000/";

    String [] categories = {"Action", "Animation", "Children", "Classics", "Comedy", "Documentary", "Drama", "Family", "Foreign", "Games", "Horror", "Music", "New", "Sci-Fi", "Sports", "Travel" };

    @Given("Chrome is open and the application is running")
    public void chrome_is_open_and_the_application_is_running() {
        System.setProperty("webdriver.chrome.driver", "D:\\TSI\\SeleniumWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/Category");
    }

    @When("A button is clicked")
    public void A_button_is_clicked() {
        for (int i = 0; i < categories.length; i++) {
            driver.findElement(By.id("randomBy" + categories[i])).click();
        }
    }

    // WIP: Instead of manually writing each category name, get a list from the front end, get each element in that list, and use the text inside that element
//    List<WebElement> categoriesList = driver.findElements(By.id("categories"));
//      for(int i = 0; i < categoriesList.size() ; i++){
//        driver.findElement(By.id("randomBy" + categoriesList.get(i))).click();
//    }



    @Then("Display random film title and description")
    public void display_random_film_title_and_description() {
        String Actual = driver.findElement(By.id("randomFilm")).getText();
        String Expected = "Your Random Film will be displayed here!";
        Assertions.assertNotEquals(Expected, Actual, "randomFilm text not changed");
        driver.quit();
    }
}
