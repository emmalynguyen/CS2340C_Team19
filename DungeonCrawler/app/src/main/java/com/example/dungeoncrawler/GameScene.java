package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScene extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scene);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String username = extras.getString("name");
        int difficulty = extras.getInt("difficulty");
        int sprite = extras.getInt("sprite");
        int health = extras.getInt("health");
        String difficultyLevel = extras.getString("DifficultyLevel");

        TextView nameTextView = findViewById(R.id.nameText);
        nameTextView.setText("Hi " + username);

        ImageView spriteView = findViewById(R.id.spriteView);
        if(sprite == 1) {
            spriteView.setImageResource(R.drawable.male_elf);
        } else if(sprite == 2) {
            spriteView.setImageResource(R.drawable.female_wizard);
        } else if(sprite == 3) {
            spriteView.setImageResource(R.drawable.female_dwarf);
        }

        TextView difficultyTextView = findViewById(R.id.difficultyText);
        difficultyTextView.setText("Difficulty level " + difficulty + ": " + difficultyLevel);

        TextView healthTextView = findViewById(R.id.healthText);
        healthTextView.setText("You have " + health + " health");

        Button endingButton = findViewById(R.id.endingButton);

        endingButton.setOnClickListener(v -> {
            Intent ending = new Intent(GameScene.this, Ending.class);
            startActivity(ending);
            finish();
        });
    }
}