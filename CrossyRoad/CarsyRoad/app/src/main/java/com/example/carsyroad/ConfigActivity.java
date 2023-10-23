package com.example.carsyroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }
    protected static String name;
    protected static int difficulty;

    public static boolean isValid(String name) {
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            return false;
        }
        return true;
    }
    public int setDifficulty(RadioButton easy, RadioButton medium,
                             RadioButton hard, RadioButton impossible) {
        difficulty = 2;
        RadioButton easyRadio = (RadioButton) findViewById(R.id.easy);
        RadioButton mediumRadio = (RadioButton) findViewById(R.id.medium);
        RadioButton hardRadio = (RadioButton) findViewById(R.id.hard);
        RadioButton impossibleRadio = (RadioButton) findViewById(R.id.impossible);
        if (easyRadio.isChecked()) {
            difficulty = 1;
        } else if (mediumRadio.isChecked()) {
            difficulty = 2;
        } else if (hardRadio.isChecked()) {
            difficulty = 3;
        } else if (impossibleRadio.isChecked()) {
            difficulty = 4;
        }
        return difficulty;
    }

    public void startGame(View view) {
        // This function is run after the main screen play button
        name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
        // Get views for radio groups and name input field
        int sprite = 1;
        RadioButton normalEric = (RadioButton) findViewById(R.id.ericcartman);
        RadioButton beastEric = (RadioButton) findViewById(R.id.beast_cartman);
        RadioButton monitorEric = (RadioButton) findViewById(R.id.eric_hall_monitor);
        if (normalEric.isChecked()) {
            sprite = 0;
        } else if (beastEric.isChecked()) {
            sprite = 1;
        } else if (monitorEric.isChecked()) {
            sprite = 2;
        }

        // Start the game activity while sending the config options through "extra"
        Intent intent = new Intent(this, GameActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        intent.putExtra("difficulty", difficulty);
        intent.putExtra("sprite", sprite);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}