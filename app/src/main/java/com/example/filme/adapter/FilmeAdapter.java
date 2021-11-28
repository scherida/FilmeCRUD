package com.example.filme.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filme.database.FilmesDB;
import com.example.filme.database.dao.FilmeDAO;
import com.example.filme.entity.Filme;
import com.example.filme.ui.FormActivity;
import com.example.filme.R;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter {

    Context context;
    List<Filme> listaFilmes;
    FilmeDAO dao;

    public FilmeAdapter(Context context) {
        this.context = context;
        dao = FilmesDB.getInstance(context).getFilmeDAO();
        listaFilmes = dao.buscarTodos();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.filme_layout, parent, false);

        FilmeViewHolder jvh = new FilmeViewHolder(itemView);

        return jvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Filme j = listaFilmes.get(position);

        FilmeViewHolder jvh = (FilmeViewHolder) holder;

        jvh.tvTitulo.setText(j.getTitulo());
        jvh.tvGenero.setText("Gênero: " + j.getGenero());
        jvh.tvAno.setText("(Lançamento: " + j.getAno() + ")");

        jvh.ibExcluir.setOnClickListener(v->{

            new AlertDialog.Builder(context)
                    .setTitle("Excluir")
                    .setMessage("Tem certeza que deseja excluir este filme?")
                    .setNegativeButton("Cancelar", null)
                    .setPositiveButton("Sim, exclua!", (dialogInterface, i) -> {
                        dao.excluirFilme(j);
                        Toast.makeText(context, "Filme excluído!", Toast.LENGTH_SHORT).show();
                        updateDataSet();
                    })
                    .show();


        });

        jvh.ibEditar.setOnClickListener(v->{

            Intent editarIntent = new Intent(context, FormActivity.class);
            editarIntent.putExtra("filme", j);
            context.startActivity(editarIntent);

        });

    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public void updateDataSet(){
        listaFilmes.clear();
        listaFilmes = dao.buscarTodos();
        notifyDataSetChanged();
    }
}
