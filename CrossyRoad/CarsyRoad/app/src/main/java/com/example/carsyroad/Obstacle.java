package com.example.carsyroad;


// Obstacle class
public class Obstacle {
    private int[] x;
    private int y;
    private int size;
    private int speed;
    private int direction;
    private boolean slowDelay = false;
    private boolean hasObstacle;
    private boolean hasLog;

    public Obstacle(int y, int[] x, int speed, int direction, boolean hasObstacle, boolean hasLog) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.hasObstacle = hasObstacle;
        this.hasLog = hasLog;
    }

    public void move() {
        for (int i = 0; i < x.length; i++) {
            x[i] = mod(x[i] + direction, 9);
        }
    }

    private int mod(int dividend, int divisor) {
        return ((dividend % divisor) + divisor) % divisor;
    }

    public int[] getX() {
        return x;
    }
    public void setX(int[] x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public boolean getSlowDelay() {
        return slowDelay;
    }

    public void setSlowDelay(boolean x) {
        this.slowDelay = x;
    }

    public boolean hasObstacle() {
        return hasObstacle;
    }

    public boolean hasLog() {
        return hasLog;
    }
}
