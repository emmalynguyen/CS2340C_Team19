package com.example.dungeoncrawler.viewmodels;


public class MoveDown implements PlayerMovement {
    @Override
    public void move(int step, int level) {
        if (canMove(level)) {
            OverarchingViewmodel.setPlayerY(OverarchingViewmodel.getPlayerY() + step);
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

    @Override
    public boolean canMoveMap2() {
        return false;
    }

    @Override
    public boolean canMoveMap3() {
        if (OverarchingViewmodel.getPlayerY() >= 480) {
            if (OverarchingViewmodel.getPlayerX() >= 1050
                    && OverarchingViewmodel.getPlayerX() <= 1090) {
                return true;
            }
            return false;
        }
        if (OverarchingViewmodel.getPlayerX() >= 980) {
            if (OverarchingViewmodel.getPlayerY() >= 190
                    && OverarchingViewmodel.getPlayerY() <= 290) {
                return false;
            }
        }
        return true;
    }
}
