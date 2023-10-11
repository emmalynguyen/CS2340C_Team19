package com.example.dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

public class Welcome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        new OverarchingViewmodel();

        Button startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(v -> {
            switchScene(Welcome.this, InitialConfiguration.class);
        });

        Button exitButton = findViewById(R.id.exitButton);

        exitButton.setOnClickListener(v -> {
            finish();
        });
    }

    public void switchScene(Context from, Class to){
        Intent game = new Intent(from, to);
        startActivity(game);
        finish();
    }
}