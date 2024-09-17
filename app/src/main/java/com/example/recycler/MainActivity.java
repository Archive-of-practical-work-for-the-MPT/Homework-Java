package com.example.recycler;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // нач инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // создаем адаптер
        RecyclerAddapter addapter = new RecyclerAddapter(this, states);
        // устанавливаем для списка адаптеров
        recyclerView.setAdapter(addapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    private void setInitialData() {
        states.add(new State("Бразилия", "Бразилия", R.drawable.brasil));
        states.add(new State("Российская Империя", "Санкт-Петербург", R.drawable.imperium));
        states.add(new State("Норвегия", "Осло", R.drawable.norge));

    }
}