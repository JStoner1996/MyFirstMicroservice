package com.tsi.jake.stoner.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTests {
    private int Expected;
    private int Actual;

    private String ExpectedS;
    private String ActualS;

    private Film testFilm = new Film(1,"Chicken Run", "Chicken's Run", 125, 1 );

    @Test
    public void testGetFilm_id(){
        Expected = 1;
        Actual = testFilm.getFilm_id();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Film ID");
    }

    @Test
    public void testSetFilm_id(){
        Expected = 5;
        testFilm.setFilm_id(Expected);
        Actual = testFilm.getFilm_id();
        Assertions.assertEquals(Expected, Actual , "Film ID set incorrectly");
    }

    @Test
    public void testGetTitle(){
        ExpectedS = "Chicken Run";
        ActualS = testFilm.getTitle();
        Assertions.assertEquals(ExpectedS, ActualS, "Returns incorrect Title");
    }

    @Test
    public void testSetTitle(){
        ExpectedS = "Resident Evil";
        testFilm.setTitle(ExpectedS);
        ActualS = testFilm.getTitle();
        Assertions.assertEquals(ExpectedS, ActualS , "Name set incorrectly");
    }

    @Test
    public void testGetDescription(){
        ExpectedS = "Chicken's Run";
        ActualS = testFilm.getDescription();
        Assertions.assertEquals(ExpectedS, ActualS, "Returns incorrect Description");
    }

    @Test
    public void testSetDescription(){
        ExpectedS = "Scary Zombies";
        testFilm.setDescription(ExpectedS);
        ActualS = testFilm.getDescription();
        Assertions.assertEquals(ExpectedS, ActualS , "Description set incorrectly");
    }


    @Test
    public void testGetLength(){
        Expected = 125;
        Actual = testFilm.getLength();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Length");
    }

    @Test
    public void testSetLength(){
        Expected = 150;
        testFilm.setLength(Expected);
        Actual = testFilm.getLength();
        Assertions.assertEquals(Expected, Actual , "Film Length set incorrectly");
    }

    @Test
    public void testGetLanguage_id(){
        Expected = 1;
        Actual = testFilm.getLanguage_id();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Film ID");
    }

    @Test
    public void testSetLanguage_id(){
        Expected = 2;
        testFilm.setLanguage_id(Expected);
        Actual = testFilm.getLanguage_id();
        Assertions.assertEquals(Expected, Actual , "Film ID set incorrectly");
    }
}
