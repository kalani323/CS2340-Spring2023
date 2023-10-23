package com.example.carsyroad;

import static org.junit.Assert.assertEquals;

import android.content.Context;
//import org.mockito.Mockito;
import org.junit.Test;

public class S5WinScreenFinalPointsTest {
    int numLives = 6;
    Context gameActivity;
    Driver driver = new Driver(gameActivity, numLives);
    Character c = driver.getCharacter();

    @Test
    public void pointsCheck() {
        int expected = 290;
        c.setY(14);
        driver.setFirstTime(true);
        int actual = driver.getWinScreenPoints();
        assertEquals(expected, actual);
    }
}
