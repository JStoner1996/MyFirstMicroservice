package com.tsi.jake.stoner.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmCategoryTests {
    private int Expected;
    private int Actual;

    private FilmCategory testFilmCategory = new FilmCategory(1, 1);

    @Test
    public void testGetFilm_id(){
        Expected = 1;
        Actual = testFilmCategory.getFilm_id();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Film ID");
    }

    @Test
    public void testSetFilm_id(){
        Expected = 5;
        testFilmCategory.setFilm_id(Expected);
        Actual = testFilmCategory.getFilm_id();
        Assertions.assertEquals(Expected, Actual , "Film ID set incorrectly");
    }

    @Test
    public void testGetCategory_id(){
        Expected = 1;
        Actual = testFilmCategory.getCategory_id();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Category ID");
    }

    @Test
    public void testSetCategory_id(){
        Expected = 5;
        testFilmCategory.setCategory_id(Expected);
        Actual = testFilmCategory.getCategory_id();
        Assertions.assertEquals(Expected, Actual , "Category ID set incorrectly");
    }
}
