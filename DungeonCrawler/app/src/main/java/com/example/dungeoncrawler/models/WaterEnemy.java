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
    private int direction;

    public WaterEnemy() {
        sprite = R.drawable.monster_elemental_water;
        x = 0;
        y = 0;
        speed = 35;
        observers = new ArrayList<>();
        direction = 0;
    }

    public void move(){
        switch (direction / 6) {
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
                break;
            case 4:
                direction = -1;
        }
        direction++;
    }

    public boolean checkCollision(int x, int y){
        if((this.y > y - 30 && this.y < y + 200)
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
