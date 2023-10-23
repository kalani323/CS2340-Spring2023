package com.example.carsyroad;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import android.content.Context;

public class S4WaterTileRespawnTest {
    int numLives = 6;
    Context gameActivity;
    Driver driver = new Driver(gameActivity, numLives);
    Character c = driver.getCharacter();

    /* tests to see if the player respawns to the correct initial starting x position (resetting its position)
     ** when the player lands on a water tile.
     */
    @Test
    public void testPlayerRespawnToStartCheckX() {
        c.setX(6);
        c.setY(12);
        int[] movementArr = driver.moveCharacter(0, 1);
        int expectedX = 4;
        int actualX = movementArr[0];
        assertEquals(expectedX, actualX);

    }
    /* tests to see if the player respawns to the correct initial starting y position (resetting its position)
     ** when the player lands on a river tile.
     */
    @Test
    public void testPlayerRespawnToStartCheckY() {
        c.setX(6);
        c.setY(12);
        int[] movementArr = driver.moveCharacter(0, 1);
        int expectedY = 0;
        int actualY = movementArr[1];
        assertEquals(expectedY, actualY);
    }
}
