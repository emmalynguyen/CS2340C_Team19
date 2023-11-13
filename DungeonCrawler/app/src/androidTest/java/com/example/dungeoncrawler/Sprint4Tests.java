package com.example.dungeoncrawler;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.dungeoncrawler.models.AirEnemy;
import com.example.dungeoncrawler.models.Enemy;
import com.example.dungeoncrawler.models.Score;
import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

public class Sprint4Tests implements Observer {

    private int observe;

    @Before
    public void setup() {
        new OverarchingViewmodel();
        Score.getScore();
        observe = 0;
    }

    // tanavi's sprint 4 junits

    @Test
    public void checkInitialLevel() {
        OverarchingViewmodel m = new OverarchingViewmodel();
        assertEquals("Expected level 0", 0, m.getLevel());
    }

    @Test
    public void checkPlayerX() {
        OverarchingViewmodel m = new OverarchingViewmodel();
        assertEquals("Expected X to be 0", 0, m.getPlayerX());
    }

    // parul's sprint 4 junits

    @Test
    public void checkPlayerY() {
        OverarchingViewmodel m = new OverarchingViewmodel();
        assertEquals("Expected Y to be 100", 100, m.getPlayerY());
    }

    @Test
    public void checkSetPlayerY() {
        OverarchingViewmodel m = new OverarchingViewmodel();
        m.setPlayerY(100);
        assertEquals("Expected Y to be 100", 100, m.getPlayerY());
    }

    // Sneha's sprint 4 junits

    @Test
    public void checkCreateAirEnemy() {
        Enemy enemy = OverarchingViewmodel.createEnemy("air");

        assertTrue(enemy instanceof AirEnemy);
    }

    @Test
    public void checkCreateEnemyWithInvalidType() {
        OverarchingViewmodel model = new OverarchingViewmodel();
        Enemy enemy = model.createEnemy("invalidType");

        assertNull(enemy);
    }

    // cole's sprint 4 junits
    @Test
    public void checkAddEnemy() {
        Enemy airEnemy = OverarchingViewmodel.createEnemy("invalidType");
        OverarchingViewmodel.addEnemy(airEnemy);

        assertEquals(airEnemy, OverarchingViewmodel.getEnemies().get(0));
    }


    @Test
    public void getCount() {
        Score score = Score.getScore();
        assertEquals(score.getCount(), 300);
    }

    @Override
    public void update() {
        observe += 1;
    }
}
