package com.example.dungeoncrawler.viewmodels;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.style.LeadingMarginSpan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dungeoncrawler.models.Leaderboard;
import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.models.Score;
import com.example.dungeoncrawler.views.GameSceneEasy;
import com.example.dungeoncrawler.views.GameSceneHard;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OverarchingViewmodel {

    private static Leaderboard leaderboard;
    private static Score score;
    private static Player player;



    private static CountDownTimer timer;

    public OverarchingViewmodel(){
        leaderboard = Leaderboard.getLeaderboard();
        score = Score.getScore();
        player = Player.getPlayer();
    }

    public static int decreaseScore(int decrease){
        if (score.decrement(decrease) < 0) {
            score.setCount(0);
        }
        return score.getCount();

    }

    private static void sceneChange(Context context, Class destination){
        Intent intent = new Intent(context, destination);
        startActivity(context, intent, null);
        ((Activity)context).finish();
    }

    public static void sceneChangeRoom(Context context, Class destination){
        sceneChange(context, destination);
    }
    public static void sceneToRoom(Context context, Class destination){
        sceneChange(context, destination);
        startTimer();
    }
    public static void sceneToLeaderboard(Context context, Class destination){
        sceneChange(context, destination);
        stopTimer();
        addScore();
    }
    public static void sceneToConfig(Context context, Class destination){
        sceneChange(context, destination);
        resetScore();
    }
    private static void addScore(){
        String username = player.getName();
        String date = getDate();
        leaderboard.addScore(username, score.getCount(), date);
    }
    private static void startTimer(){
        timer = new CountDownTimer(100000, 1000) {
            @Override
            public void onTick(long l) {
                decreaseScore(1);
            }

            @Override
            public void onFinish() {
                startTimer();
            }
        }.start();
    }
    public static void stopTimer(){
        timer.cancel();
    }
    private static void resetScore() {
        score.setCount(100);
    }

    public static void setPlayerSprite(int sprite) {
        player.setDrawable(sprite);
    }
    public static int getPlayerSprite(){
        return player.getDrawable();
    }
    public static void setPlayerName(String name) {
        player.setName(name);
    }
    public static String getPlayerName(){
        return player.getName();
    }
    public static void setPlayerHealth(int health) {
        player.setHealth(health);
    }
    public static int getPlayerHealth(){
        return player.getHealth();
    }


    public static void setPlayerDifficulty(int difficulty) {
        player.setDifficulty(difficulty);
    }
    public static int getPlayerDifficulty(){
        return player.getDifficulty();
    }
    public static void setPlayerDifficultyName(String difficultyName) {
        player.setDifficultyName(difficultyName);
    }
    public static String getPlayerDifficultyName(){
        return player.getDifficultyName();
    }

    public static String[] getLeaderboardNames(){
        return leaderboard.getNames();
    }
    public static int[] getLeaderboardScores(){
        return leaderboard.getScores();
    }
    public static String[] getLeaderboardDates() {
        return leaderboard.getDates();
    }
    public static LiveData<Integer> getScore() {
        return score.getMutableLiveData();
    }

    public static void updateMyLiveData(int count) {
        score.setCount(count);
    }

    public static String getDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(calendar.getTime());
    }
}