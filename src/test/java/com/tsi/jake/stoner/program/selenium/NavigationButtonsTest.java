package com.tsi.jake.stoner.program.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class NavigationButtonsTest {
//    private WebDriver driver;
//
//    String Expected;
//    String Actual;
//
//    private final String  HOME_URL= "http://localhost:3000/";
//
//    @BeforeEach
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "D:\\TSI\\SeleniumWebDriver\\chromedriver.exe");
//        driver = new ChromeDriver();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }
//
//    // Uses parameterized tests instead of multiple tests, 1st Value is ID, 2nd is word used for URL Actual
//    @ParameterizedTest
//
//    @CsvSource({
//            "goToActorButton, Actor",
//            "goToCategoryButton, Category",
//            "goToKeywordButton, Keyword",
//            "goToLanguageButton, Language",
//            "goToLengthButton, Length"
//    })
//    void testNavButtons(String id, String word){
//        driver.get("http://localhost:3000/");
//
//        driver.findElement(By.id(id)).click();
//        String URL = driver.getCurrentUrl();
//        Assertions.assertEquals(URL, HOME_URL + word, "Incorrect Page");
//
//        driver.quit();
//
//    }



//
//    @Test
//    public void testActorNav() {
//        driver.get("http://localhost:3000/");
//        driver.findElement(By.id("goToActorButton")).click();
//        String URL = driver.getCurrentUrl();
//        Assertions.assertEquals(URL, HOME_URL + "Actor", "Incorrect Page");
//    }
//    @Test
//    public void testCategoryNav() {
//        driver.get("http://localhost:3000/");
//        driver.findElement(By.id("goToCategoryButton")).click();
//        String URL = driver.getCurrentUrl();
//        Assertions.assertEquals(URL, HOME_URL + "Category", "Incorrect Page");
//    }
//
//
//    @Test
//    public void testKeywordNav() {
//        driver.get("http://localhost:3000/");
//        driver.findElement(By.id("goToKeywordButton")).click();
//        String URL = driver.getCurrentUrl();
//        Assertions.assertEquals(URL, HOME_URL + "Keyword", "Incorrect Page");
//    }
//
//    @Test
//    public void testLanguageNav() {
//        driver.get("http://localhost:3000/");
//        driver.findElement(By.id("goToLanguageButton")).click();
//        String URL = driver.getCurrentUrl();
//        Assertions.assertEquals(URL, HOME_URL + "Language", "Incorrect Page");
//    }
//
//    @Test
//    public void testLengthNav() {
//        driver.get("http://localhost:3000/");
//        driver.findElement(By.id("goToLengthButton")).click();
//        String URL = driver.getCurrentUrl();
//        System.out.println("Hello");
//        Assertions.assertEquals(URL, HOME_URL + "Length", "Incorrect Page");
//    }


// // Used to slow down executions
//  try {
//        Thread.sleep(1000);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
}




