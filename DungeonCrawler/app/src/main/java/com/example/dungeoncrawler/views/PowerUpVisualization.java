
package com.example.dungeoncrawler.views;


import android.view.View;
import android.widget.ImageView;


public interface PowerUpVisualization {
    void display(View.OnClickListener onClickListener);
    void hide();


    ImageView getImageView();
}
