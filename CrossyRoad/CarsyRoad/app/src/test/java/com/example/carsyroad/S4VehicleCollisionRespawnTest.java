package com.example.carsyroad;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import android.content.Context;

public class S4VehicleCollisionRespawnTest {
    Context c;
    Driver d = new Driver(c, 6);

    //player and vehicle 1 collision checks if the respawn x position is correctly updated
    @Test
    public void testPlayerObs1CollisionRespawnX() {
        Obstacle obstacle1 = d.getObstacle(0); // kenny
        int expectedX = 4;
        int actualX = (d.playerCollisionCheck(obstacle1))[0];
        assertEquals(expectedX, actualX);
    }

    //player and vehicle 2 collision for x
    @Test
    public void testPlayerObs2CollisionRespawnX() {
        Obstacle obstacle2 = d.getObstacle(1); // nyc kids
        int expectedX = 4;
        int actualX = (d.playerCollisionCheck(obstacle2))[0];
        assertEquals(expectedX, actualX);
    }
    //player and vehicle 3 collision for x
    @Test
    public void testPlayerObs3CollisionRespawnX() {
        Obstacle obstacle3 = d.getObstacle(3); // bus
        int expectedX = 4;
        int actualX = (d.playerCollisionCheck(obstacle3))[0];
        assertEquals(expectedX, actualX);
    }

    //player and vehicle 1 collision for y
    @Test
    public void testObs1CollisionRespawnY() {
        Obstacle obstacle1 = d.getObstacle(0); // kenny
        int expectedY = 0;
        int actualY = (d.playerCollisionCheck(obstacle1))[1];
        assertEquals(expectedY, actualY);
    }
    //player and vehicle 2 collision for y
    @Test
    public void testPlayerObs2CollisionRespawnY() {
        Obstacle obstacle2 = d.getObstacle(1); // nyc kids
        int expectedY = 0;
        int actualY = (d.playerCollisionCheck(obstacle2))[1];
        assertEquals(expectedY, actualY);
    }

    //player and vehicle 3 collision for y
    @Test
    public void testPlayerObs3CollisionRespawnY() {
        Obstacle obstacle3 = d.getObstacle(3); // bus
        int expectedY = 0;
        int actualY = (d.playerCollisionCheck(obstacle3))[1];
        assertEquals(expectedY, actualY);
    }
}

