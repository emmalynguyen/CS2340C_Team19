package com.example.dungeoncrawler.models;

public class Leaderboard {

    //singleton instance
    private static Leaderboard leaderboard;
    private int[] scores;
    private String[] names;

    //private constructor
    private Leaderboard() {
        scores = new int[5];
        names = new String[5];
    }

    //get instance
    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }

    public void addScore(String name, int score){
        for(int i = 4; i >= 0; i--) {
            if (score < scores[i]) {
                for (int j = 4; j > i + 1; i--) {
                    scores[i] = scores[i - 1];
                    names[i] = names[i - 1];
                }
                scores[i + 1] = score;
                names[i + 1] = name;
            }
        }
    }

    public int[] getScores() {
        return scores;
    }

    public String[] getNames() {
        return names;
    }
}
