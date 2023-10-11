package com.example.dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.models.Leaderboard;
import com.example.dungeoncrawler.models.Score;

public class Ending extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        Leaderboard leaderboard = Leaderboard.getLeaderboard();

        String[] names = leaderboard.getNames();
        int[] scores = leaderboard.getScores();


        TextView scoreText2 = findViewById(R.id.scoreText2);
        scoreText2.setText(names[1] + "\n" + scores[1]);
        TextView scoreText3 = findViewById(R.id.scoreText3);
        scoreText3.setText(names[2] + "\n" + scores[2]);
        TextView scoreText4 = findViewById(R.id.scoreText4);
        scoreText4.setText(names[3] + "\n" + scores[3]);
        TextView scoreText5 = findViewById(R.id.scoreText5);
        scoreText5.setText(names[4] + "\n" + scores[4]);
        TextView scoreText6 = findViewById(R.id.scoreText6);
        scoreText6.setText(names[5] + "\n" + scores[5]);


        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(v -> {
            Intent configuration = new Intent(Ending.this, InitialConfiguration.class);
            startActivity(configuration);
            finish();
        });
    }
}