package com.example.carsyroad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WinActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        int points = getIntent().getIntExtra("points", 0);

        TextView finalScore = (TextView) findViewById(R.id.finalScore1);

        finalScore.setText("Final Points: " + points);

        Button restartButton = (Button) findViewById(R.id.restartButton);
        Button exitButton = (Button) findViewById(R.id.exitButton);

        restartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WinActivity.this, ConfigActivity.class);
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
