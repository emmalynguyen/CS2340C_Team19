package com.example.dungeoncrawler.models;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.Subject;

import java.util.ArrayList;

public class AirEnemy implements Enemy, Subject {
    private int x;
    private int y;
    private int sprite;
    private int speed;
    private ArrayList<Observer> observers;

    public AirEnemy() {
        sprite = R.drawable.monster_elemental_air;
        x = 0;
        y = 0;
        speed = 20;
        observers = new ArrayList<>();
    }

    public void move(){
        x += speed;
        if(x <= 835 && speed < 0) {
            speed *= -1;
        }
        if(x >= 1300 && speed > 0) {
            speed *= -1;
        }
//        notifyObservers();
    }

    public boolean checkCollision(int x, int y){
        if((this.y > y - 10 && this.y < y + 160)
              && (this.x > x - 20 && this.x < x + 150)) {
            return true;
        }
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
