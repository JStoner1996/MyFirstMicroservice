package com.tsi.jake.stoner.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ActorTests {
    private int Expected;
    private int Actual;

    private String ExpectedS;
    private String ActualS;


    private Actor testActor = new Actor(10, "First", "Last");


    @Test
    void testSetActor_id(){
        Expected = 5;
        testActor.setActorId(Expected);
        Actual = testActor.getActorId();
        Assertions.assertEquals(Expected, Actual , "Actor ID set incorrectly");
    }

    @Test
    void testGetActor_id(){
        Expected = 10;
        Actual = testActor.getActorId();
        Assertions.assertEquals(Expected, Actual, "Returns incorrect Actor ID");
    }

    @Test
     void testSetFirstName(){
        ExpectedS = "John";
        testActor.setFirstName(ExpectedS);
        ActualS = testActor.getFirstName();
        Assertions.assertEquals(ExpectedS, ActualS , "First Name set incorrectly");
    }

    @Test
    void testGetFirstName(){
        ExpectedS = "First";
        ActualS = testActor.getFirstName();
        Assertions.assertEquals(ExpectedS, ActualS, "Returns incorrect First Name");
    }

    @Test
    void testSetLastName(){
        ExpectedS = "Smith";
        testActor.setLastName(ExpectedS);
        ActualS = testActor.getLastName();
        Assertions.assertEquals(ExpectedS, ActualS , "Last Name set incorrectly");
    }

    @Test
    void testGetLastName(){
        ExpectedS = "Last";
        ActualS = testActor.getLastName();
        Assertions.assertEquals(ExpectedS, ActualS, "Returns incorrect Last Name");
    }

    @Test
    void testActor (){
        String firstName = "Test";
        Actor testActor = new Actor(firstName, "Actor");

        Assertions.assertEquals(firstName, testActor.getFirstName(), "Actor constructor incorrect");
    }

    @Test
    void testEmptyActor(){
        Actor testEmptyActor = new Actor();

        Assertions.assertEquals(0, testEmptyActor.getActorId(), "Empty actor constructor not working");
    }

}
