package com.example.dungeoncrawler;

import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dungeoncrawler.models.Leaderboard;
import com.example.dungeoncrawler.models.Score;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

public class UnitTests {
    @Test
    public void leaderboardBasic() {
        Leaderboard leaderboard = com.example.dungeoncrawler.models.Leaderboard.getLeaderboard();
        leaderboard.clear();
        int[] scores = leaderboard.getScores();
        int[] testArray = new int[6];
        testArray[0] = Integer.MAX_VALUE;

        assertArrayEquals(testArray, scores);

        leaderboard.addScore("highest", 999, null);
        leaderboard.addScore("bottom", -1, null);
        testArray[1] = 999;

        assertArrayEquals(testArray, scores);
    }

    @Test
    public void leaderboardSort() {
        Leaderboard leaderboard = com.example.dungeoncrawler.models.Leaderboard.getLeaderboard();
        leaderboard.clear();
        int[] scores = leaderboard.getScores();
        int[] testArray = new int[6];
        testArray[0] = Integer.MAX_VALUE;

        leaderboard.addScore("3", 3, null);
        leaderboard.addScore("6", 6, null);
        leaderboard.addScore("5", 5, null);
        leaderboard.addScore("2", 2, null);
        leaderboard.addScore("1", 1, null);
        leaderboard.addScore("4", 4, null);

        for (int i = 1; i <= 5; i++) {
            testArray[i] = 7 - i;
        }

        assertArrayEquals(testArray, scores);
    }

    @Test // Tanavi Test
    public void scoreMinimum() {
        Score score = Score.getScore();
        new OverarchingViewmodel();

        assertEquals(100, score.getCount());

        OverarchingViewmodel.decreaseScore(150);
        assertEquals(0, score.getCount());
    }

    @Test // Tanavi Test
    public void scoreReset() {
        Score score = Score.getScore();
        OverarchingViewmodel.setPlayerName("Score Test");
        OverarchingViewmodel.addScore();
        score = Score.getScore();
        //new OverarchingViewmodel();

        assertEquals(100, score.getCount());

        OverarchingViewmodel.decreaseScore(10);
        assertEquals(90, score.getCount());

        OverarchingViewmodel.addScore();
        assertEquals(100, score.getCount());
    }

}
