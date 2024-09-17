package com.example.recycler;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class Description extends AppCompatActivity {
    private ImageView flag_view;
    private TextView text_view;
    private TextView desription_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_card);

        flag_view = findViewById(R.id.flag);
        text_view = findViewById(R.id.name);
        desription_view = findViewById(R.id.capital);

        int flag = getIntent().getIntExtra("flag", 0);
        String nameView = getIntent().getStringExtra("nameView");

        if (Objects.equals(nameView, "Бразилия")) {
            desription_view.setText("Страна с самой красивой живностью");
        } else if (Objects.equals(nameView, "Российская Империя")) {
            desription_view.setText("Страна с самой грустной историей");
        } else if (Objects.equals(nameView, "Норвегия")) {
            desription_view.setText("Страна с самой красивой природой");
        }

        flag_view.setImageResource(flag);
        text_view.setText(nameView);
    }
}