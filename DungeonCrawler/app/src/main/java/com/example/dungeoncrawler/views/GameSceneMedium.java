package com.example.dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;

import android.view.KeyEvent;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

public class GameSceneMedium extends AppCompatActivity implements Observer {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_easy);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);


        ImageView spriteView = findViewById(R.id.spriteView);
        spriteView.setImageResource(OverarchingViewmodel.getPlayerSprite());
        OverarchingViewmodel.setObserver(this);

        String username = OverarchingViewmodel.getPlayerName();
        int difficulty = OverarchingViewmodel.getPlayerDifficulty();
        int health = OverarchingViewmodel.getPlayerHealth();
        String difficultyLevel = OverarchingViewmodel.getPlayerDifficultyName();

        TextView nameTextView = findViewById(R.id.nameText);
        nameTextView.setText("Hi " + username);

        TextView difficultyTextView = findViewById(R.id.difficultyText);
        difficultyTextView.setText("Difficulty level:"  + difficultyLevel);

        TextView healthTextView = findViewById(R.id.healthText);
        healthTextView.setText("You have " + health + " health");

        TextView scoreText = findViewById(R.id.scoreText);
        OverarchingViewmodel.getScore().observe(this, value -> scoreText.setText("Score: "
                + value + "\nRoom 2"));

    }

    @Override
    public void update() {
        ImageView spriteView = findViewById(R.id.spriteView);
        spriteView.setX(OverarchingViewmodel.getPlayerX());
        spriteView.setY(OverarchingViewmodel.getPlayerY());
        if (OverarchingViewmodel.getPlayerY() >= 500) {
            OverarchingViewmodel.removeObserver(this);
            OverarchingViewmodel.sceneChangeRoom(GameSceneMedium.this, GameSceneHard.class);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        OverarchingViewmodel.keyDown(keyCode);
        return super.onKeyDown(keyCode, event);
    }

}
