package com.example.dungeoncrawler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.models.Leaderboard;

public class ParulUnitTests2 {
    @Test
    public void testScoreIsPositive() {
        Leaderboard.getLeaderboard().addScore("Player3", -10);
        int[] scores = Leaderboard.getLeaderboard().getScores();
        assertEquals(0, scores[0]);

    }
}