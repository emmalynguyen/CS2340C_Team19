package com.example.dungeoncrawler;

import static org.junit.Assert.assertTrue;

import com.example.dungeoncrawler.models.AirEnemy;
import com.example.dungeoncrawler.models.Enemy;
import com.example.dungeoncrawler.models.FireEnemy;
import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.models.SpeedPowerUp;
import com.example.dungeoncrawler.models.TeleportationPowerUp;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;
import com.example.dungeoncrawler.models.HealthPowerUp;

import org.junit.Assert;
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
    @Test
    public void checkTeleportationPowerUp() {
        // Assuming Player class has a method to get a Player instance and methods to get X and Y coordinates

        Player newPlayer = Player.getPlayer(); // or new Player(), depending on the Player class implementation

        int initialX = newPlayer.getX();
        int initialY = newPlayer.getY();

        // Applying the teleportation power-up
        TeleportationPowerUp teleportationPowerUp = new TeleportationPowerUp();
        teleportationPowerUp.applyPowerUp(newPlayer);

        // Asserting that the player's position has changed to the expected coordinates
        Assert.assertNotEquals("Player's X-coordinate differs",
                initialX, newPlayer.getX());

        Assert.assertNotEquals("Player's Y-coordinate differs",
                initialY, newPlayer.getY());

        Assert.assertEquals("Player's X-coordinate 200",
                200, newPlayer.getX());

        Assert.assertEquals("Player's Y-coordinate 150",
                150, newPlayer.getY());
    }

    public void checkTeleportationPowerUpString(){
        // Assuming Player class has a method to get a Player instance and methods to get X and Y coordinates
        Player newPlayer = Player.getPlayer(); // or new Player(), depending on the Player class implementation

        int initialX = newPlayer.getX();

        int initialY = newPlayer.getY();

        // Applying the teleportation power-up
        TeleportationPowerUp teleportationPowerUp = new TeleportationPowerUp();

        teleportationPowerUp.applyPowerUp(newPlayer);

        assertTrue(teleportationPowerUp.getName().equals("Teleportation Power-Up"));
    }

    //Tanavi's Junits
    @Test
    public void checkSpeedIncrease() {

        Player newPlayer = Player.getPlayer(); // or new Player(), depending on the Player class implementation
        int initialSpeed = newPlayer.getSpeed();

        // Applying the speed power-up
        SpeedPowerUp speedPowerUp = new SpeedPowerUp();
        speedPowerUp.applyPowerUp(newPlayer);

        // Asserting that the speed has increased by the expected amount (1 in this case)
        Assert.assertEquals("Speed should increase by 1 after applying SpeedPowerUp",
                initialSpeed + 1, newPlayer.getSpeed());
    }

    @Test
    public void checkSpeedPowerUpName() {
        // Creating an instance of SpeedPowerUp
        SpeedPowerUp speedPowerUp = new SpeedPowerUp();

        // Asserting that the getName method returns the correct name
        Assert.assertEquals("The name of the power-up should be 'Speed Power-Up'",
                "Speed Power-Up", speedPowerUp.getName());
    }

    //Emmaly's Junits

}
