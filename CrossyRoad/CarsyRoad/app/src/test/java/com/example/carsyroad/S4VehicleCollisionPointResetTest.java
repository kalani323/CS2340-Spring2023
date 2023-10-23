package com.example.carsyroad;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import android.content.Context;

public class S4VehicleCollisionPointResetTest {
    Context c;
    Driver d = new Driver(c, 6);

    //checks if points are 0 after they player and vehicle 1 collide
    @Test
    public void testPlayerVehicle1PointReset() {
        Obstacle obstacle1 = d.getObstacle(0); // kenny
        int expectedPoints = 0;
        int actualPoints =  (d.playerCollisionCheck(obstacle1))[2];
        assertEquals(expectedPoints, actualPoints);
    }

    //checks if points are 0 after they player and vehicle 2 collide
    @Test
    public void testPlayerVehicle2PointReset() {
        Obstacle obstacle2 = d.getObstacle(1); // nyc kids
        int expectedPoints = 0;
        int actualPoints =  (d.playerCollisionCheck(obstacle2))[2];
        assertEquals(expectedPoints, actualPoints);
    }

    //checks if points are 0 after they player and vehicle 3 collide
    @Test
    public void testPlayerVehicle3PointReset() {
        Obstacle obstacle3 = d.getObstacle(3); // bus
        int expectedPoints = 0;
        int actualPoints =  (d.playerCollisionCheck(obstacle3))[2];
        assertEquals(expectedPoints, actualPoints);
    }

}
