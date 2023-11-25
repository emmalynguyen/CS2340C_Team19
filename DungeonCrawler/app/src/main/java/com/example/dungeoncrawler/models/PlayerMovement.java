package com.example.dungeoncrawler.models;


public interface PlayerMovement {
    void move(int step, int level);
    boolean canMove(int level);
    boolean canMoveMap1();
    boolean canMoveMap2();
    boolean canMoveMap3();
}
