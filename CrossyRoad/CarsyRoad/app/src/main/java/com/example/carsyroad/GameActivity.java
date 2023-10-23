package com.example.carsyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;


public class GameActivity extends AppCompatActivity {
    private static int difficulty;
    private static String name;
    private int sprite;
    protected static int numLives;

    private static ImageView spriteImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        extractIntentExtras();
        TextView livesField = (TextView) findViewById(R.id.lives);
        TextView difficultyField = (TextView) findViewById(R.id.points);
        TextView pointsField = (TextView) findViewById(R.id.name);
        TextView nameField = (TextView) findViewById(R.id.difficulty);
        spriteImage = (ImageView) findViewById(R.id.sprite);
        setDifficulty(difficultyField, difficulty);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);
        setSprite(spriteImage, sprite);
        livesField.setText("Lives: " + Integer.toString(numLives));
        pointsField.setText("Points: " + Integer.toString(0));
        nameField.setText("Name: " + name);
        Driver driver = new Driver(this, numLives);
        ImageView smallLog1 = (ImageView) findViewById(R.id.smallLog);
        smallLog1.setX(560);
        smallLog1.setY(1692);
        ImageView smallLog2 = (ImageView) findViewById(R.id.smallLog1);
        smallLog2.setX(800);
        smallLog2.setY(796);
        ImageView smallLog3 = (ImageView) findViewById(R.id.smallLog2);
        smallLog3.setX(680);
        smallLog3.setY(540);
        ImageView smallLog4 = (ImageView) findViewById(R.id.smallLog3);
        smallLog4.setX(336);
        smallLog4.setY(1564);
        ImageView smallLog5 = (ImageView) findViewById(R.id.smallLog4);
        smallLog5.setX(224);
        smallLog5.setY(668);
        ImageView largeLog1 = (ImageView) findViewById(R.id.largeLog);
        largeLog1.setX(580);
        largeLog1.setY(1564);
        ImageView largeLog2 = (ImageView) findViewById(R.id.largeLog1);
        largeLog2.setX(680);
        largeLog2.setY(668);
        ImageView largeLog3 = (ImageView) findViewById(R.id.largeLog2);
        largeLog3.setX(232);
        largeLog3.setY(1692);
        ImageView largeLog4 = (ImageView) findViewById(R.id.largeLog3);
        largeLog4.setX(116);
        largeLog4.setY(796);
        ImageView largeLog5 = (ImageView) findViewById(R.id.largeLog4);
        largeLog5.setX(232);
        largeLog5.setY(540);
        Button upButton = (Button) findViewById(R.id.upButton);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] move = driver.moveCharacter(0, 1);
                System.out.println("Clicked up. NewY = " + move[1]);
                int x = move[0];
                int y = move[1];
                int lives = move[2];
                int hasLog = move[3];
                spriteImage.setX(x * 120 - 100);
                spriteImage.setY(1692 - (y * 128));
                pointsField.setText("Points: " + Integer.toString(driver.getPoints()));
                livesField.setText("Lives: " + lives); }
        });
        Button downButton = (Button) findViewById(R.id.downButton);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] move = driver.moveCharacter(0, -1);
                int x = move[0];
                int y = move[1];
                int lives = move[2];
                spriteImage.setX(x * 120 - 100);
                spriteImage.setY(1692 - (y * 128));
                pointsField.setText("Points: " + Integer.toString(driver.getPoints()));
                livesField.setText("Lives: " + lives); }
        });
        Button leftButton = (Button) findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] move = driver.moveCharacter(-1, 0);
                int x = move[0];
                int y = move[1];
                int lives = move[2];
                spriteImage.setX(x * 120 - 100);
                spriteImage.setY(1692 - (y * 128));
                pointsField.setText("Points: " + Integer.toString(driver.getPoints()));
                livesField.setText("Lives: " + lives); }
        });
        Button rightButton = (Button) findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] move = driver.moveCharacter(1, 0);
                int x = move[0];
                int y = move[1];
                int lives = move[2];
                spriteImage.setX(x * 120 - 100);
                spriteImage.setY(1692 - (y * 128));
                pointsField.setText("Points: " + Integer.toString(driver.getPoints()));
                livesField.setText("Lives: " + lives); }
        });
        ImageView kenny2 = findViewById(R.id.kenny2);
        ImageView nyckids = findViewById(R.id.nyckids);
        ImageView kenny1 = findViewById(R.id.kenny1);
        ImageView nyckids2 = findViewById(R.id.nyckids2);
        ImageView bus1 = findViewById(R.id.bus1);
        ImageView[] arr = new ImageView[]{kenny2, nyckids2, kenny1, nyckids, bus1};
        Obstacle kenny2o = driver.getObstacle(0);
        Obstacle nyckids2o = driver.getObstacle(1);
        Obstacle kenny1o = driver.getObstacle(2);
        Obstacle nyckidso = driver.getObstacle(3);
        Obstacle bus1o = driver.getObstacle(4);
        kenny2.setX(kenny2o.getX()[0] * 120 - 100);
        nyckids2.setX(nyckids2o.getX()[0] * 120 - 100);
        kenny1.setX(kenny1o.getX()[0] * 120 - 100);
        nyckids.setX(nyckidso.getX()[0] * 120 - 100);
        bus1.setX(bus1o.getX()[0] * 120 - 100);
        kenny2.setY(1820 - (kenny2o.getY() * 128));
        nyckids2.setY(1820 - (nyckids2o.getY() * 128));
        kenny1.setY(1820 - (kenny1o.getY() * 128));
        nyckids.setY(1820 - (nyckidso.getY()) * 128);
        bus1.setY(1820 - (bus1o.getY()) * 128);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            private int count = 0;
            private int place = 0;
            @Override
            public void run() {
                int[] o = driver.moveObstacles();
                for (int i = 0; i < 9; i += 2) {
                    arr[place].setX(o[i] * 120 - 100);
                    arr[place].setY(1820 - (o[i + 1] * 128));
                    place++;
                }
                place = 0;
                count++;
                if (count < 100) {
                    handler.postDelayed(this, 1000);
                } else {
                    handler.removeCallbacks(this);
                }
            }
        };
        handler.postDelayed(runnable, 1000);
    }
    private void extractIntentExtras() {
        Bundle extras = getIntent().getExtras();
        difficulty = extras.getInt("difficulty");
        name = extras.getString("name");
        sprite = extras.getInt("sprite");
        numLives = 6 - difficulty;
    }

    private void setDifficulty(TextView difficultyField, int difficulty) {
        switch (difficulty) {
        case 1:
            difficultyField.setText("Difficulty: Easy");
            break;
        case 3:
            difficultyField.setText("Difficulty: Hard");
            break;
        case 4:
            difficultyField.setText("Difficulty: Impossible");
            break;
        default:
            difficultyField.setText("Difficulty: Medium");
        }
    }
    private void setSprite(ImageView spriteImage, int sprite) {
        switch (sprite) {
        case 0:
            spriteImage.setImageResource(R.drawable.ericcartman);
            break;
        case 1:
            spriteImage.setImageResource(R.drawable.beast_cartman);
            break;
        default:
            spriteImage.setImageResource(R.drawable.eric_hall_monitor);
            break;
        }
    }
    // Getter method for numLives
    public static int getNumLives() {
        return (6 - difficulty);
    }

    //Setter method for difficulty
    public static void setLivesDifficulty(int newDifficulty) {
        difficulty = newDifficulty;
    }

}
