package com.example.dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;

import android.view.KeyEvent;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.models.Enemy;
import com.example.dungeoncrawler.models.HealthPowerUp;
import com.example.dungeoncrawler.models.SpeedPowerUp;
import com.example.dungeoncrawler.models.TeleportationPowerUp;
import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

import java.util.ArrayList;

public class GameSceneHard extends AppCompatActivity implements Observer {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_hard);

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
                + value + "\nRoom 3"));

        Enemy earthEnemy = OverarchingViewmodel.createEnemy("earth");
        Enemy airEnemy1 = OverarchingViewmodel.createEnemy("air");
        Enemy airEnemy2 = OverarchingViewmodel.createEnemy("air");

        //player position is 1050, 100
        earthEnemy.setX(830);
        earthEnemy.setY(450);
        airEnemy1.setX(830);
        airEnemy1.setY(350);
        airEnemy2.setX(830);
        airEnemy2.setY(580);

        OverarchingViewmodel.addEnemy(earthEnemy);
        OverarchingViewmodel.addEnemy(airEnemy1);
        OverarchingViewmodel.addEnemy(airEnemy2);


        update();

        ImageView speedPowerUpImageView = findViewById(R.id.speedPowerUp);

        // Set OnClickListener for the speed power-up
        speedPowerUpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle speed power-up click
                applySpeedPowerUp();
            }
        });
        ImageView healthPowerUpImageView = findViewById(R.id.healthPowerUp);

        // Set OnClickListener for the speed power-up
        healthPowerUpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle speed power-up click
                applyHealthPowerUp();
            }
        });
        ImageView teleportationPowerUpImageView = findViewById(R.id.teleportationPowerUp);

        // Set OnClickListener for the speed power-up
        teleportationPowerUpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle speed power-up click
                applyTeleportationPowerUp();
            }
        });

    }
    private void applySpeedPowerUp() {
        // Check if the player can collect the speed power-up (based on your game logic)

        // Create a SpeedPowerUp instance
        SpeedPowerUp speedPowerUp = new SpeedPowerUp();

        // Apply the speed power-up to the player
        speedPowerUp.applyPowerUp(OverarchingViewmodel.getPlayer());

        // Hide the speed power-up image after it is collected
        hideSpeedPowerUp();
        Toast.makeText(this, speedPowerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();

    }

    private void hideSpeedPowerUp() {
        ImageView speedPowerUpImageView = findViewById(R.id.speedPowerUp);
        speedPowerUpImageView.setVisibility(View.INVISIBLE);
    }
    private void applyHealthPowerUp() {
        // Check if the player can collect the speed power-up (based on your game logic)

        // Create a SpeedPowerUp instance
        HealthPowerUp healthPowerUp = new HealthPowerUp();

        // Apply the speed power-up to the player
        healthPowerUp.applyPowerUp(OverarchingViewmodel.getPlayer());

        // Hide the speed power-up image after it is collected
        hideHealthPowerUp();
        Toast.makeText(this, healthPowerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();

    }

    private void hideHealthPowerUp() {
        ImageView healthPowerUpImageView = findViewById(R.id.healthPowerUp);
        healthPowerUpImageView.setVisibility(View.INVISIBLE);
    }
    private void applyTeleportationPowerUp() {
        // Check if the player can collect the speed power-up (based on your game logic)

        // Create a SpeedPowerUp instance
        TeleportationPowerUp teleportationPowerUp = new TeleportationPowerUp();

        // Apply the speed power-up to the player
        teleportationPowerUp.applyPowerUp(OverarchingViewmodel.getPlayer());

        // Hide the speed power-up image after it is collected
        hideTeleportationPowerUp();
        Toast.makeText(this,
                teleportationPowerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();

    }

    private void hideTeleportationPowerUp() {
        ImageView teleportationPowerUpImageView = findViewById(R.id.teleportationPowerUp);
        teleportationPowerUpImageView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void update() {
        ImageView spriteView = findViewById(R.id.spriteView);
        spriteView.setX(OverarchingViewmodel.getPlayerX());
        spriteView.setY(OverarchingViewmodel.getPlayerY());
        if (OverarchingViewmodel.isOnFire()) {
            spriteView.setImageResource(OverarchingViewmodel.getFireSprite());
        } else {
            spriteView.setImageResource(OverarchingViewmodel.getPlayerSprite());
        }

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
            OverarchingViewmodel.sceneToLeaderboard(GameSceneHard.this, Ending.class);
        }

        for (Enemy enemy : enemies) {
            if (enemy.checkCollision(OverarchingViewmodel.getPlayerX(),
                    OverarchingViewmodel.getPlayerY())) {
                if (OverarchingViewmodel.isOnFire()) {
                    enemy.kill();
                } else {
                    OverarchingViewmodel.decreaseScore(10
                            * OverarchingViewmodel.getPlayerDifficulty());
                }
            }
        }

        if (OverarchingViewmodel.getCount() <= 0) {
            OverarchingViewmodel.removeObserver(this);
            OverarchingViewmodel.sceneToLeaderboard(GameSceneHard.this, LoseEnding.class);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        OverarchingViewmodel.keyDown(keyCode);
        return super.onKeyDown(keyCode, event);
    }

}
