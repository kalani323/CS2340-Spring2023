package com.example.carsyroad;

import org.junit.Test;
import android.content.Context;
import static org.junit.Assert.assertFalse;

public class S3VerifyObstacleCollisionTest {
    Context c;
    Driver driver = new Driver(c, 6);

    //Refer to obsCollisionCheck in Driver.java to see how obstacle & obstacle (between obstacles) collisions are checked

    // checks if obstacle 1 does not collide with every other obstacle
    @Test
    public void testObstacle1Collision() {
        Obstacle obstacle1 = driver.getObstacle(0);
        assertFalse(driver.obsCollisionCheck(obstacle1));
    }

    // checks if obstacle 2 does not collide with every other obstacle
    @Test
    public void testObstacle2Collision() {
        Obstacle obstacle2 = driver.getObstacle(1);
        assertFalse(driver.obsCollisionCheck(obstacle2));
    }

    // checks if obstacle 3 does not collide with every other obstacle
    @Test
    public void testObstacle3Collision() {
        Obstacle obstacle3 = driver.getObstacle(3
        );
        assertFalse(driver.obsCollisionCheck(obstacle3));
    }
}
