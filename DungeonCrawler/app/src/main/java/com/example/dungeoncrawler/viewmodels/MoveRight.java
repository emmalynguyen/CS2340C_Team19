package com.example.dungeoncrawler.viewmodels;


import com.example.dungeoncrawler.models.PlayerMovement;

public class MoveRight implements PlayerMovement {
    @Override
    public void move(int step, int level) {
        if (canMove(level)) {
            OverarchingViewmodel.setPlayerX(OverarchingViewmodel.getPlayerX() + step);
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
        if (OverarchingViewmodel.getPlayerX() >= 1250 || OverarchingViewmodel.getPlayerY() >= 490) {
            return false;
        }
        if (OverarchingViewmodel.getPlayerY() <= 290 && OverarchingViewmodel.getPlayerY() >= 200) {
            if (OverarchingViewmodel.getPlayerX() >= 970
                    && OverarchingViewmodel.getPlayerX() <= 1110) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean canMoveMap2() {
        if(OverarchingViewmodel.getPlayerX() >= 1160
                && (OverarchingViewmodel.getPlayerY() <= 80 || OverarchingViewmodel.getPlayerY() >= 380)){
            return false;
        }
        return canMoveMap1() && true;
    }

    @Override
    public boolean canMoveMap3() {
        if (OverarchingViewmodel.getPlayerX() >= 1250 || OverarchingViewmodel.getPlayerY() >= 490) {
            return false;
        }
        if (OverarchingViewmodel.getPlayerY() <= 290 && OverarchingViewmodel.getPlayerY() >= 200) {
            if (OverarchingViewmodel.getPlayerX() >= 970) {
                return false;
            }
        }
        return true;
    }
}
