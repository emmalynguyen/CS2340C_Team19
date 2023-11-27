
package com.example.dungeoncrawler.views;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.dungeoncrawler.R;


import com.example.dungeoncrawler.models.Player;
import com.example.dungeoncrawler.models.PowerUp;


    public class AndroidPowerUpVisualization implements com.example.dungeoncrawler.views.PowerUpVisualization {
        private Context context;
        private ViewGroup parentView;
        private PowerUp powerUp;
        private ImageView imageView;


        public AndroidPowerUpVisualization(Context context, ViewGroup parentView, PowerUp powerUp) {
            this.context = context;
            this.parentView = parentView;
            this.powerUp = powerUp;
            this.imageView = new ImageView(context);
            // Initialize imageView with the image for the power-up
            imageView.setImageResource(R.drawable.health_powerup); // Replace with the actual image resource
            // Set the scale type to FIT_START
            imageView.setScaleType(ImageView.ScaleType.FIT_START);


            // Set layout parameters to control the size
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                    150, // or specify a fixed size in pixels
                    150
            );
            imageView.setLayoutParams(params);


            imageView.setOnClickListener(view -> {
                powerUp.applyPowerUp(Player.getPlayer()); // Apply the power-up when clicked
                hide();
            });
        }


        @Override
        public void display(View.OnClickListener onClickListener) {
            // Implement the visual representation of the power-up
            // Add it to the parentView and set the click listener
            parentView.addView(imageView);
            imageView.setOnClickListener(onClickListener);
        }


        @Override
        public void hide() {
            // Remove the visual representation of the power-up from the parentView
            parentView.removeView(imageView);
        }
        @Override
        public ImageView getImageView() {
            return imageView;
        }


    }

