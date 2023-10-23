package com.example.dungeoncrawler.viewmodels;

import android.widget.ImageView;

import com.example.dungeoncrawler.models.Player;

public class MoveRight implements Movement {
    @Override
    public void move(int step) {
        if(canMove()) {
            OverarchingViewmodel.setPlayerX(OverarchingViewmodel.getPlayerX() + step);
        }
    }

    public boolean canMove(){
        if(OverarchingViewmodel.getPlayerX() >= 1250 || OverarchingViewmodel.getPlayerY() >= 480) {
            return false;
        }
        if(OverarchingViewmodel.getPlayerY() <= 290 && OverarchingViewmodel.getPlayerY() >= 200){
            if(OverarchingViewmodel.getPlayerX() >= 970 && OverarchingViewmodel.getPlayerX() <= 1110) {
                return false;
            }
        }
        return true;
    }
}
