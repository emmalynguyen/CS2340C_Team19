package com.example.dungeoncrawler.models;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.viewmodels.Observer;
import com.example.dungeoncrawler.viewmodels.OverarchingViewmodel;
import com.example.dungeoncrawler.viewmodels.Subject;

import java.util.ArrayList;

public class EarthEnemy implements Enemy, Subject {
    private int x;
    private int y;
    private int sprite;
    private int speed;
    private ArrayList<Observer> observers;
    private int direction;

    public EarthEnemy() {
        sprite = R.drawable.monster_elemental_plant;
        x = 0;
        y = 0;
        speed = 20;
        observers = new ArrayList<>();
        direction = 0;
    }


    public void move(){
        switch (direction) {
            case 0:
                x += speed;
                break;
            case 1:
                y += speed;
                break;
            case 2:
                x -= speed;
                break;
            case 3:
                y -= speed;
                direction = -1;
                break;
        }
        direction++;

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

    public int getSpeed() { return speed; }

    public void setSpeed(int speed) { this.speed = speed;}

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
