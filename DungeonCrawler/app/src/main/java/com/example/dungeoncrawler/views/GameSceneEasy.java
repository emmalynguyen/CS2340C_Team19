package com.example.dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.view.KeyEvent;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.models.Enemy;
import com.example.dungeoncrawler.models.HealthPowerUp;
import com.example.dungeoncrawler.models.PowerUp;
import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

import java.util.ArrayList;

public class GameSceneEasy extends AppCompatActivity implements Observer {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_easy);

        setPowerUpVisualization();

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
        difficultyTextView.setText("Difficulty level:" + difficultyLevel);

        TextView healthTextView = findViewById(R.id.healthText);
        healthTextView.setText("");
        // healthTextView.setText("You have " + health + " health");

        TextView scoreText = findViewById(R.id.scoreText);

        OverarchingViewmodel.getScore().observe(this, value -> scoreText.setText("Score: "
                + value + "\nRoom 1"));

        Enemy airEnemy = OverarchingViewmodel.createEnemy("air");
        Enemy fireEnemy = OverarchingViewmodel.createEnemy("fire");

        //player position is 1050, 100
        airEnemy.setX(850);
        airEnemy.setY(700);
        fireEnemy.setX(1340);
        fireEnemy.setY(700);

        OverarchingViewmodel.addEnemy(airEnemy);
        OverarchingViewmodel.addEnemy(fireEnemy);
        update();
    }

    private void setPowerUpVisualization() {
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

        // Create a ConstraintSet to dynamically set constraints
        ConstraintSet constraintSet = new ConstraintSet();

        // Iterate over your power-ups and create visualizations
        int numberOfPowerUps = 3;
        int marginBetweenPowerUps = 20; // Adjust the margin between power-ups as needed
        int previousPowerUpId = ConstraintSet.PARENT_ID;
        // Create the power-up visualization
        PowerUp powerUp = new HealthPowerUp();
        AndroidPowerUpVisualization powerUpVisualization;
        powerUpVisualization = new AndroidPowerUpVisualization(this, constraintLayout,
                new HealthPowerUp(), R.drawable.health_powerup, 150, 150);

        // Add constraints for the power-up visualization
        constraintSet.clone(constraintLayout);
        constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM,
                previousPowerUpId, ConstraintSet.TOP);
        constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID, ConstraintSet.LEFT);

        // Set margins or paddings as needed
        int margin = 100 + 0 * marginBetweenPowerUps; // Set your desired margin
        constraintSet.setMargin(powerUpVisualization.getImageView().getId(),
                ConstraintSet.BOTTOM, margin);

        // Apply constraints
        constraintSet.applyTo(constraintLayout);

        previousPowerUpId = powerUpVisualization.getImageView().getId();

        // Display the power-up visualization
        powerUpVisualization.display(view -> {
            // Handle click event
            // You can add logic here to apply the power-up or perform other actions
            Toast.makeText(this, powerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void update() {
        ImageView spriteView = findViewById(R.id.spriteView);
        spriteView.setX(OverarchingViewmodel.getPlayerX());
        spriteView.setY(OverarchingViewmodel.getPlayerY());

        ArrayList<Enemy> enemies = OverarchingViewmodel.getEnemies();

        if (enemies.size() >= 2) {
            ImageView monsterView = findViewById(R.id.monsterView);
            monsterView.setImageResource(enemies.get(0).getSprite());
            monsterView.setX(enemies.get(0).getX());
            monsterView.setY(enemies.get(0).getY());
            ImageView monsterView2 = findViewById(R.id.monsterView2);
            monsterView2.setImageResource(enemies.get(1).getSprite());
            monsterView2.setX(enemies.get(1).getX());
            monsterView2.setY(enemies.get(1).getY());
        }

        if (OverarchingViewmodel.getPlayerY() >= 650) {
            OverarchingViewmodel.removeObserver(this);
            OverarchingViewmodel.sceneChangeRoom(GameSceneEasy.this, GameSceneMedium.class);
        }
        for (Enemy enemy : enemies) {
            if (enemy.checkCollision(OverarchingViewmodel.getPlayerX(),
                    OverarchingViewmodel.getPlayerY())) {
                OverarchingViewmodel.decreaseScore(10 * OverarchingViewmodel.getPlayerDifficulty());
            }
        }

        if (OverarchingViewmodel.getCount() <= 0) {
            OverarchingViewmodel.removeObserver(this);
            OverarchingViewmodel.sceneToLeaderboard(GameSceneEasy.this, LoseEnding.class);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        OverarchingViewmodel.keyDown(keyCode);
        return super.onKeyDown(keyCode, event);
    }
}
