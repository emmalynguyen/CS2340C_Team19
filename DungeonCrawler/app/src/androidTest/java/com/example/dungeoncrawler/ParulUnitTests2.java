package com.example.dungeoncrawler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.example.dungeoncrawler.models.Player;

public class ParulUnitTests2 {
    //    @Test
    //    public void testScoreIsPositive() {
    //        Leaderboard.getLeaderboard().addScore("Player3", -10);
    //        int[] scores = Leaderboard.getLeaderboard().getScores();
    //        assertEquals(0, scores[0]);
    //
    //    }
    @Test
    public void checkDifficultyMedium() {
        Player newPlayer = Player.getPlayer();
        newPlayer.setDifficulty(2);
        assertEquals(2, newPlayer.getDifficulty());
    }
}