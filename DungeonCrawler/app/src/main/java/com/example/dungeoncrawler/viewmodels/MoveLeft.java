package com.example.dungeoncrawler.viewmodels;


public class MoveLeft implements PlayerMovement {
    @Override
    public void move(int step, int level) {
        if (canMove(level)) {
            OverarchingViewmodel.setPlayerX(OverarchingViewmodel.getPlayerX() - step);
        }
    }


    @Override
    public boolean canMove(int level) {
        switch (level) {
            case (1):
                return canMoveMap1();
            case (2):
                return canMoveMap2();
            case (3):
                return canMoveMap3();
            default:
                return false;
        }

    }
    @Override
    public boolean canMoveMap1() {
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

    @Override
    public boolean canMoveMap2() {
        if (OverarchingViewmodel.getPlayerX() <= 835 || OverarchingViewmodel.getPlayerY() >= 480) {
            return false;
        }
        if (OverarchingViewmodel.getPlayerY() <= 290
                && OverarchingViewmodel.getPlayerY() >= 200) {
            if (OverarchingViewmodel.getPlayerX() >= 980) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean canMoveMap3() {
        return false;
    }
}
