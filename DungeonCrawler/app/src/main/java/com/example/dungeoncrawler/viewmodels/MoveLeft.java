package com.example.dungeoncrawler.viewmodels;


public class MoveLeft implements Movement {
    @Override
    public void move(int step) {
        if (canMove()) {
            OverarchingViewmodel.setPlayerX(OverarchingViewmodel.getPlayerX() - step);
        }
    }

    public boolean canMove() {
        if (OverarchingViewmodel.getPlayerX() <= 835 || OverarchingViewmodel.getPlayerY() >= 480) {
            return false;
        }
        if (OverarchingViewmodel.getPlayerY() <= 290
                && OverarchingViewmodel.getPlayerY() >= 200) {
            if (OverarchingViewmodel.getPlayerX() >= 980
                    && OverarchingViewmodel.getPlayerX() <= 1120) {
                return false;
            }
        }
        return true;
    }
}
