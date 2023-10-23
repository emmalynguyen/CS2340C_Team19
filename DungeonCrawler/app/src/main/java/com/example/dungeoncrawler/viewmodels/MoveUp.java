package com.example.dungeoncrawler.viewmodels;


public class MoveUp implements Movement {
    @Override
    public void move(int step) {
        if (canMove()) {
            OverarchingViewmodel.setPlayerY(OverarchingViewmodel.getPlayerY() - step);
        }
    }

    @Override
    public boolean canMove() {
        if (OverarchingViewmodel.getPlayerY() <= 50) {
            return false;
        }
        if (OverarchingViewmodel.getPlayerX() >= 980 && OverarchingViewmodel.getPlayerX() <= 1110) {
            if (OverarchingViewmodel.getPlayerY() <= 300
                    && OverarchingViewmodel.getPlayerY() >= 200) {
                return false;
            }
        }
        return true;
    }
}
