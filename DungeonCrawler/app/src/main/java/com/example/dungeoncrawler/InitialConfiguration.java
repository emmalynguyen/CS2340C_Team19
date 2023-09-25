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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_configuration);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        Button nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {
            RadioGroup difficultyRadioGroup = findViewById(R.id.radioGroup);
            int difficulty;
            String difficultyLevel;
            int health;
            int sprite;

            if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioHard) {
                difficultyLevel ="Hard";
                difficulty = 3;
                health = 50;
            } else if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioMedium) {
                difficultyLevel = "Medium";
                difficulty = 2;
                health = 75;
            } else if(difficultyRadioGroup.getCheckedRadioButtonId() == R.id.radioEasy) {
                difficultyLevel = "Easy";
                difficulty = 1;
                health = 100;
            } else {
                return;
            }

            RadioGroup spriteRadioGroup = findViewById(R.id.radioGroupCharacter);
            if (spriteRadioGroup.getCheckedRadioButtonId() == R.id.radioEldric) {
                sprite = 1;
            } else if (spriteRadioGroup.getCheckedRadioButtonId() == R.id.radioVaris) {
                sprite = 2;
            } else if (spriteRadioGroup.getCheckedRadioButtonId() == R.id.radioLyria) {
                sprite = 3;
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
            extras.putInt("difficulty", difficulty);
            extras.putInt("sprite", sprite);
            extras.putInt("health", health);
            extras.putString("DifficultyLevel", difficultyLevel);

            Intent game = new Intent(InitialConfiguration.this, GameScene.class);
            game.putExtras(extras);
            startActivity(game);
            finish();
        });
    }
}