package com.example.dungeoncrawler.models;


import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;

public class HealthPowerUp implements PowerUp {
    @Override
    public void applyPowerUp(Player player) {
        // Implements the logic to increase player's health
        OverarchingViewmodel.increaseScore(100);
    }

    @Override
    public String getName() {
        return "Health Power-Up";
    }
}
