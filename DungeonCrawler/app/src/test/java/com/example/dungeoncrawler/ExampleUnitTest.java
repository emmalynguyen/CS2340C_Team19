package com.example.dungeoncrawler;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.models.Score;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void checkPlayerInitialization() {
        Player newPlayer = Player.getPlayer();
        assertEquals("Expected health to be 100", 100, newPlayer.getHealth());

    }
    @Test
    public void checkDecrement() {
        Score s = Score.getScore();
        assertEquals("Expected health to be 99", 99, s.decrement(1));
    }
    @Test
    public void checkDecreaseScore() {
        OverarchingViewmodel m = new OverarchingViewmodel();
        assertEquals("Expected health to be 95", 95, m.decreaseScore(5));
    }
}
