package com.example.dungeoncrawler.viewmodels;


public class MoveDown implements Movement {
    @Override
    public void move(int step) {
        if (canMove()) {
            OverarchingViewmodel.setPlayerY(OverarchingViewmodel.getPlayerY() + step);
        }
    }

    @Override
    public boolean canMove() {
        if (OverarchingViewmodel.getPlayerY() >= 480) {
            if (OverarchingViewmodel.getPlayerX() >= 1050
                    && OverarchingViewmodel.getPlayerX() <= 1090) {
                return true;
            }
            return false;
        }
        if (OverarchingViewmodel.getPlayerX() >= 980
                && OverarchingViewmodel.getPlayerX() <= 1110) {
            if (OverarchingViewmodel.getPlayerY() >= 190
                    && OverarchingViewmodel.getPlayerY() <= 290) {
                return false;
            }
        }
        return true;
    }
}
