package com.example.dungeoncrawler;

import static org.junit.Assert.assertEquals;
import com.example.dungeoncrawler.models.Player;
import org.junit.Test;

public class EmmalyJUnits {
    @Test
    public void checkDifficultyEasy() {
        Player newPlayer = Player.getPlayer();
        newPlayer.setDifficulty(1);
        assertEquals(1, newPlayer.getDifficulty());
    }

    @Test
    public void checkHealthEasy() {
        Player newPlayer = Player.getPlayer();
        newPlayer.setHealth(100);
        assertEquals(100, newPlayer.getHealth());
    }

    @Test
    public void checkDifficultyHard() {
        Player newPlayer = Player.getPlayer();
        newPlayer.setDifficulty(1);
        assertEquals(3, newPlayer.getDifficulty());
    }

    @Test
    public void checkHealthHard() {
        Player newPlayer = Player.getPlayer();
        newPlayer.setHealth(100);
        assertEquals(50, newPlayer.getHealth());
    }
}
