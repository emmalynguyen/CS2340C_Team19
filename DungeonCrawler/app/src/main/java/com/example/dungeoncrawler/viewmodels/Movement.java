package com.example.dungeoncrawler.viewmodels;

import android.media.Image;
import android.widget.ImageView;

public interface Movement {
    void move(int step);
    boolean canMove();
}
