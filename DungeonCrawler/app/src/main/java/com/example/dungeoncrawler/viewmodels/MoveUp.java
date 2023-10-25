package com.example.dungeoncrawler.viewmodels;


public class MoveUp implements PlayerMovement {
    @Override
    public void move(int step, int level) {
        if (canMove(level)) {
            OverarchingViewmodel.setPlayerY(OverarchingViewmodel.getPlayerY() - step);
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

    @Override
    public boolean canMoveMap2() {
        if (OverarchingViewmodel.getPlayerY() <= 50) {
            return false;
        }
        if (OverarchingViewmodel.getPlayerX() >= 980) {
            if (OverarchingViewmodel.getPlayerY() <= 300
                    && OverarchingViewmodel.getPlayerY() >= 200) {
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
