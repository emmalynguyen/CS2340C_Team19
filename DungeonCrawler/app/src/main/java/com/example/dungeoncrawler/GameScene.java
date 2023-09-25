package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GameScene extends AppCompatActivity {

    String username;
    double difficulty;
    int sprite;
    double health;
    String difficultyLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scene);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String username = extras.getString("name");
        double difficulty = extras.getDouble("difficulty");
        int sprite = extras.getInt("sprite");
        double health = extras.getDouble("health");
        String difficultyLevel = extras.getString("DifficultyLevel");

        Log.d("tag", "Username: " + username);

        TextView nameTextView = findViewById(R.id.nameText);
        nameTextView.setText(username);

        TextView nameTextView = findViewById(R.id.nameText);
        nameTextView.setText(username);
//
//        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
//        TextView difficulty = findViewById(R.id.inputText);
//        difficulty.setText("Your Name"); //update with their name
//
//        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
//        TextView health = findViewById(R.id.inputText);
//        health.setText("Your Name"); //update with their name

        Button endingButton = findViewById(R.id.endingButton);

        endingButton.setOnClickListener(v -> {
            Intent ending = new Intent(GameScene.this, Ending.class);

            // Start SecondActivity
            startActivity(ending);

            // Finish the current activity if needed
            finish();
        });
    }
}