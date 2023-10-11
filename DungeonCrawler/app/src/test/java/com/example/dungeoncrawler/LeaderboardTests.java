package com.example.dungeoncrawler;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dungeoncrawler.models.Leaderboard;

public class LeaderboardTests {
    @Test
    public void LeaderboardBasic() {
        Leaderboard leaderboard = Leaderboard.getLeaderboard();
        leaderboard.addScore("highest", 999);

    }

    @Test
    public void Leaderboard
}
