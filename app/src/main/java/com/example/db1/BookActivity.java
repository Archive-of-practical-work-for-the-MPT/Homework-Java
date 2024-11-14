package com.example.db1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity {


    private TextView name, author;
    private Button delete, edit;
    private DataBaseHelper db;
    Context context;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_activity);
        context = this;
        name = findViewById(R.id.editTextName);
        author = findViewById(R.id.editTextAuthor);
        delete = findViewById(R.id.del);
        edit = findViewById(R.id.edit);
        db = new DataBaseHelper(this);

        int id = getIntent().getIntExtra("id", 0);
        String BookName = getIntent().getStringExtra("name");
        String BookAuthor = getIntent().getStringExtra("author");

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long result = db.deleteBook(id);

                if (result > 0) {
                    Toast.makeText(context,"Книгу сожгли 451F",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BookActivity.this,MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(context,"АНЛАК",Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(context, RecyclerViewAdapter.class);
                context.startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty() || author.getText().toString().isEmpty()) {
                    Toast.makeText(context, "А кто поля будет заполнять?", Toast.LENGTH_SHORT).show();
                    return;
                }

                long result = db.editBook(id, author.getText().toString(), name.getText().toString()); // TODO: так не должно быть!

                if (result > 0) {
                    Toast.makeText(context,"ФБР внес правки",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BookActivity.this,MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(context,"АНЛАК",Toast.LENGTH_SHORT).show();
                }
            }
        });

        name.setText(BookName);
        author.setText(BookAuthor);
    }
}
