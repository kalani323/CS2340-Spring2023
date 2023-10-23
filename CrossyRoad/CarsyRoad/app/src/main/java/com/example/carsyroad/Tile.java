package com.example.carsyroad;

public class Tile {
    private int points;
    private boolean hasCharacter;
    private boolean hasObstacle;
    private boolean hasLog;

    public Tile(int points) {
        this.points = points;
        this.hasCharacter = false;
        this.hasObstacle = false;
        this.hasLog = false;
    }

    public int getPoints() {
        return points;
    }

    public void hasCharacter(boolean hasCharacter) {
        this.hasCharacter = hasCharacter;
    }

    public void hasObstacle(boolean hasObstacle) {
        this.hasObstacle = hasObstacle;
    }

    public boolean hasObstacle() {
        return hasObstacle;
    }

    public boolean hasLog() {
        return hasLog;
    }

    public void hasLog(boolean hasLog) {
        this.hasLog = hasLog;
    }
}
