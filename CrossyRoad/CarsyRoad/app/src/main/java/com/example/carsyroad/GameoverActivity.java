package com.example.carsyroad;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameoverActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        int points = getIntent().getIntExtra("points", 0);

        TextView finalScore = (TextView) findViewById(R.id.finalScore);

        finalScore.setText("Final Points: " + points);

        Button restartButton = (Button) findViewById(R.id.restartButton);
        Button exitButton = (Button) findViewById(R.id.exitButton);

        // Switch back to start screen when restart button clicked
        restartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(GameoverActivity.this, ConfigActivity.class);
                startActivity(intent);
                finish();
            }
        });


        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }

}
