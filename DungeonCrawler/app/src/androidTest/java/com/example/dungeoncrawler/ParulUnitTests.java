package com.example.dungeoncrawler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.models.Leaderboard;
import java.util.ArrayList;
public class ParulUnitTests {
    @Test
    public void testDescendingOrder() {

        // adding the scores to the leaderboard here (Author: Parul)
        Leaderboard.getLeaderboard().addScore("Player1", 10);
        Leaderboard.getLeaderboard().addScore("Player2", 20);
        Leaderboard.getLeaderboard().addScore("Player3", 30);

        int[] scores = Leaderboard.getLeaderboard().getScores();
        // checks for descending order by running a for loop to compare values in the array
        for (int i = 1; i < scores.length ; i++) {
            assertTrue(scores[i - 1] >= scores[i]);
        }
    }

}
