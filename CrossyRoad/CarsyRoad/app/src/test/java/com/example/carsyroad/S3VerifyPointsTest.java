package com.example.carsyroad;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import android.content.Context;

public class S3VerifyPointsTest {
 /*   Context c;
    Driver driver = new Driver(c, 6);
    @Test
    public void testPointsMaxY() {
        //Tests that you get points if and only if you move past your maximum y value

        //move the character up twice and then down once
        driver.moveCharacter(0, 1);
        driver.moveCharacter(0, 1);
        driver.moveCharacter(0, -1);

        //now check that the points doesn't update after another call (because we haven't moved past
        //our max distance)
        int oldPoints = driver.getPoints();
        driver.moveCharacter(0, 1);
        int newPoints = driver.getPoints();

        assertEquals(oldPoints, newPoints);

        oldPoints = driver.getPoints();
        //now move past the y value
        driver.moveCharacter(0, 1);
        driver.moveCharacter(0, 1);
        newPoints = driver.getPoints();

        //make sure the points changed since we moved past the maximum y value
        assertNotEquals(oldPoints, newPoints);
    }

    @Test
    public void testNoPointsMovingLeft() {
        // test to make sure you don't get points for moving left

        int oldPoints = driver.getPoints();
        driver.moveCharacter(-1, 0);
        int newPoints = driver.getPoints();

        assertEquals(oldPoints, newPoints);
    }

    @Test
    public void testNoPointsMovingRight() {
        // test to make sure you don't get points for moving right

        int oldPoints = driver.getPoints();
        driver.moveCharacter(1, 0);
        int newPoints = driver.getPoints();

        assertEquals(oldPoints, newPoints);
    }

    @Test
    public void testNoPointsMovingDown() {
        // test to make sure you don't get points for moving down

        // move the sprite up once since it starts already at the bottom of the screen
        driver.moveCharacter(0, 1);

        int oldPoints = driver.getPoints();
        driver.moveCharacter(0, -1);
        int newPoints = driver.getPoints();

        assertEquals(oldPoints, newPoints);
    }

    @Test
    public void testCorrectPointsForSafe() {
        int oldPoints = driver.getPoints();
        driver.moveCharacter(0, 1);
        int newPoints = driver.getPoints();

        assertEquals(newPoints, oldPoints + 5);
    }

    @Test
    public void testCorrectPointsForRiver() {
        // first we need to move the character up once to put him on a river tile
        driver.moveCharacter(0, 1);

        // now do the test
        int oldPoints = driver.getPoints();
        driver.moveCharacter(0, 1);
        int newPoints = driver.getPoints();

        assertEquals(newPoints, oldPoints + 10);
    }

    @Test
    public void testCorrectPointsForRoad() {
        // first we need to move the character up four times to put him on a road tile
        driver.moveCharacter(0, 1);
        driver.moveCharacter(0, 1);
        driver.moveCharacter(0, 1);
        driver.moveCharacter(0, 1);

        // now do the test
        int oldPoints = driver.getPoints();
        driver.moveCharacter(0, 1);
        int newPoints = driver.getPoints();

        assertEquals(newPoints, oldPoints + 25);
    }*/
}