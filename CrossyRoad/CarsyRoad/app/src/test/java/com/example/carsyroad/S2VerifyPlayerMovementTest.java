package com.example.carsyroad;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import android.content.Context;
public class S2VerifyPlayerMovementTest {
    Context game;
    Driver driver = new Driver(game, 6);
    Character character = driver.getCharacter();
    @Test
    public void testMovementUp() {
        int oldY = character.getY();
        driver.moveCharacter(0, 1);
        int newY = character.getY();

        assertEquals(newY, oldY + 1);
    }

    @Test
    public void testMovementDown() {
        // starts at the bottom of the screen so we need to move up once so we can move down
        driver.moveCharacter(0, 1);

        int oldY = character.getY();
        driver.moveCharacter(0, -1);
        int newY = character.getY();

        assertEquals(newY, oldY - 1);
    }

    @Test
    public void testMovementLeft() {
        int oldX = character.getX();
        driver.moveCharacter(-1, 0);
        int newX = character.getX();

        assertEquals(newX, oldX - 1);
    }

    @Test
    public void testMovementRight() {
        int oldX = character.getX();
        driver.moveCharacter(1, 0);
        int newX = character.getX();

        assertEquals(newX, oldX + 1);
    }
}
