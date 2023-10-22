package com.example.dungeoncrawler.viewmodels;

import android.widget.ImageView;

import com.example.dungeoncrawler.models.Player;

public class MoveLeft implements Movement {
    @Override
    public void move() {
        Player player = Player.getPlayer();
        player.setX(player.getX() - 10);
    }
}
