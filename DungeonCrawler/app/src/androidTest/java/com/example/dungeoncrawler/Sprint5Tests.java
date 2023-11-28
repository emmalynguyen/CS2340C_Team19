package com.example.dungeoncrawler;

import static org.junit.Assert.assertTrue;

import com.example.dungeoncrawler.models.AirEnemy;
import com.example.dungeoncrawler.models.Enemy;
import com.example.dungeoncrawler.models.FireEnemy;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

import org.junit.Test;

public class Sprint5Tests {

    //Parul's sprint 5 unit tests
    @Test
    public void checkCreateFireEnemy() {
        //create the enemy
        Enemy enemy = OverarchingViewmodel.createEnemy("fire");
        // try to set it to fire
        //should be an instance of fire
        assertTrue(enemy instanceof FireEnemy);
    }

    @Test
    public void checkInitialStateEarthEnemy() {
        //create the enemy
        Enemy enemy = OverarchingViewmodel.createEnemy("earth");
        // try to set it to fire
        //should be an instance of fire
        assertTrue(enemy.getSpeed() == 20);
    }

}
