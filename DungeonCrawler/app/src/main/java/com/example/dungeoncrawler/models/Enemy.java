package com.example.dungeoncrawler.models;

public interface Enemy {
    void move();
    boolean checkCollision(int x, int y);

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    int getSprite();

    void setSprite(int sprite);

    int getSpeed();

    void setSpeed(int speed);
    void kill();
}
