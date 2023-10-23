package com.example.carsyroad;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import android.content.Context;

public class S4WaterTilePointResetTest {
    int numLives = 6;
    Context game;
    Driver driver = new Driver(game, numLives);
    Character c = driver.getCharacter();

    //checks if points are set to 0 after the player lands on a water tile
    @Test
    public void testWaterTilePointReset() {
        c.setX(6);
        c.setY(12);
        driver.moveCharacter(0, 1);
        int actual = driver.getPoints();
        int expected = 0;
        assertEquals(expected, actual);

    }
}
