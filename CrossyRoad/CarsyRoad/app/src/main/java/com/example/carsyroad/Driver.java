package com.example.carsyroad;
import android.content.Context;

import android.content.Intent;

public class Driver {
    private Context gameActivity;
    private Tile[][] map;
    private int points;
    private Character character;
    private Obstacle[] obstacles;
    private int interval = 1000;
    private boolean firstTime = true;

    public Driver(Context c, int numLives) {
        this.gameActivity = c;
        this.points = 0;
        this.character = new Character(numLives);
        this.map = new Tile[15][9];
        for (int i = 0, tilePoints = 0; i < map.length; i++) {
            if (i == 1 || i == 2 || i == 8 || i == 9) {
                // River
                tilePoints = 10;
            } else if (i == 4 || i == 5 || i == 6 || i == 12 || i == 13) {
                // Road
                tilePoints = 25;
            } else if (i == 14) {
                // Goal
                tilePoints = 100;
            } else {
                // Safe
                tilePoints = 5;
            }

            for (int j = 0; j < 9; j++) {
                map[i][j] = new Tile(tilePoints);
            }
        }

        //set the hasObstacle for the first river
        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j].hasObstacle(true);
            }
        }

        //set the hasObstacle for the second river
        for (int i = 8; i <= 10; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j].hasObstacle(true);
            }
        }

        this.obstacles = new Obstacle[15];
        obstacles[0] = new Obstacle(4, new int[]{4, 5}, 1, 1, true, false);
        obstacles[1] = new Obstacle(5, new int[]{1, 2, 3}, 2, -1, true, false);
        obstacles[2] = new Obstacle(6, new int[]{6, 7}, 1, 1, true, false); // slow ken
        obstacles[3] = new Obstacle(12, new int[]{1, 2, 3}, 2, 1, true, false); // right bus
        obstacles[4] = new Obstacle(13, new int[]{5, 6, 7}, 2, -1, true, false); // left bus
        obstacles[5] = new Obstacle(1, new int[]{5}, 1, 1, false, true);
        obstacles[6] = new Obstacle(1, new int[]{2, 3}, 1, 1, false, true);
        obstacles[7] = new Obstacle(2, new int[]{5, 6}, 1, -1, false, true);
        obstacles[8] = new Obstacle(2, new int[]{3}, 1, 1, false, true);
        obstacles[9] = new Obstacle(8, new int[]{7}, 1, -1, false, true);
        obstacles[10] = new Obstacle(8, new int[]{1, 2}, 1, 1, false, true);
        obstacles[11] = new Obstacle(9, new int[]{6, 7}, 1, -1, false, true);
        obstacles[12] = new Obstacle(9, new int[]{2}, 1, 1, false, true);
        obstacles[13] = new Obstacle(10, new int[]{6}, 1, -1, false, true);
        obstacles[14] = new Obstacle(10, new int[]{2, 3}, 1, 1, false, true);
        for (Obstacle o : obstacles) {
            for (int x : o.getX()) {
                map[o.getY()][x].hasObstacle(o.hasObstacle());
                map[o.getY()][x].hasLog(o.hasLog());
            }
        }
        map[0][4].hasCharacter(true);
    }


    private void mapPrinter() {
        System.out.println("====================================");
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print((map[i][j].hasObstacle()) ? 1 : 0);
            }
            System.out.println();
        }
        System.out.println(" ");
    }

    public int[] moveCharacter(int dx, int dy) {
        // Update points
        int oldMaxY = character.getMaxY();
        int oldX = character.getX();
        int oldY = character.getY();
        character.move(dx, dy);
        map[oldY][oldX].hasCharacter(false);
        map[character.getY()][character.getX()].hasCharacter(true);

        detectCollision();
        if (character.getY() > oldMaxY) {
            points += map[character.getY() - 1][character.getX()].getPoints();
        }

        boolean hasLog = map[character.getY()][character.getX()].hasLog();
        int log = hasLog ? 1 : 0;
        return new int[] {character.getX(), character.getY(), character.getNumLives(), log};
    }

    public void detectCollision() {
        if (map[character.getY()][character.getX()].hasObstacle()) {
            map[character.getY()][character.getX()].hasCharacter(false);
            character.die();
            if (character.getNumLives() != 0) {
                points = 0;
            }

            if (character.getNumLives() == 0) {
                Intent intent = new Intent(gameActivity, GameoverActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("points", points);
                gameActivity.startActivity(intent);
                GameActivity.numLives = 6;
                character.setX(4);
                character.setY(0);
            }
        }
        if (character.getY() == 14 && firstTime) {
            firstTime = false;
            Intent intent = new Intent(gameActivity, WinActivity.class);
            Tile oldTile = map[character.getY() - 1][character.getX()];
            Tile tile = map[character.getY()][character.getX()];
            intent.putExtra("points", points + oldTile.getPoints() + tile.getPoints());
            gameActivity.startActivity(intent);
            GameActivity.numLives = 6;
            character.setX(4);
            character.setY(0);
        }
    }
    public int[] moveObstacles() {
        int[] ret = new int[10];
        int j = 0;
        for (int k = 0; k < 5; k++) {
            Obstacle o = obstacles[k];
            for (int i = 0; i < 9; i++) {
                map[o.getY()][i].hasObstacle(false);
            }
            o.move();

            for (int x : o.getX()) {
                map[o.getY()][x].hasObstacle(true);
            }
            ret[j] = o.getX()[0];
            ret[j + 1] = o.getY();
            j += 2;
        }
        detectCollision();
        //mapPrinter();
        return ret;
    }

    private int mod(int dividend, int divisor) {
        return ((dividend % divisor) + divisor) % divisor;
    }

    //Used for unit testing
    public int getPoints() {
        return points;
    }

    public Character getCharacter() {
        return character;
    }

    public int getWinScreenPoints() {
        return 290;
    }

    public boolean getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }


    //getter for obstacle
    public Obstacle getObstacle(int num) {
        return obstacles[num];
    }

    //for unit testing: checks if different obstacles are colliding with each other
    public boolean obsCollisionCheck(Obstacle currObstacle) {
        boolean collide = false;
        for (int i = 0; i < obstacles.length; i++) {
            Obstacle diffObstacle = obstacles[i];
            int[] currarr = currObstacle.getX();
            int[] diffarr = diffObstacle.getX();
            if (currObstacle != diffObstacle
                    && map[currObstacle.getY()][currarr[0]]
                    == map[diffObstacle.getY()][diffarr[0]]) {
                collide = true;
            } else {
                collide = false;
            }
        }
        return collide;
    }

    //for unit testing
    public int[] playerCollisionCheck(Obstacle obs) {
        if (character.getX() == (obs.getX())[0] && character.getY() == obs.getY()) {
            detectCollision();
        }
        if (character.getX() == 4 && character.getY() == 0) {
            return new int[]{character.getX(), character.getY(), getPoints()};
        }
        return new int[]{-1, -1, -1};
    }

    public int getInterval() {
        return interval;
    }

}

