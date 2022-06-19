package com.tsi.jake.stoner.program.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetRandomFilmButtonsTest {
    private WebDriver driver;

    String Expected;
    String Actual;

    private final String HOME_URL= "http://localhost:3000/";


    // Creates new window for selenium to use before each test is ran
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\TSI\\SeleniumWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    // Closes the window after a test is run
    @After
    public void tearDown() {
        driver.quit();
    }

    //Tests that each button can be clicked
    @Test
    public void testCategoryButtons() {
        driver.get("http://localhost:3000/Category");
        driver.findElement(By.id("randomByAction")).click();
        driver.findElement(By.id("randomByAnimation")).click();
        driver.findElement(By.id("randomByChildren")).click();
        driver.findElement(By.id("randomByClassics")).click();
        driver.findElement(By.id("randomByComedy")).click();
        driver.findElement(By.id("randomByDocumentary")).click();
        driver.findElement(By.id("randomByDrama")).click();
        driver.findElement(By.id("randomByFamily")).click();
        driver.findElement(By.id("randomByForeign")).click();
        driver.findElement(By.id("randomByGames")).click();
        driver.findElement(By.id("randomByHorror")).click();
        driver.findElement(By.id("randomByMusic")).click();
        driver.findElement(By.id("randomByNew")).click();
        driver.findElement(By.id("randomBySci-Fi")).click();
        driver.findElement(By.id("randomBySports")).click();
        driver.findElement(By.id("randomByTravel")).click();
        driver.findElement(By.cssSelector(".home")).click();
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, HOME_URL, "Incorrect Page");

    }
}
