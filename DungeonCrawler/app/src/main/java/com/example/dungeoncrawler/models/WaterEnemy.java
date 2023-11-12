package com.example.dungeoncrawler.models;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.Subject;

import java.util.ArrayList;

public class WaterEnemy implements Enemy, Subject {
    private int x;
    private int y;
    private int sprite;
    private ArrayList<Observer> observers;
    private int speed;

    public WaterEnemy() {
        sprite = R.drawable.monster_elemental_water;
        x = 0;
        y = 0;
        speed = 20;
        observers = new ArrayList<>();
    }

    public void move(){
        y += speed;
        if(y <= 50 && speed < 0) {
            speed *= -1;
        }
        if(x >= 480 && speed > 0) {
            speed *= -1;
        }
//        notifyObservers();
    }

    public boolean checkCollision(int x, int y){
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSprite() {
        return sprite;
    }

    public void setSprite(int sprite) {
        this.sprite = sprite;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        notifyObservers();
    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
