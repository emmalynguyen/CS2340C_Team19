package com.example.dungeoncrawler.models;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Player {

    private static Player player;
    private int health;
    private String name;

    private int sprite;

    private Player() {
        health = 100;
        name = null;
        sprite = 0;
    }

    public static Player getPlayer() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getDrawable() {
        return sprite;
    }

    public void setDrawable(int sprite) {
        this.sprite = sprite;
    }
}
