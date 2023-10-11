package com.example.dungeoncrawler;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dungeoncrawler.models.Leaderboard;

public class LeaderboardTests {
    @Test
    public void LeaderboardBasic() {
        Leaderboard leaderboard = com.example.dungeoncrawler.models.Leaderboard.getLeaderboard();
        leaderboard.clear();
        int[] scores = leaderboard.getScores();
        int[] testArray = new int[6];
        testArray[0] = Integer.MAX_VALUE;

        assertArrayEquals(testArray, scores);

        leaderboard.addScore("highest", 999);
        leaderboard.addScore("bottom", -1);
        testArray[1] = 999;

        assertArrayEquals(testArray, scores);
    }

    @Test
    public void LeaderboardSort() {
        Leaderboard leaderboard = com.example.dungeoncrawler.models.Leaderboard.getLeaderboard();
        leaderboard.clear();
        int[] scores = leaderboard.getScores();
        int[] testArray = new int[6];
        testArray[0] = Integer.MAX_VALUE;

        leaderboard.addScore("3", 3);
        leaderboard.addScore("6", 6);
        leaderboard.addScore("5", 5);
        leaderboard.addScore("2", 2);
        leaderboard.addScore("1", 1);
        leaderboard.addScore("4", 4);

        for(int i = 1; i <= 5; i++) {
            testArray[i] = 7-i;
        }

        assertArrayEquals(testArray, scores);
    }

}
