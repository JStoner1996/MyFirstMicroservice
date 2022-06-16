package com.tsi.jake.stoner.program;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


import java.util.*;


public class seleniumTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\TSI\\SeleniumWebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testActorButtons() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.cssSelector("a:nth-child(2) > .indexbutton")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("bob");
        driver.findElement(By.cssSelector(".home")).click();
    }

    @Test
    public void testCategoryButtons() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.cssSelector("a:nth-child(1) > .indexbutton")).click();
        driver.findElement(By.xpath("//button[@type=\'button\']")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[3]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[5]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[7]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[9]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[11]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[13]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[15]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[2]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[4]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[6]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[8]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[10]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[12]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[14]")).click();
        driver.findElement(By.xpath("(//button[@type=\'button\'])[16]")).click();
        driver.findElement(By.cssSelector(".home")).click();
    }

@Test
    public void testKeywordButtons() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.cssSelector("a:nth-child(3) > .indexbutton")).click();
        driver.findElement(By.id("keyword")).click();
        driver.findElement(By.id("keyword")).sendKeys("shark");
        driver.findElement(By.id("randomByKeyword")).click();
        driver.findElement(By.cssSelector(".home")).click();
    }



    @Test
    public void testLanguageButtons() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.cssSelector("a:nth-child(5) > .indexbutton")).click();
        driver.findElement(By.id("language")).click();
        driver.findElement(By.cssSelector(".row:nth-child(1) > .column:nth-child(2) > #language")).click();
        driver.findElement(By.cssSelector(".row:nth-child(1) > .column:nth-child(3) > #language")).click();
        driver.findElement(By.cssSelector(".row:nth-child(2) > .column:nth-child(1) > #language")).click();
        driver.findElement(By.cssSelector(".row:nth-child(2) > .column:nth-child(2) > #language")).click();
        driver.findElement(By.cssSelector(".row:nth-child(2) > .column:nth-child(3) > #language")).click();
        driver.findElement(By.cssSelector(".home")).click();
    }

    @Test
    public void testLengthButtons() {
        driver.get("http://localhost:3000/");
        driver.findElement(By.cssSelector("a:nth-child(4) > .indexbutton")).click();
        driver.findElement(By.id("length")).click();
        driver.findElement(By.id("length")).sendKeys("100");
        driver.findElement(By.cssSelector("button:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".home")).click();
    }


    //Tests the Length buttons with a wait period. For Demonstration purposes only.
//    @Test
//    public void testLengthButtonsWait() {
//        driver.get("http://localhost:3000/");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(By.cssSelector("a:nth-child(4) > .indexbutton")).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(By.id("length")).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(By.id("length")).sendKeys("100");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(By.cssSelector("button:nth-child(3)")).click();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(By.cssSelector(".home")).click();
//    }

}




