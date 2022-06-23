package com.tsi.jake.stoner.program.selenium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SeleniumTest {

    WebDriver driver;
    String Expected;
    String Actual;

    private final String HOME_URL= "http://localhost:3000/";

    // Goes through each random by film that has user input, inputs something,  and checks the button works
    @ParameterizedTest
    @CsvSource({
            "Keyword, keyword, randomByKeyword , Shark",
            "Length, length, randomByLength, 100" ,
            "Actor, actorName, randomByActor, Bob",

    })
     void testRandomFilmByKeyword (String URL, String id, String id2, String input) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://localhost:3000/" + URL);

        Expected = driver.findElement(By.id("randomFilm")).getText();

        driver.findElement(By.id(id)).sendKeys(input);
        driver.findElement(By.id(id2)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("randomFilm"), Expected));

        Actual = driver.findElement(By.id("randomFilm")).getText();
        Assertions.assertNotEquals(Expected, Actual, id2 + " has failed.");
        driver.quit();

    }

    @ParameterizedTest
    @CsvSource({
            "goToActorButton, Actor",
            "goToCategoryButton, Category",
            "goToKeywordButton, Keyword",
            "goToLanguageButton, Language",
            "goToLengthButton, Length"
    })
    void testNavButtons(String id, String word){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://localhost:3000/");

        driver.findElement(By.id(id)).click();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, HOME_URL + word, "Incorrect Page");

        driver.quit();
    }
}
