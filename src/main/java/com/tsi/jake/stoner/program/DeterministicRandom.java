package com.tsi.jake.stoner.program;

import java.util.Random;

// FOR TESTING PURPOSES ONLY

public class DeterministicRandom extends Random {

    int sequentialNum = 0;

    public DeterministicRandom(){
        super();
    }

    public int nextInt(){
        return sequentialNum++;
    }

}
