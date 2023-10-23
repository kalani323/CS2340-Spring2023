package com.example.carsyroad;

public class Character {
    private int x = 4;
    private int y = 0;
    private int maxY = 0;
    private int numLives;

    public Character(int numLives) {
        this.numLives = numLives;
    }
    public void move(int directionX, int directionY) {
        // Update points
        int tempX = x + directionX;
        int tempY = y + directionY;
        if (tempX >= 0 && tempX <= 8 && tempY >= 0 && tempY <= 14) {
            x += directionX;
            y += directionY;
            if (y > maxY) {
                maxY = y;
            }
        }
    }

    public void die() {
        x = 4;
        y = 0;
        maxY = 0;
        numLives--;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getNumLives() {
        return numLives;
    }
}
