package com.example.dungeoncrawler.models;

public class Leaderboard {

    //singleton instance
    private static Leaderboard leaderboard;
    private int[] scores;
    private String[] names;
    private String[] dates;

    //private constructor
    private Leaderboard() {
        scores = new int[6];
        scores[0] = Integer.MAX_VALUE;
        names = new String[6];
        dates = new String[6];
    }

    //get instance
    public static Leaderboard getLeaderboard() {
        if (leaderboard == null) {
            leaderboard = new Leaderboard();
        }
        return leaderboard;
    }

    public void addScore(String name, int score, String date) {
        for (int i = 5; i >= 0; i--) {
            if (score < scores[i]) {
                for (int j = 5; j > i + 1; j--) {
                    scores[j] = scores[j - 1];
                    names[j] = names[j - 1];
                    dates[j] = dates[j - 1];
                }
                if (i < 5) {
                    scores[i + 1] = score;
                    names[i + 1] = name;
                    dates[i + 1] = date;
                }
                return;
            }
        }
    }

    public void clear() {
        leaderboard = new Leaderboard();
        for (int i = 1; i < 6; i++) {
            scores[i] = 0;
            names[i] = null;
            dates[i] = null;
        }
    }

    public int[] getScores() {
        return scores;
    }
    public String[] getNames() {
        return names;
    }
    public String[] getDates() {
        return dates;
    }
}
