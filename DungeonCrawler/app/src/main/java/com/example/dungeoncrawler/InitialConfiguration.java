package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.Toast;

public class InitialConfiguration extends AppCompatActivity {

    private double difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_configuration);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);


        Button nextButton = findViewById(R.id.nextButton);


        nextButton.setOnClickListener(v -> {
            RadioGroup difficultyRadioGroup = findViewById(R.id.radioGroup);
            double difficulty = 1;
            String difficultyLevel;
            double health;
            RadioButton radioEasy = findViewById(R.id.radioEasy);
            radioEasy.setChecked(true);

            if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioEasy) {
                difficultyLevel ="Hard";
                difficulty = 3;
                health = 50;
            } else if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioMedium) {
                difficultyLevel = "Medium";
                difficulty = 2;
                health = 75;
            } else if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioHard) {
                difficultyLevel = "Easy";
                difficulty = 1;
                health = 100;
            } else {
                return;
            }

            String username;
            EditText inputBox = findViewById(R.id.inputText);
            if (inputBox.getText().toString().equals("") || inputBox.getText().toString().trim().equals("")) {
                return;
            }
            username = inputBox.getText().toString();

            Bundle extras = new Bundle();
            extras.putString("name", username);
            extras.putDouble("difficulty", difficulty);
            extras.putInt("sprite", sprite);
            extras.putDouble("health", health);
            extras.putString("DifficultyLevel", difficultyLevel);

            Intent game = new Intent(InitialConfiguration.this, GameScene.class);
            game.putExtra("difficulty", difficulty);
            startActivity(game);
            finish();
        });



        nextButton.setOnClickListener(v -> {
            // Finish the current activity to exit the app
            finish();
            // Alternatively, you can use System.exit(0) to forcefully exit the app
            // System.exit(0)
        });

        //EditText n= findViewById(R.id.textView);


        //findViewById(R.id.inputText);

        //String playerName = editTextName.getText().toString().trim();

    }
}