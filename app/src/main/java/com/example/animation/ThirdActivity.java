package com.example.animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private ImageView img;
    private Button startBtn;
    private Button pauseBtn;
    private Button openBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        img = findViewById(R.id.img_blink);
        startBtn = findViewById(R.id.start_tween);
        pauseBtn = findViewById(R.id.pause_tween);
        openBtn = findViewById(R.id.open_menu2);

        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);
        Animation fadingAnimation = AnimationUtils.loadAnimation(this, R.anim.fading_animation);
        startBtn.startAnimation(fadingAnimation);
        pauseBtn.startAnimation(fadingAnimation);
        openBtn.startAnimation(fadingAnimation);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.startAnimation(blinkAnimation);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.clearAnimation();
            }
        });

        openBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide, R.anim.alpha);

            }

        });

    }
}
