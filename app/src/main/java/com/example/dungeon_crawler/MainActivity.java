package com.example.dungeon_crawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        Button startBtn = findViewById(R.id.startButton);

        // Set difficulty based on difficulty checked
        //startBtn.setOnClickListener(v -> {


            Intent game = new Intent(MainActivity.this, GameActivity.class);
            game.putExtra("difficulty", difficulty);
            startActivity(game);
            finish();
        });
    }
}