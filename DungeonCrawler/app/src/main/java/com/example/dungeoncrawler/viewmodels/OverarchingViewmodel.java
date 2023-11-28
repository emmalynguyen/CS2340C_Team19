package com.example.dungeoncrawler.viewmodels;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.KeyEvent;

import androidx.lifecycle.LiveData;

import com.example.dungeoncrawler.models.AirEnemy;
import com.example.dungeoncrawler.models.EarthEnemy;
import com.example.dungeoncrawler.models.Enemy;
import com.example.dungeoncrawler.models.FireEnemy;
import com.example.dungeoncrawler.models.Leaderboard;
import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.models.PlayerMovement;
import com.example.dungeoncrawler.models.Score;
import com.example.dungeoncrawler.models.WaterEnemy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OverarchingViewmodel {

    private static Leaderboard leaderboard;
    private static Score score;
    private static Player player;
    private static PlayerMovement playerMovement;

    private static int level;

    private static ArrayList<Enemy> enemies;



    private static CountDownTimer timer;

    public OverarchingViewmodel() {
        leaderboard = Leaderboard.getLeaderboard();
        score = Score.getScore();
        player = Player.getPlayer();
        level = 0;
        enemies = new ArrayList<>();
    }

    public static int decreaseScore(int decrease) {
        if (score.decrement(decrease) < 0) {
            score.setCount(0);
        }
        return score.getCount();

    }

    public static int increaseScore(int increase) {
        return score.increment(increase);
    }

    private static void sceneChange(Context context, Class destination) {
        Intent intent = new Intent(context, destination);
        enemies = new ArrayList<>();
        startActivity(context, intent, null);
        ((Activity) context).finish();
    }

    public static void sceneChangeRoom(Context context, Class destination) {
        sceneChange(context, destination);
        player.setX(1050);
        player.setY(100);
        level++;
    }
    public static void sceneToRoom(Context context, Class destination) {
        sceneChange(context, destination);
        level = 1;
        player.setX(1050);
        player.setY(100);
        startTimer();
    }
    public static void sceneToLeaderboard(Context context, Class destination) {
        sceneChange(context, destination);
        stopTimer();
        addScore();
    }
    public static void sceneToConfig(Context context, Class destination) {
        sceneChange(context, destination);
        resetScore();
    }
    public static void addScore() {
        if (score.getCount() > 0) {
            String username = player.getName();
            String date = getDate();
            leaderboard.addScore(username, score.getCount(), date);
        }
    }
    private static void startTimer() {
        timer = new CountDownTimer(100000, 1000) {
            @Override
            public void onTick(long l) {
                decreaseScore(1);
                player.notifyObservers();
                for (Enemy enemy : enemies) {
                    enemy.move();
                }
            }

            @Override
            public void onFinish() {
                startTimer();
            }
        }.start();
    }

    private static void scoreOnEnemyDeath() {
        increaseScore(3);
        player.notifyObservers();
    }

    private static void scoreOnAttack() {
        increaseScore(2);
        player.notifyObservers();
    }

    public static boolean inBoundEasy() {
        return false;
    }
    public static void stopTimer() {
        timer.cancel();
    }
    private static void resetScore() {
        score.setCount(300);
    }


    public static void setPlayerSprite(int sprite) {
        player.setDrawable(sprite);
    }
    public static int getPlayerSprite() {
        return player.getDrawable();
    }
    public static void setPlayerName(String name) {
        player.setName(name);
    }
    public static String getPlayerName() {
        return player.getName();
    }
    public static void setPlayerHealth(int health) {
        player.setHealth(health);
    }
    public static int getPlayerHealth() {
        return player.getHealth();
    }


    public static void setPlayerDifficulty(int difficulty) {
        player.setDifficulty(difficulty);
    }
    public static int getPlayerDifficulty() {
        return player.getDifficulty();
    }
    public static void setPlayerDifficultyName(String difficultyName) {
        player.setDifficultyName(difficultyName);
    }
    public static String getPlayerDifficultyName() {
        return player.getDifficultyName();
    }

    public static String[] getLeaderboardNames() {
        return leaderboard.getNames();
    }
    public static int[] getLeaderboardScores() {
        return leaderboard.getScores();
    }
    public static String[] getLeaderboardDates() {
        return leaderboard.getDates();
    }
    public static LiveData<Integer> getScore() {
        return score.getMutableLiveData();
    }
    public static int getCount() {
        return score.getCount();
    }

    public static void updateMyLiveData(int count) {
        score.setCount(count);
    }

    public static String getDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(calendar.getTime());
    }

    public static void setMovementStrategy(PlayerMovement newPlayerMovement) {
        playerMovement = newPlayerMovement;
    }
    public static void move(int step) {
        playerMovement.move(step, level, player.getSpeed());
        player.notifyObservers();
    }
    public static void keyDown(int keyCode) {
        PlayerMovement playerMovement = null;
        int step = 10;
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_UP:
            MoveUp moveUp = new MoveUp();
            OverarchingViewmodel.setMovementStrategy(moveUp);
            move(step);
            break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
            MoveDown moveDown = new MoveDown();
            OverarchingViewmodel.setMovementStrategy(moveDown);
            move(step);
            break;
        case KeyEvent.KEYCODE_DPAD_LEFT:
            MoveLeft moveLeft = new MoveLeft();
            OverarchingViewmodel.setMovementStrategy(moveLeft);
            move(step);
            break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
            MoveRight moveRight = new MoveRight();
            OverarchingViewmodel.setMovementStrategy(moveRight);
            move(step);
            break;
        default:
            break;
        }
    }

    public static Enemy createEnemy(String enemyType) {
        Enemy enemy = null;
        if (enemyType.equals("air")) {
            enemy = new AirEnemy();
        } else if (enemyType.equals("fire")) {
            enemy = new FireEnemy();
        } else if (enemyType.equals("water")) {
            enemy = new WaterEnemy();
        } else if (enemyType.equals("earth")) {
            enemy = new EarthEnemy();
        }
        return enemy;
    }
    public static void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public static ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public static void setObserver(Observer observer) {
        player.registerObserver(observer);
    }
    public static void removeObserver(Observer observer) {
        player.removeObserver(observer);
    }

    public static int getPlayerX() {
        return player.getX();
    }
    public static int getPlayerY() {
        return player.getY();
    }

    public static void setPlayerX(int x) {
        player.setX(x);
    }
    public static void setPlayerY(int y) {
        player.setY(y);
    }

    public static int getLevel() {
        return level;
    }
}
