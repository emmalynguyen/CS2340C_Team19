package com.example.dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

public class GameSceneMedium extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_medium);

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
            OverarchingViewmodel.sceneChangeRoom(GameSceneMedium.this, GameSceneEasy.class);
        });

        Button hardButton = findViewById(R.id.hardButton);
        hardButton.setOnClickListener(v -> {
            OverarchingViewmodel.sceneChangeRoom(GameSceneMedium.this, GameSceneHard.class);
        });


        Button leaderboardButton = findViewById(R.id.leaderboardButton);
        leaderboardButton.setOnClickListener(v -> {
            OverarchingViewmodel.sceneToLeaderboard(GameSceneMedium.this, Ending.class);
        });
    }
}