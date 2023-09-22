package com.example.dungeon_crawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Button startBtn = findViewById(R.id.startButton);

        // Set difficulty based on difficulty checked
        startBtn.setOnClickListener(v -> {
            RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
            double difficulty = 1;

            if (difficultyRadioGroup.getCheckedRadioButtonId() == R.id.easy) {
                difficulty = 0.5;
            } else if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioMedium) {
                difficulty = .75;
            } else if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioHard) {
                difficulty = 1;
            } else {
                difficulty = 1;
            }

            Intent game = new Intent(MainActivity.this, GameActivity.class);
            game.putExtra("difficulty", difficulty);
            startActivity(game);
            finish();
        });
    }
}