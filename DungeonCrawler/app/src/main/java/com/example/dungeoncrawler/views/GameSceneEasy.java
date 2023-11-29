package com.example.dungeoncrawler.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Debug;
import android.util.Log;
import android.view.KeyEvent;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
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

public class GameSceneEasy extends AppCompatActivity implements Observer {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_easy);

//        setPowerUpVisualization();

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
        Toast.makeText(this, teleportationPowerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();

    }

    private void hideTeleportationPowerUp() {
        ImageView teleportationPowerUpImageView = findViewById(R.id.teleportationPowerUp);
        teleportationPowerUpImageView.setVisibility(View.INVISIBLE);
    }


//    private void setPowerUpVisualization() {
//        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout); // Replace with your layout ID
//
//
//        // Create a ConstraintSet to dynamically set constraints
//        ConstraintSet constraintSet = new ConstraintSet();
//
//
//        // Iterate over your power-ups and create visualizations
//        int numberOfPowerUps = 3;
//        int marginBetweenPowerUps = 20; // Adjust the margin between power-ups as needed
//        int previousPowerUpId = ConstraintSet.PARENT_ID;
//            // Create the power-up visualization
//            PowerUp powerUp = new HealthPowerUp();
//            AndroidPowerUpVisualization powerUpVisualization;
//            powerUpVisualization = new AndroidPowerUpVisualization(this, constraintLayout, new HealthPowerUp(), R.drawable.health_powerup, 150, 150);
//
//            // Add constraints for the power-up visualization
//            constraintSet.clone(constraintLayout);
//            constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM, previousPowerUpId, ConstraintSet.TOP);
//            constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
//
//            // Set margins or paddings as needed
//            int margin = 100 + 0 * marginBetweenPowerUps;; // Set your desired margin
//            constraintSet.setMargin(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM, margin);
//
//            // Apply constraints
//            constraintSet.applyTo(constraintLayout);
//
//            previousPowerUpId = powerUpVisualization.getImageView().getId();
//
//            // Display the power-up visualization
//            powerUpVisualization.display(view -> {
//                // Handle click event
//                // You can add logic here to apply the power-up or perform other actions
//                Toast.makeText(this, powerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();
//            });
//
//            //teleportation powerup
//        /*powerUpVisualization = new AndroidPowerUpVisualization(this, constraintLayout, new TeleportationPowerUp(), R.drawable.health_powerup, 150, 150);
//
//        // Add constraints for the power-up visualization
//        constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM, previousPowerUpId, ConstraintSet.TOP);
//        constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
//
//        // Set margins or paddings as needed
//        margin = 100 + 1 * marginBetweenPowerUps;; // Set your desired margin
//        constraintSet.setMargin(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM, margin);
//
//        // Apply constraints
//        constraintSet.applyTo(constraintLayout);
//
//        previousPowerUpId = powerUpVisualization.getImageView().getId();
//
//        // Display the power-up visualization
//        powerUpVisualization.display(view -> {
//            // Handle click event
//            // You can add logic here to apply the power-up or perform other actions
//            Toast.makeText(this, powerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();
//        });
//
//         */
/*
    private void setPowerUpVisualization() {
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout); // Replace with your layout ID
        ConstraintSet constraintSet = new ConstraintSet();

        int marginBetweenPowerUps = 20;
        int previousPowerUpId = ConstraintSet.PARENT_ID;

        // Health power-up visualization
        AndroidPowerUpVisualization healthPowerUpVisualization = createPowerUpVisualization(constraintLayout, new HealthPowerUp(), R.drawable.health_powerup, previousPowerUpId, marginBetweenPowerUps);
        previousPowerUpId = healthPowerUpVisualization.getImageView().getId();

        // Speed power-up visualization
        AndroidPowerUpVisualization speedPowerUpVisualization = createPowerUpVisualization(constraintLayout, new SpeedPowerUp(), R.drawable.speed_powerup, previousPowerUpId, marginBetweenPowerUps);
        previousPowerUpId = speedPowerUpVisualization.getImageView().getId();

        // Teleportation power-up visualization
        //AndroidPowerUpVisualization teleportationPowerUpVisualization = createPowerUpVisualization(constraintLayout, new TeleportationPowerUp(), R.drawable.tele_powerup, previousPowerUpId, marginBetweenPowerUps);
        /*ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout); // Replace with your layout ID
>>>>>>> Stashed changes


//<<<<<<< Updated upstream
        // Create a ConstraintSet to dynamically set constraints
<<<<<<< Updated upstream
//        ConstraintSet constraintSet = new ConstraintSet();
//
//
//        // Iterate over your power-ups and create visualizations
//        int numberOfPowerUps = 3;
//        int marginBetweenPowerUps = 20; // Adjust the margin between power-ups as needed
//        int previousPowerUpId = ConstraintSet.PARENT_ID;
//            // Create the power-up visualization
//            PowerUp powerUp = new HealthPowerUp();
//            AndroidPowerUpVisualization powerUpVisualization;
//            powerUpVisualization = new AndroidPowerUpVisualization(this, constraintLayout, new HealthPowerUp(), R.drawable.health_powerup, 150, 150);
//
//            // Add constraints for the power-up visualization
//            constraintSet.clone(constraintLayout);
//            constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM, previousPowerUpId, ConstraintSet.TOP);
//            constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
//
//            // Set margins or paddings as needed
//            int margin = 100 + 0 * marginBetweenPowerUps;; // Set your desired margin
//            constraintSet.setMargin(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM, margin);
//
//            // Apply constraints
//            constraintSet.applyTo(constraintLayout);
//
//            previousPowerUpId = powerUpVisualization.getImageView().getId();
//
//            // Display the power-up visualization
//            powerUpVisualization.display(view -> {
//                // Handle click event
//                // You can add logic here to apply the power-up or perform other actions
//                Toast.makeText(this, powerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();
//            });
//
//            //teleportation powerup
//        /*powerUpVisualization = new AndroidPowerUpVisualization(this, constraintLayout, new TeleportationPowerUp(), R.drawable.health_powerup, 150, 150);
//        PowerUp powerUp1 = new TeleportationPowerUp();
//        powerUpVisualization.display(view -> {
//            // Handle click event
//            // You can add logic here to apply the power-up or perform other actions
//            Toast.makeText(this, powerUp1.getName() + " clicked!", Toast.LENGTH_SHORT).show();
//        });
//
//        // Add constraints for the power-up visualization
//        constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.TOP, previousPowerUpId, ConstraintSet.TOP);
//        constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
//
//        // Set margins or paddings as needed
//        margin = 100 + 1 * marginBetweenPowerUps;; // Set your desired margin
//        constraintSet.setMargin(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM, margin);
//
//        // Apply constraints
//        constraintSet.applyTo(constraintLayout);
//
//        previousPowerUpId = powerUpVisualization.getImageView().getId();
//
//        // Display the power-up visualization
//        powerUpVisualization.display(view -> {
//            // Handle click event
//            // You can add logic here to apply the power-up or perform other actions
//            Toast.makeText(this, powerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();
//        });
//
//         */
//
//
//    }
//=======
////    }
//>>>>>>> Stashed changes

        /*ConstraintSet constraintSet = new ConstraintSet();


        // Iterate over your power-ups and create visualizations
        int numberOfPowerUps = 3;
        int marginBetweenPowerUps = 20; // Adjust the margin between power-ups as needed
        int previousPowerUpId = ConstraintSet.PARENT_ID;
            // Create the power-up visualization
            PowerUp powerUp = new HealthPowerUp();
            AndroidPowerUpVisualization powerUpVisualization;
            powerUpVisualization = new AndroidPowerUpVisualization(this, constraintLayout, new HealthPowerUp(), R.drawable.health_powerup, 150, 150);

            // Add constraints for the power-up visualization
            constraintSet.clone(constraintLayout);
            constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM, previousPowerUpId, ConstraintSet.TOP);
            constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);

            // Set margins or paddings as needed
            int margin = 100 + 0 * marginBetweenPowerUps;; // Set your desired margin
            constraintSet.setMargin(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM, margin);

            // Apply constraints
            constraintSet.applyTo(constraintLayout);

            previousPowerUpId = powerUpVisualization.getImageView().getId();

            // Display the power-up visualization
            powerUpVisualization.display(view -> {
                // Handle click event
                // You can add logic here to apply the power-up or perform other actions
                Toast.makeText(this, powerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();
            });*/

            //teleportation powerup
        /*powerUpVisualization = new AndroidPowerUpVisualization(this, constraintLayout, new TeleportationPowerUp(), R.drawable.health_powerup, 150, 150);
        PowerUp powerUp1 = new TeleportationPowerUp();
        powerUpVisualization.display(view -> {
            // Handle click event
            // You can add logic here to apply the power-up or perform other actions
            Toast.makeText(this, powerUp1.getName() + " clicked!", Toast.LENGTH_SHORT).show();
        });

        // Add constraints for the power-up visualization
        constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.TOP, previousPowerUpId, ConstraintSet.TOP);
        constraintSet.connect(powerUpVisualization.getImageView().getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);

        // Set margins or paddings as needed
        margin = 100 + 1 * marginBetweenPowerUps;; // Set your desired margin
        constraintSet.setMargin(powerUpVisualization.getImageView().getId(), ConstraintSet.BOTTOM, margin);

        // Apply constraints
        constraintSet.applyTo(constraintLayout);

        previousPowerUpId = powerUpVisualization.getImageView().getId();

        // Display the power-up visualization
        powerUpVisualization.display(view -> {
            // Handle click event
            // You can add logic here to apply the power-up or perform other actions
            Toast.makeText(this, powerUp.getName() + " clicked!", Toast.LENGTH_SHORT).show();
        });

         */





    @Override
    public void update() {

        ImageView spriteView = findViewById(R.id.spriteView);
        spriteView.setX(OverarchingViewmodel.getPlayerX());
        spriteView.setY(OverarchingViewmodel.getPlayerY());
        if(OverarchingViewmodel.isOnFire()) {
            spriteView.setImageResource(OverarchingViewmodel.getFireSprite());
        } else {
            spriteView.setImageResource(OverarchingViewmodel.getPlayerSprite());
        }

        ArrayList<Enemy> enemies = OverarchingViewmodel.getEnemies();

        if(enemies.size() >= 2){
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
            if(enemy.checkCollision(OverarchingViewmodel.getPlayerX(), OverarchingViewmodel.getPlayerY())){
                if(OverarchingViewmodel.isOnFire()){
                    enemy.kill();
                } else {
                    OverarchingViewmodel.decreaseScore(10 * OverarchingViewmodel.getPlayerDifficulty());
                }
            }
        }

        if(OverarchingViewmodel.getCount() <= 0) {
            OverarchingViewmodel.removeObserver(this);
            OverarchingViewmodel.sceneToLeaderboard(GameSceneEasy.this, LoseEnding.class);
        }
    }

    public void hidePowerUp(){
        ImageView healthPowerUp = findViewById(R.id.healthPowerUp);
        healthPowerUp.setY(10000);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        OverarchingViewmodel.keyDown(keyCode);
        return super.onKeyDown(keyCode, event);
//
////        Movement movement = null;
////        switch (keyCode) {
////            case KeyEvent.KEYCODE_DPAD_UP:
////                break;
////            case KeyEvent.KEYCODE_DPAD_DOWN:
////                break;
////            case KeyEvent.KEYCODE_DPAD_LEFT:
////                MoveLeft moveLeft = new MoveLeft();
////                OverarchingViewmodel.setMovementStrategy(moveLeft);
////                OverarchingViewmodel.move(spriteView);
////                break;
////            case KeyEvent.KEYCODE_DPAD_RIGHT:
////                MoveRight moveRight = new MoveRight();
////                OverarchingViewmodel.setMovementStrategy(moveRight);
////                OverarchingViewmodel.move(spriteView);
////                break;
////        }
////        return super.onKeyDown(keyCode, event);
//        });
//
//        Button hardButton = findViewById(R.id.hardButton);
//        hardButton.setOnClickListener(v -> {
//            OverarchingViewmodel.sceneChangeRoom(GameSceneEasy.this, GameSceneHard.class);
//        });
//
//        Button leaderboardButton = findViewById(R.id.leaderboardButton);
//        leaderboardButton.setOnClickListener(v -> {
//            OverarchingViewmodel.sceneToLeaderboard(GameSceneEasy.this, Ending.class);
//        });
//        }.start();
//
//        View yourGameView = findViewById(R.layout.activity_game_easy); // Replace with your game view's ID
//        yourGameView.setFocusableInTouchMode(true);
//        yourGameView.requestFocus();
//        yourGameView.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                return onKeyDown(keyCode, event);
//            }
//        });
//
//        @Override
//        public boolean onKeyDown(int keyCode, KeyEvent event) {
//            if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
//                // Move the player left
//                player.moveLeft(stepSize);
//            } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
//                // Move the player right
//                player.moveRight(stepSize);
//            } else if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
//                // Move the player up
//                player.moveUp(stepSize);
//            } else if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
//                // Move the player down
//                player.moveDown(stepSize);
//            }
//            return super.onKeyDown(keyCode, event);
//        }
//
    }
}
