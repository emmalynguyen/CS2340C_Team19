package com.example.dungeon_crawler;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    private PlayerView playerView;
    private float playerX, playerY;
    private Random random = new Random();
    RelativeLayout gameLayout;
    int screenWidth;
    int screenHeight;

    private double difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameLayout = findViewById(R.id.gameLayout);
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        // Spawn player in middle of screen
        playerX = screenWidth / 2;
        playerY = screenHeight / 2;


        // Get difficulty selected from Main screen.
        difficulty = getIntent().getDoubleExtra("difficulty", 1);

        playerView = new PlayerView(this, playerX, playerY, 100);
        gameLayout.addView(playerView);
        // Create dot list
        initializeDots();
        // Draw dots on screen
        drawDots();

        /*
        Timer to call checkCollisions every .5 seconds to determine if dots have expired yet.
         */
//        dotTimer = new Timer();
//        dotTimer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        checkCollisions();
//                        respawnDotsIfNeeded();
//                    }
//                });
//            }
//        }, 0, 500); // Check every .5 seconds
    }

    // Handle key events to move the player
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("here");
        System.out.println("key: " + keyCode);
        return true;
    }

    private void initializeDots() {
        dots = new ArrayList<Dot>();
        for(int i = 0; i < 50 + difficulty*25; i++){
            dots.add(new Dot(i*10, i*10, i));
        }
    }

    /*
    Method to create dot objects. Maps a dot object to a specific dotView.
     */
    private void drawDots() {
        for (Dot dot : dots) {
            DotView newDot = new DotView(this, dot);
            gameLayout.addView(newDot);
            dotViewMap.put(dot, newDot);
        }
    }

    // Maintains 20 dots on screen
    private void respawnDotsIfNeeded() {
        dots = new ArrayList<Dot>();
        for(int i = 0; i < 20-dots.size(); i++){
            dots.add(new Dot(i*10, i*10, i));
            DotView newDot = new DotView(this, dots.get(dots.size()-1));
            gameLayout.addView(newDot);
            dotViewMap.put(dots.get(dots.size()-1), newDot);
        }
        drawDots();
    }

    // Recreates the dots. Respawn mechanic
    private void respawnDot() {
        Dot dot = new Dot(random.nextInt(100),random.nextInt(100),random.nextInt(10));
        DotView newDot = new DotView(this, dot);
        gameLayout.addView(newDot);
        dotViewMap.put(dot, newDot);
    }

    /*
    Method that checks to see if any collision has occurred.
     */
    private void checkCollisions() {
        for (int i = 0; i < dots.size(); i++) {
            Dot dot = dots.get(i);
            if (dot.isVisible() && isCollision(playerView, dot)) {
                dot.setInvisible();
                gameLayout.removeView(dotViewMap.get(dot));
                dots.remove(i);
                dotCount++;

                dotCountTextView.setText("Dots Collected: " + dotCount);
                if (dotCount >= dotsToWin) {
                    launchGameWinActivity();
                }
            } else if (dot.isExpired()) { // TODO: Checks if dots have expired.
                dot.setInvisible();
            }
        }
    }

    /*
    Method that has logic to detect collisions.
    */
    private boolean isCollision(PlayerView playerView, Dot dot) {
        float playerX = playerView.getX();
        float playerY = playerView.getY();
        int playerRadius = playerView.getRadius();
        float dotX = dot.getX();
        float dotY = dot.getY();
        int dotRadius = dot.getRadius();

            /*
            Creates a rectangle around dot, and checks for an intersection between player rect and
            dot rect. Intersection = collision.
             */
        RectF playerRect = new RectF(playerX - playerRadius, playerY - playerRadius, playerX + playerRadius, playerY + playerRadius);
        RectF dotRect = new RectF(dotX - dotRadius, dotY - dotRadius, dotX + dotRadius, dotY + dotRadius);

        return playerRect.intersect(dotRect);
    }

    // Changes game screen to GameWinActivity
    private void launchGameWinActivity() {
        Intent intent = new Intent(this, GameWinActivity.class);
        startActivity(intent);
        finish();
    }
}
