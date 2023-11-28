package com.example.dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;

import android.view.KeyEvent;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.models.Enemy;
import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

import java.util.ArrayList;

public class GameSceneMedium extends AppCompatActivity implements Observer {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_medium);

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
        healthTextView.setText("");
        // healthTextView.setText("You have " + health + " health");

        TextView scoreText = findViewById(R.id.scoreText);
        OverarchingViewmodel.getScore().observe(this, value -> scoreText.setText("Score: "
                + value + "\nRoom 2"));

        Enemy waterEnemy = OverarchingViewmodel.createEnemy("water");
        Enemy earthEnemy1 = OverarchingViewmodel.createEnemy("earth");
        Enemy earthEnemy2 = OverarchingViewmodel.createEnemy("earth");

        //player position is 1050, 100
        waterEnemy.setX(960);
        waterEnemy.setY(370);
        earthEnemy1.setX(830);
        earthEnemy1.setY(450);
        earthEnemy2.setX(1310);
        earthEnemy2.setY(450);

        OverarchingViewmodel.addEnemy(waterEnemy);
        OverarchingViewmodel.addEnemy(earthEnemy1);
        OverarchingViewmodel.addEnemy(earthEnemy2);

        update();
    }


    @Override
    public void update() {
        ImageView spriteView = findViewById(R.id.spriteView);
        spriteView.setX(OverarchingViewmodel.getPlayerX());
        spriteView.setY(OverarchingViewmodel.getPlayerY());

        ArrayList<Enemy> enemies = OverarchingViewmodel.getEnemies();

        if (enemies.size() >= 3) {
            ImageView monsterView = findViewById(R.id.monsterView);
            monsterView.setImageResource(enemies.get(0).getSprite());
            monsterView.setX(enemies.get(0).getX());
            monsterView.setY(enemies.get(0).getY());
            ImageView monsterView2 = findViewById(R.id.monsterView2);
            monsterView2.setImageResource(enemies.get(1).getSprite());
            monsterView2.setX(enemies.get(1).getX());
            monsterView2.setY(enemies.get(1).getY());
            ImageView monsterView3 = findViewById(R.id.monsterView3);
            monsterView3.setImageResource(enemies.get(2).getSprite());
            monsterView3.setX(enemies.get(2).getX());
            monsterView3.setY(enemies.get(2).getY());
        }

        if (OverarchingViewmodel.getPlayerY() >= 650) {
            OverarchingViewmodel.removeObserver(this);
            OverarchingViewmodel.sceneChangeRoom(GameSceneMedium.this, GameSceneHard.class);
        }

        for (Enemy enemy : enemies) {
            if (enemy.checkCollision(OverarchingViewmodel.getPlayerX(),
                    OverarchingViewmodel.getPlayerY())) {
                OverarchingViewmodel.decreaseScore(10 * OverarchingViewmodel.getPlayerDifficulty());
            }
        }

        if (OverarchingViewmodel.getCount() <= 0) {
            OverarchingViewmodel.removeObserver(this);
            OverarchingViewmodel.sceneToLeaderboard(GameSceneMedium.this, LoseEnding.class);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        OverarchingViewmodel.keyDown(keyCode);
        return super.onKeyDown(keyCode, event);
    }
}
