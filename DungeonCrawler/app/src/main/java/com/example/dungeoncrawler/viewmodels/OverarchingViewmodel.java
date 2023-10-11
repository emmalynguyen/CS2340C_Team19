package com.example.dungeoncrawler.viewmodels;

import android.graphics.drawable.Drawable;
import android.text.style.LeadingMarginSpan;

import com.example.dungeoncrawler.models.Leaderboard;
import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.models.Score;

public class OverarchingViewmodel {

    private static Leaderboard leaderboard;
    private static Score score;
    private static Player player;

    public OverarchingViewmodel(){
        leaderboard = Leaderboard.getLeaderboard();
        score = Score.getScore();
        player = Player.getPlayer();
    }

    public static int decreaseScore(int decrease){
        score.decrement(decrease);
        if(score.getCount() <= 0) {
            score.setCount(0);
        }
        return score.getCount();
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

    public static void addScore(String username){
        Leaderboard.getLeaderboard().addScore(username, score.getCount());
        score.resetCount();
    }
    public static String[] getLeaderboardNames(){
        return leaderboard.getNames();
    }
    public static int[] getLeaderboardScores(){
        return leaderboard.getScores();
    }



}
