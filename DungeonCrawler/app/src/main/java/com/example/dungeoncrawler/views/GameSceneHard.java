package com.example.dungeoncrawler.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

public class GameSceneHard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hard);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String username = OverarchingViewmodel.getPlayerName();
        int difficulty = OverarchingViewmodel.getPlayerDifficulty();
        int health = OverarchingViewmodel.getPlayerHealth();
        String difficultyLevel = OverarchingViewmodel.getPlayerDifficultyName();

        TextView nameTextView = findViewById(R.id.nameText);
        nameTextView.setText("Hi " + username);

        ImageView spriteView = findViewById(R.id.spriteView);
        spriteView.setImageResource(OverarchingViewmodel.getPlayerSprite());

        TextView difficultyTextView = findViewById(R.id.difficultyText);
        difficultyTextView.setText("Difficulty level " + difficulty + ": " + difficultyLevel);

        TextView healthTextView = findViewById(R.id.healthText);
        healthTextView.setText("You have " + health + " health");


        TextView scoreText = findViewById(R.id.scoreText);
        OverarchingViewmodel.getScore().observe(this, value -> scoreText.setText("Score: " + value));


        Button easyButton = findViewById(R.id.easyButton);
        easyButton.setOnClickListener(v -> {
            OverarchingViewmodel.sceneChangeRoom(GameSceneHard.this, GameSceneEasy.class);
        });

        Button mediumButton = findViewById(R.id.mediumButton);
        mediumButton.setOnClickListener(v -> {
            OverarchingViewmodel.sceneChangeRoom(GameSceneHard.this, GameSceneMedium.class);
        });


        Button leaderboardButton = findViewById(R.id.leaderboardButton);
        leaderboardButton.setOnClickListener(v -> {
            OverarchingViewmodel.sceneToLeaderboard(GameSceneHard.this, Ending.class);
        });

    }
}