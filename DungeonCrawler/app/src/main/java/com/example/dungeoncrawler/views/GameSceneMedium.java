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

        Button leaderboardButton = findViewById(R.id.leaderboardButton);
        leaderboardButton.setOnClickListener(v -> {
            OverarchingViewmodel.addScore(username);
            Intent leaderboard = new Intent(GameSceneMedium.this, Ending.class);
            startActivity(leaderboard);
            finish();
        });

        Button easyButton = findViewById(R.id.easyButton);
        easyButton.setOnClickListener(v -> {
            Intent easyGame = new Intent(GameSceneMedium.this, GameSceneEasy.class);
            startActivity(easyGame);
            finish();
        });

        Button hardButton = findViewById(R.id.hardButton);
        hardButton.setOnClickListener(v -> {
            Intent hardGame = new Intent(GameSceneMedium.this, GameSceneHard.class);
            startActivity(hardGame);
            finish();
        });

        TextView scoreText = findViewById(R.id.scoreText);
        new CountDownTimer(100000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                scoreText.setText("Score: " + OverarchingViewmodel.decreaseScore(1));
            }

            @Override
            public void onFinish() { }

        }.start();
    }
}