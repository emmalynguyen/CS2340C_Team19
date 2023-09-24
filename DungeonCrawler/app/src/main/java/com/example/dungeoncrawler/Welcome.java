package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        Button startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(v -> {
            Intent game = new Intent(Welcome.this, InitialConfiguration.class);
            startActivity(game);
            finish();
        });

        Button exitButton = findViewById(R.id.exitButton);

        exitButton.setOnClickListener(v -> {
                // Finish the current activity to exit the app
                finish();
                // Alternatively, you can use System.exit(0) to forcefully exit the app
                // System.exit(0)
        });
    }
}