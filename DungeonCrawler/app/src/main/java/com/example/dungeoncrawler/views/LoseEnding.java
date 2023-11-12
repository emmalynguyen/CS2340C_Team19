package com.example.dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;


public class LoseEnding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);


        String[] names = OverarchingViewmodel.getLeaderboardNames();
        int[] scores = OverarchingViewmodel.getLeaderboardScores();

        String[] dates = OverarchingViewmodel.getLeaderboardDates();

        TextView currentScoreText = findViewById(R.id.currentScore);
        currentScoreText.setText(OverarchingViewmodel.getPlayerName()
                + "\n0");
        TextView currentScoreDate = findViewById(R.id.currentDate);
        currentScoreDate.setText("You Lose!\n" + OverarchingViewmodel.getDate());

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

        TextView dateText2 = findViewById(R.id.dateText2);
        dateText2.setText(dates[1]);
        TextView dateText3 = findViewById(R.id.dateText3);
        dateText3.setText(dates[2]);
        TextView dateText4 = findViewById(R.id.dateText4);
        dateText4.setText(dates[3]);
        TextView dateText5 = findViewById(R.id.dateText5);
        dateText5.setText(dates[4]);
        TextView dateText6 = findViewById(R.id.dateText6);
        dateText6.setText(dates[5]);


        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(v -> {
            OverarchingViewmodel.sceneToConfig(LoseEnding.this, InitialConfiguration.class);
        });
    }
}