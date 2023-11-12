package com.example.dungeoncrawler.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Score {
    private static Score score;
    private static MutableLiveData<Integer> count = new MutableLiveData<>();

    private Score() {
        this.count.postValue(300);
    }

    public static Score getScore() {
        if (score == null) {
            score = new Score();
        }
        return score;
    }

    public int getCount() {
        return count.getValue();
    }

    public void setCount(int count) {
        this.count.setValue(count);
    }

    public int decrement(int decrement) {
        count.setValue(count.getValue() - decrement);
        return count.getValue();
    }

    public void resetCount() {
        setCount(100);
    }

    public LiveData<Integer> getMutableLiveData() {
        return count;
    }
}
