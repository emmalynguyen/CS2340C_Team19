package com.example.dungeoncrawler.models;

public class TeleportationPowerUp implements PowerUp {
    @Override
    public void applyPowerUp(Player player) {
        // Implements the logic for teleportation
        int newX = 200; // Set your desired X-coordinate for teleportation
        int newY = 150; // Set your desired Y-coordinate for teleportation

        player.setX(newX);
        player.setY(newY);
    }

    @Override
    public String getName() {
        return "Teleportation Power-Up";
    }
}