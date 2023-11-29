package com.example.dungeoncrawler.viewmodels;


import com.example.dungeoncrawler.models.PlayerMovement;

public class MoveRight implements PlayerMovement {
    @Override
    public void move(int step, int level, int speed) {
        if (canMove(level)) {
            OverarchingViewmodel.setPlayerX(OverarchingViewmodel.getPlayerX() + (step * speed));
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
        if (OverarchingViewmodel.getPlayerX() >= 1300 || OverarchingViewmodel.getPlayerY() >= 620) {
            return false;
        }
        if (OverarchingViewmodel.getPlayerY() <= 350 && OverarchingViewmodel.getPlayerY() >= 270) {
            if (OverarchingViewmodel.getPlayerX() >= 970
                    && OverarchingViewmodel.getPlayerX() <= 1110) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean canMoveMap2() {
        if (OverarchingViewmodel.getPlayerX() >= 1180
                && (OverarchingViewmodel.getPlayerY() <= 120
                || OverarchingViewmodel.getPlayerY() >= 500)) {
            return false;
        }
        return canMoveMap1();
    }

    @Override
    public boolean canMoveMap3() {
        return canMoveMap1();
    }
}
