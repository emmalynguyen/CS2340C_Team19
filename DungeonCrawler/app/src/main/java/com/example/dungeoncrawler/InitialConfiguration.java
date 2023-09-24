package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class InitialConfiguration extends AppCompatActivity {

    private double difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_configuration);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        Button startButton = findViewById(R.id.startButton);
        Button exitButton = findViewById(R.id.exitButton);

        startButton.setOnClickListener(v -> {
            RadioGroup difficultyRadioGroup = findViewById(R.id.radioGroup);
            double difficulty = 1;
            RadioButton radioEasy = findViewById(R.id.radioEasy);
            radioEasy.setChecked(true);

            if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioEasy) {
                difficulty = 1;
            } else if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioMedium) {
                difficulty = 2;
            } else if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioHard) {
                difficulty = 3;
            }


            Intent game = new Intent(InitialConfiguration.this, GameScene.class);
            game.putExtra("difficulty", difficulty);
            startActivity(game);
            finish();
        });



        exitButton.setOnClickListener(v -> {
            // Finish the current activity to exit the app
            finish();
            // Alternatively, you can use System.exit(0) to forcefully exit the app
            // System.exit(0)
        });
    }
}