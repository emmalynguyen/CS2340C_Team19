
package com.example.dungeoncrawler.views;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.example.dungeoncrawler.R;


import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.models.PowerUp;


public class AndroidPowerUpVisualization {
    private Context context;
    private ViewGroup parentView;
    private PowerUp powerUp;
    private ImageView imageView;

    public AndroidPowerUpVisualization(Context context, ViewGroup parentView, PowerUp powerUp, int imageResource, int width, int height) {
        this.context = context;
        this.parentView = parentView;
        this.powerUp = powerUp;
        this.imageView = new ImageView(context);

        // Initialize imageView with the image for the power-up
        imageView.setImageResource(imageResource);

        // Set the scale type to FIT_START
        imageView.setScaleType(ImageView.ScaleType.FIT_START);

        // Set layout parameters to control the size
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(width, height);
        imageView.setLayoutParams(params);

        imageView.setOnClickListener(view -> {
            powerUp.applyPowerUp(Player.getPlayer()); // Apply the power-up when clicked
            hide();
        });
    }


    public void display(View.OnClickListener onClickListener) {
        // Create a ConstraintSet to dynamically set constraints

        // Implement the visual representation of the power-up
        // Add it to the parentView and set the click listener
        parentView.addView(imageView);
        imageView.setOnClickListener(onClickListener);
    }


    public void hide() {
        // Remove the visual representation of the power-up from the parentView
        parentView.removeView(imageView);
    }


    public ImageView getImageView() {
        return imageView;
    }
}
