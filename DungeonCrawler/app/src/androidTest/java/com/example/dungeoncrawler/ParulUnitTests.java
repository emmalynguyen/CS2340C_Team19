package com.example.dungeoncrawler;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.example.dungeoncrawler.models.Leaderboard;
public class ParulUnitTests {
    @Test
    public void testDescendingOrder() {
        int[] scores = Leaderboard.getLeaderboard().getScores();
        for (int i = 1; i < scores.length; i++) {
            assertTrue(scores[i - 1] >= scores[i]);
        }
    }

}
