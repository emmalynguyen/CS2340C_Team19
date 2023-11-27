package com.example.dungeoncrawler.models;


public class HealthPowerUp implements PowerUp{
    @Override
    public void applyPowerUp(Player player) {
        // Implements the logic to increase player's health
        int currentHealth = player.getHealth();
        player.setHealth(currentHealth + 10); // Example: Increase health by 10
    }


    @Override
    public String getName() {
        return "Health Power-Up";
    }
}
