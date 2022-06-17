package com.tsi.jake.stoner.program.selenium;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class NavigationButtons {
    private WebDriver driver;

    String Expected;
    String Actual;

    private String HOME_URL= "http://localhost:3000/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\TSI\\SeleniumWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testActorNav() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.id("goToActorButton")).click();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, HOME_URL + "Actor", "Incorrect Page");
    }
    @Test
    public void testCategoryNav() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.id("goToCategoryButton")).click();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, HOME_URL + "Category", "Incorrect Page");
    }


    @Test
    public void testKeywordNav() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.id("goToKeywordButton")).click();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, HOME_URL + "Keyword", "Incorrect Page");
    }

    @Test
    public void testLanguageNav() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.id("goToLanguageButton")).click();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, HOME_URL + "Language", "Incorrect Page");
    }

    @Test
    public void testLengthNav() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.id("goToLengthButton")).click();
        String URL = driver.getCurrentUrl();
        System.out.println("Hello");
        Assertions.assertEquals(URL, HOME_URL + "Length", "Incorrect Page");
    }


// // Used to slow down executions
//  try {
//        Thread.sleep(1000);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
}




