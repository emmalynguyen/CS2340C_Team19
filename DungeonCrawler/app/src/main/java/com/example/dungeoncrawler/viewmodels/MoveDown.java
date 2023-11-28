package com.example.dungeoncrawler.viewmodels;


import com.example.dungeoncrawler.models.PlayerMovement;

public class MoveDown implements PlayerMovement {
    @Override
    public void move(int step, int level, int speed) {
        if (canMove(level)) {
            OverarchingViewmodel.setPlayerY(OverarchingViewmodel.getPlayerY() + (step * speed));
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
        if (OverarchingViewmodel.getPlayerY() >= 600) {
            if (OverarchingViewmodel.getPlayerX() >= 1030
                    && OverarchingViewmodel.getPlayerX() <= 1080) {
                return true;
            }
            return false;
        }
        if (OverarchingViewmodel.getPlayerX() >= 980
                && OverarchingViewmodel.getPlayerX() <= 1110) {
            if (OverarchingViewmodel.getPlayerY() >= 250
                    && OverarchingViewmodel.getPlayerY() <= 350) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean canMoveMap2() {
        if (OverarchingViewmodel.getPlayerY() >= 480
                && (OverarchingViewmodel.getPlayerX() <= 900 || OverarchingViewmodel.getPlayerX() >= 1200)){
            return false;
        }
        return canMoveMap1() && true;
    }

    @Override
    public boolean canMoveMap3() {
        if (OverarchingViewmodel.getPlayerX() >= 980) {
            if (OverarchingViewmodel.getPlayerY() >= 250
                    && OverarchingViewmodel.getPlayerY() <= 350) {
                return false;
            }
        }
        return canMoveMap1();
//        if (OverarchingViewmodel.getPlayerY() >= 580) {
//            if (OverarchingViewmodel.getPlayerX() >= 1050
//                    && OverarchingViewmodel.getPlayerX() <= 1090) {
//                return true;
//            }
//            return false;
//        }
//        if (OverarchingViewmodel.getPlayerX() >= 980) {
//            if (OverarchingViewmodel.getPlayerY() >= 190
//                    && OverarchingViewmodel.getPlayerY() <= 290) {
//                return false;
//            }
//        }
//        return true;
    }
}
