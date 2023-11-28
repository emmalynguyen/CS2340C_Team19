package com.example.dungeoncrawler.views;

import android.view.View;

import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.models.PowerUp;

public class VisualPowerUpDecorator implements PowerUp {
    private PowerUp powerUp;
    private AndroidPowerUpVisualization powerUpVisualization;


    public VisualPowerUpDecorator(PowerUp powerUp,
                                  AndroidPowerUpVisualization powerUpVisualization) {
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
