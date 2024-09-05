package com.example.animation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button openBtn;
    private Button open2Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openBtn = findViewById(R.id.open_new_layout);
        open2Btn = findViewById(R.id.open_new_layout2);

        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_animation);
        openBtn.startAnimation(slideAnimation);
        open2Btn.startAnimation(slideAnimation);

        openBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.sunny, R.anim.alpha);
            }

        });

        open2Btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.crash, R.anim.alpha);
            }

        });

    }
}