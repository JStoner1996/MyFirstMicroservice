package com.tsi.jake.stoner;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class CategoryTests {
    private int Expected;
    private int Actual;

    private String ExpectedS;
    private String ActualS;

    private Category testCategory = new Category(10, "Animated");

    @Test
     void testGetCategory_id(){
        Expected = 10;
        Actual = testCategory.getCategory_id();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Category ID");
    }

    @Test
     void testSetCategory_id(){
        Expected = 5;
        testCategory.setCategory_id(Expected);
        Actual = testCategory.getCategory_id();
        Assertions.assertEquals(Expected, Actual , "Category ID set incorrectly");
    }

    @Test
     void testGetName(){
        ExpectedS = "Animated";
        ActualS = testCategory.getName();
        Assertions.assertEquals(ExpectedS, ActualS, "Returns incorrect Name");
    }

    @Test
     void testSetName(){
        ExpectedS = "Horror";
        testCategory.setName(ExpectedS);
        ActualS = testCategory.getName();
        Assertions.assertEquals(ExpectedS, ActualS, "Name set incorrectly");
    }
}
