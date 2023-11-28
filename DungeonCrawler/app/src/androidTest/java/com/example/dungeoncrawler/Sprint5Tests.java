package com.example.dungeoncrawler;

import static org.junit.Assert.assertTrue;

import com.example.dungeoncrawler.models.AirEnemy;
import com.example.dungeoncrawler.models.Enemy;
import com.example.dungeoncrawler.models.FireEnemy;
import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;
import com.example.dungeoncrawler.models.HealthPowerUp;

import org.junit.Before;
import org.junit.Test;

public class Sprint5Tests {

    private int observe;
    @Before
    public void setup() {
        new OverarchingViewmodel();
        observe = 0;
    }

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

    // Sneha's Sprint 5
    @Test
    public void checkHealthPowerUp() {
        //first make a new player
        //object will be tested
        Player newPlayer = Player.getPlayer();
        //initialize the health of the player originally
        int initialHealth = newPlayer.getHealth();

        // Applying the health power-up
        HealthPowerUp healthPowerUp = new HealthPowerUp();
        healthPowerUp.applyPowerUp(newPlayer);

        // Asserting that the health has increased by the expected amount (10 in this case)
        assertTrue(initialHealth + 10 == newPlayer.getHealth());
    }

    @Test
    public void checkHealthPowerUpNameLog() {
        //first make a new player
        //object will be tested
        Player newPlayer = Player.getPlayer();
        //initialize the health of the player originally
        int initialHealth = newPlayer.getHealth();

        // Applying the health power-up
        HealthPowerUp healthPowerUp = new HealthPowerUp();
        healthPowerUp.applyPowerUp(newPlayer);

        // Asserting that the health has increased by the expected amount (10 in this case)
        assertTrue(healthPowerUp.getName().equals("Health Power-Up"));
    }

    //Cole's Junits

    
}
