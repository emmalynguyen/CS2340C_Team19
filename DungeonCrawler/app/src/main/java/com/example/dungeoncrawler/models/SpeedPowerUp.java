package com.example.dungeoncrawler.models;

public class SpeedPowerUp implements PowerUp {

    @Override
    public void applyPowerUp(Player player) {
        // Implement the logic to increase player's movement speed
        int currentSpeed = player.getSpeed();
        player.setSpeed(currentSpeed + 10); // Example: Increase speed by 1
    }

    @Override
    public String getName() {
        return "Speed Power-Up";
    }
}