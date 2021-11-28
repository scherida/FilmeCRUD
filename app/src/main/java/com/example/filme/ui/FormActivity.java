package com.example.filme.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.filme.R;
import com.example.filme.database.FilmesDB;
import com.example.filme.database.dao.FilmeDAO;
import com.example.filme.entity.Filme;

public class FormActivity extends AppCompatActivity {

    EditText etTitulo;
    EditText etGenero;
    EditText etAno;
    Button bSalvar;

    FilmeDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etTitulo = findViewById(R.id.etTitulo);
        etGenero = findViewById(R.id.etGenero);
        etAno    = findViewById(R.id.etAno);
        bSalvar  = findViewById(R.id.bSalvar);

        dao = FilmesDB.getInstance(this).getFilmeDAO();

        Intent intent = getIntent();

        Filme edtFilme;

        if (intent.hasExtra("filme")){

            edtFilme = (Filme) intent.getSerializableExtra("filme");

            etTitulo.setText(edtFilme.getTitulo());
            etAno.setText(edtFilme.getAno() + "");
            etGenero.setText(edtFilme.getGenero());

        } else {
            edtFilme = null;
        }



        bSalvar.setOnClickListener(v->{

            if (etTitulo.getText().toString().isEmpty() ||
            etGenero.getText().toString().isEmpty() ||
            etAno.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {

                Filme j = new Filme(
                        0,
                        etTitulo.getText().toString(),
                        Integer.parseInt(etAno.getText().toString()),
                        etGenero.getText().toString()
                );

                if (edtFilme == null)
                {
                    dao.salvarFilme(j);
                }
                else
                {
                    j.setId(edtFilme.getId());
                    dao.editarFilme(j);
                }

                Toast.makeText(this, "Filme salvo!", Toast.LENGTH_SHORT).show();

                finish();
            }

        });

    }
}