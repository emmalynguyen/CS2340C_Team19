package com.example.dungeoncrawler.models;


import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.Subject;

import java.util.ArrayList;

public class Player implements Subject {

    private static Player player;
    private int health;
    private String name;

    private int x;
    private int y;

    private String difficultyName;
    private int difficulty;

    private int sprite;
    private ArrayList<Observer> observers;

    private Player() {
        health = 100;
        name = null;
        sprite = 0;
        x = 0;
        y = 0;
        observers = new ArrayList<>();
        x = 0; // Initial X-coordinate
        y = 0; // Initial Y-coordinate
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

    public String getDifficultyName() {
        return difficultyName;
    }

    public void setDifficultyName(String difficultyName) {
        this.difficultyName = difficultyName;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveLeft(int step) {
        x -= step;
    }

    public void moveRight(int step) {
        x += step;
    }

    public void moveUp(int step) {
        y -= step;
    }

    public void moveDown(int step) {
        y += step;
    }

    public int getSprite() {
        return sprite;
    }

    public void setSprite(int sprite) {
        this.sprite = sprite;
    }


    public void setX(int x) {
        this.x = x;
//        notifyObservers();
    }

    public void setY(int y) {
        this.y = y;
//        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        notifyObservers();
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
