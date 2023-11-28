package com.example.dungeoncrawler.models;

public class TeleportationPowerUp implements PowerUp {
    @Override
    public void applyPowerUp(Player player) {
        // Implements the logic for teleportation
        int newX = player.getX() + 300; // Set your desired X-coordinate for teleportation
        int newY = player.getY() + 300; // Set your desired Y-coordinate for teleportation

        player.setX(newX);
        player.setY(newY);
    }

    @Override
    public String getName() {
        return "Teleportation Power-Up";
    }
}