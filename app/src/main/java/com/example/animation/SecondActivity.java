package com.example.animation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private ImageView animationTV;
    private Button startBtn;
    private Button pauseBtn;
    private Button openBtn;
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        animationTV = findViewById(R.id.animImageView);
        startBtn = findViewById(R.id.startButton);
        pauseBtn = findViewById(R.id.pauseButton);
        openBtn = findViewById(R.id.open_menu);

        Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_animation);
        startBtn.startAnimation(zoomAnimation);
        pauseBtn.startAnimation(zoomAnimation);
        openBtn.startAnimation(zoomAnimation);

        frameAnimation = (AnimationDrawable) animationTV.getDrawable();

        startBtn.setOnClickListener(v -> {
            if (!frameAnimation.isRunning()) {
                frameAnimation.start();
            }
        });

        pauseBtn.setOnClickListener(v -> {
            if (frameAnimation.isRunning()) {
                frameAnimation.stop();
            }
        });

        openBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);

            }

        });

    }
}