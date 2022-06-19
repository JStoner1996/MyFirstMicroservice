package com.tsi.jake.stoner.program.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
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

    // Closes the window after a test is run


    @Given("The application is running")
    public void the_application_is_running() {
        System.setProperty("webdriver.chrome.driver", "D:\\TSI\\SeleniumWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    // and
    @When("the category page is open")
    public void the_category_page_is_open() {
        driver.get("http://localhost:3000/Category");
    }


    // WIP: Instead of manually writing each category name, get a list from the front end, get each element in that list, and use the text inside that element
//    List<WebElement> categoriesList = driver.findElements(By.id("categories"));
//      for(int i = 0; i < categoriesList.size() ; i++){
//        driver.findElement(By.id("randomBy" + categoriesList.get(i))).click();
//    }


    @Then("A button is clicked to display a random film title and description")
    public void a_button_is_clicked_to_display_a_random_film_title_and_description() {

        String Expected = "Your Random Film will be displayed here!";
        // loops through array of catergories and
        for (int i = 0; i < categories.length; i++) {
            driver.navigate().refresh(); // Refresh page to reset text
            driver.findElement(By.id("randomBy" + categories[i])).click(); // clicks certain button

            String Actual = driver.findElement(By.id("randomFilm")).getText();
            Assertions.assertNotEquals(Expected, Actual, "randomFilm text not changed");
        }

        driver.quit();
    }
}
