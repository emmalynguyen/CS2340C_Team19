package com.example.dungeoncrawler.models;


import android.view.View;

import com.example.dungeoncrawler.views.PowerUpVisualization;

public class VisualPowerUpDecorator implements PowerUp{
    private PowerUp powerUp;
    private PowerUpVisualization powerUpVisualization;

    public VisualPowerUpDecorator(PowerUp powerUp, PowerUpVisualization powerUpVisualization) {
        this.powerUp = powerUp;
        this.powerUpVisualization = powerUpVisualization;
    }

    @Override
    public void applyPowerUp(Player player) {
        powerUp.applyPowerUp(player);
        powerUpVisualization.hide(); // Hide the power-up button after applying
    }

    @Override
    public String getName() {
        return powerUp.getName();
    }

    public void display(View.OnClickListener onClickListener) {
        powerUpVisualization.display(onClickListener);
    }
}
