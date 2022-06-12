package com.tsi.jake.stoner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class FilmTests {
    private int Expected;
    private int Actual;

    private String ExpectedS;
    private String ActualS;

    private Film testFilm = new Film(1,"Chicken Run", "Chicken's Run", 125, 1 );

    @Test
     void testGetFilm_id(){
        Expected = 1;
        Actual = testFilm.getFilm_id();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Film ID");
    }

    @Test
     void testSetFilm_id(){
        Expected = 5;
        testFilm.setFilm_id(Expected);
        Actual = testFilm.getFilm_id();
        Assertions.assertEquals(Expected, Actual , "Film ID set incorrectly");
    }

    @Test
     void testGetTitle(){
        ExpectedS = "Chicken Run";
        ActualS = testFilm.getTitle();
        Assertions.assertEquals(ExpectedS, ActualS, "Returns incorrect Title");
    }

    @Test
     void testSetTitle(){
        ExpectedS = "Resident Evil";
        testFilm.setTitle(ExpectedS);
        ActualS = testFilm.getTitle();
        Assertions.assertEquals(ExpectedS, ActualS , "Name set incorrectly");
    }

    @Test
     void testGetDescription(){
        ExpectedS = "Chicken's Run";
        ActualS = testFilm.getDescription();
        Assertions.assertEquals(ExpectedS, ActualS, "Returns incorrect Description");
    }

    @Test
     void testSetDescription(){
        ExpectedS = "Scary Zombies";
        testFilm.setDescription(ExpectedS);
        ActualS = testFilm.getDescription();
        Assertions.assertEquals(ExpectedS, ActualS , "Description set incorrectly");
    }

    @Test
     void testGetLength(){
        Expected = 125;
        Actual = testFilm.getLength();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Length");
    }

    @Test
     void testSetLength(){
        Expected = 150;
        testFilm.setLength(Expected);
        Actual = testFilm.getLength();
        Assertions.assertEquals(Expected, Actual , "Film Length set incorrectly");
    }

    @Test
     void testGetLanguage_id(){
        Expected = 1;
        Actual = testFilm.getLanguage_id();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Film ID");
    }

    @Test
     void testSetLanguage_id(){
        Expected = 2;
        testFilm.setLanguage_id(Expected);
        Actual = testFilm.getLanguage_id();
        Assertions.assertEquals(Expected, Actual , "Film ID set incorrectly");
    }
}
