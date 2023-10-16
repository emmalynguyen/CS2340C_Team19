package com.example.dungeoncrawler.models;

public class Score {
    private static Score score;
    private int count;

    private Score() {
        this.count = 100;
    }

    public static Score getScore(){
        if(score == null) {
            score = new Score();
        }
        return score;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int decrement(int decrement) {
        count -= decrement;
        return count;
    }

    public void resetCount(){
        setCount(100);
    }
}
