package com.example.dungeoncrawler.models;

import android.util.Log;

public class Leaderboard {

    //singleton instance
    private static Leaderboard leaderboard;
    private int[] scores;
    private String[] names;

    //private constructor
    private Leaderboard() {
        scores = new int[6];
        scores[0] = Integer.MAX_VALUE;
        names = new String[6];
    }

    //get instance
    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }

    public void addScore(String name, int score){
        for(int i = 5; i >= 0; i--) {
            if (score < scores[i]) {
                for (int j = 5; j > i + 1; j--) {
                    scores[j] = scores[j - 1];
                    names[j] = names[j - 1];
                }
                if(i < 5) {
                    scores[i + 1] = score;
                    names[i + 1] = name;
                }
                return;
            }
        }
    }

    public void clear(){
        leaderboard = new Leaderboard();
    }

    public int[] getScores() {
        return scores;
    }

    public String[] getNames() {
        return names;
    }
}
