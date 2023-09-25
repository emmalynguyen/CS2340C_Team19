package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameScene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_scene);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView name = findViewById(R.id.inputText);
        name.setText("Your Name"); //update with their name

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView difficulty = findViewById(R.id.inputText);
        difficulty.setText("Your Name"); //update with their name

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView health = findViewById(R.id.inputText);
        health.setText("Your Name"); //update with their name

        Button endingButton = findViewById(R.id.endingButton);

        endingButton.setOnClickListener(v -> {
            Intent intent = new Intent(GameScene.this, Ending.class);

            // Start SecondActivity
            startActivity(intent);

            // Finish the current activity if needed
            finish();
        });
    }
}