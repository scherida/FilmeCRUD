package com.example.filme.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.example.filme.R;
import com.example.filme.adapter.FilmeAdapter;
import com.example.filme.ui.FormActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvFilmes;
    FloatingActionButton fabAdd;
    FilmeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFilmes = findViewById(R.id.rvFilmes);
        fabAdd  = findViewById(R.id.fabAdd);

        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new FilmeAdapter(this);

        rvFilmes.setLayoutManager(layout);
        rvFilmes.setAdapter(adapter);

        fabAdd.setOnClickListener(v->{ startActivity(new Intent(this, FormActivity.class));} );

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateDataSet();
    }
}