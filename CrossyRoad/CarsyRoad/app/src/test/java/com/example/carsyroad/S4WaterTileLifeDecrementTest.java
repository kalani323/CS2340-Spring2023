package com.example.carsyroad;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import android.content.Context;

public class S4WaterTileLifeDecrementTest {
    Context game;
    int numLives = 6;
    Driver driver = new Driver(game, numLives);
    Character c = driver.getCharacter();

    // tests to see if the num of lives is decremented when the player lands on a water tile.
    @Test
    public void testRiverTileLifeLost() {
        c.setX(6);
        c.setY(12);
        driver.moveCharacter(0, 1);
        int expected = numLives - 1;
        int actual = c.getNumLives();
        assertEquals(expected, actual);
    }
}
