package com.example.carsyroad;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import android.content.Context;

public class S5LogMovementTest {
    Context game;
    Driver driver = new Driver(game, 6);

    Character character = driver.getCharacter();

    // test if character can move up on the logs
    @Test
    public void testMoveUp() {
        character.setX(5);
        character.setY(1);
        int oldY = character.getY();
        driver.moveCharacter(0, 1);

        assertEquals(2, oldY + 1);
    }

    // test if character can move down on the logs
    @Test
    public void testMoveDown() {
        character.setX(5);
        character.setY(2);

        int oldY = character.getY();
        driver.moveCharacter(0, -1);

        assertEquals(1, oldY - 1);
    }

    @Test
    public void testMoveLeft() {
        character.setX(6);
        character.setY(2);
        int oldX = character.getX();
        driver.moveCharacter(-1, 0);

        assertEquals(5, oldX - 1);
    }

    @Test
    public void testMoveRight() {
        character.setX(5);
        character.setY(2);
        int oldX = character.getX();
        driver.moveCharacter(1, 0);

        assertEquals(6, oldX + 1);
    }

}
