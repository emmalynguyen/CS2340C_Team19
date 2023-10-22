package com.example.dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;

import android.view.KeyEvent;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.viewmodels.Movement;
import com.example.dungeoncrawler.viewmodels.MoveLeft;
import com.example.dungeoncrawler.viewmodels.MoveRight;
import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

public class GameSceneEasy extends AppCompatActivity implements Observer {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_easy);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        OverarchingViewmodel.setObserver(this);

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


        Button mediumButton = findViewById(R.id.mediumButton);
        mediumButton.setOnClickListener(v -> {
            OverarchingViewmodel.sceneChangeRoom(GameSceneEasy.this, GameSceneMedium.class);
        });

        Button hardButton = findViewById(R.id.hardButton);
        hardButton.setOnClickListener(v -> {
            OverarchingViewmodel.sceneChangeRoom(GameSceneEasy.this, GameSceneHard.class);
        });

        Button leaderboardButton = findViewById(R.id.leaderboardButton);
        leaderboardButton.setOnClickListener(v -> {
            OverarchingViewmodel.sceneToLeaderboard(GameSceneEasy.this, Ending.class);
        });

    }

    @Override
    public void update() {
        ImageView spriteView = findViewById(R.id.spriteView);
        spriteView.setX(OverarchingViewmodel.getPlayerX());
        spriteView.setY(OverarchingViewmodel.getPlayerY());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        OverarchingViewmodel.keyDown(keyCode);
        return super.onKeyDown(keyCode, event);
//        Movement movement = null;
//        switch (keyCode) {
//            case KeyEvent.KEYCODE_DPAD_UP:
//                break;
//            case KeyEvent.KEYCODE_DPAD_DOWN:
//                break;
//            case KeyEvent.KEYCODE_DPAD_LEFT:
//                MoveLeft moveLeft = new MoveLeft();
//                OverarchingViewmodel.setMovementStrategy(moveLeft);
//                OverarchingViewmodel.move(spriteView);
//                break;
//            case KeyEvent.KEYCODE_DPAD_RIGHT:
//                MoveRight moveRight = new MoveRight();
//                OverarchingViewmodel.setMovementStrategy(moveRight);
//                OverarchingViewmodel.move(spriteView);
//                break;
//        }
//        return super.onKeyDown(keyCode, event);
    }

}
