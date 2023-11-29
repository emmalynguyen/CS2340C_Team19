package com.example.dungeoncrawler.models;







public class PowerUpDecorator implements PowerUp {
    private PowerUp powerUp;


    public PowerUpDecorator(PowerUp powerUp) {
        this.powerUp = powerUp;
    }


    @Override
    public void applyPowerUp(Player player) {
        powerUp.applyPowerUp(player);
    }


    @Override
    public String getName() {
        return powerUp.getName();
    }


}
