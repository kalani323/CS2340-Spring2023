package com.example.carsyroad;

import org.junit.Test;
import android.content.Context;
import static org.junit.Assert.assertEquals;


public class S5WinScreenRestartGameStateTest {
    int numLives = 6;
    Context gameActivity;
    Driver driver = new Driver(gameActivity, numLives);
    Character c = driver.getCharacter();

    @Test
    public void resetPoints() {
        int expected = 0;
        c.setY(14);
        driver.setFirstTime(true);
        int actual = driver.getPoints();
        assertEquals(expected, actual);
    }

    @Test
    public void resetLives() {
        int expected = 6;
        c.setY(14);
        driver.setFirstTime(true);
        int actual = c.getNumLives();
        assertEquals(expected, actual);
    }

    @Test
    public void resetRespawnX() {
        int expected = 4;
        c.setY(14);
        driver.setFirstTime(true);
        int actual = driver.getCharacter().getX();
        assertEquals(expected, actual);
    }

    @Test
    public void resetRespawnY() {
        int expected = 0;
        driver.setFirstTime(true);
        int actual = c.getY();
        assertEquals(expected, actual);
    }



}
