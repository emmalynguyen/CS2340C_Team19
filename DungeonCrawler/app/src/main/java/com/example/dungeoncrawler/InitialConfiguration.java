package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InitialConfiguration extends AppCompatActivity {

    private double difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_configuration);
    }
}