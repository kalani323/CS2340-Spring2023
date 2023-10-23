package com.example.carsyroad;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class S2StartingLivesAndDifficultyTest {

    //test for easy difficulty level
    @Test
    public void verifyLivesForEasy() {
        GameActivity.setLivesDifficulty(1);
        assertEquals(5, GameActivity.getNumLives());
    }

    //test for medium difficulty level
    @Test
    public void verifyLivesForMedium() {
        GameActivity.setLivesDifficulty(2);
        assertEquals(4, GameActivity.getNumLives());
    }

    //test for hard difficulty level
    @Test
    public void verifyLivesForDifficult() {
        GameActivity.setLivesDifficulty(3);
        assertEquals(3, GameActivity.getNumLives());
    }


    //test for impossible difficulty level
    @Test
    public void verifyLivesForImpossible() {
        GameActivity.setLivesDifficulty(4);
        assertEquals(2, GameActivity.getNumLives());
    }
}
