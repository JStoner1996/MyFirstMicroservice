package com.tsi.jake.stoner.program.selenium;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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


public class GetRandomFilmButtonsTest {

//    WebDriver driver;
//    String Expected;
//    String Actual;
//
//    private final String HOME_URL= "http://localhost:3000/";
//    // Creates new window for selenium to use before each test is ran
//    @BeforeEach
//    public void setUp() {
////        WebDriverManager.chromedriver().setup();
////        driver = new ChromeDriver();
//    }
//
//    // Closes the window after a test is run
//    @AfterEach
//    public void tearDown() {
////        driver.quit();
//    }
//
//    //Tests that each button can be clicked
//
//
//
//    // Goes through each random by film that has user input, and checks the button works
//    @ParameterizedTest
//    @CsvSource({
//            "Keyword, keyword, randomByKeyword , Shark",
//            "Length, length, randomByLength, 100" ,
//            "Actor, actorName, randomByActor, Bob",
//
//    })
//     void testRandomFilmByKeyword (String URL, String id, String id2, String input) {
//        driver.get("http://localhost:3000/" + URL);
//
//        Expected = driver.findElement(By.id("randomFilm")).getText();
//
//        driver.findElement(By.id(id)).sendKeys(input);
//        driver.findElement(By.id(id2)).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("randomFilm"), Expected));
//
//        Actual = driver.findElement(By.id("randomFilm")).getText();
//        Assertions.assertNotEquals(Expected, Actual, id2 + " has failed.");

//}

}
