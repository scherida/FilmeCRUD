package com.example.filme.adapter;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filme.R;

public class FilmeViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitulo;
    TextView tvGenero;
    TextView tvAno;
    ImageButton ibEditar;
    ImageButton ibExcluir;

    public FilmeViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitulo  = itemView.findViewById(R.id.tvTitulo);
        tvAno     = itemView.findViewById(R.id.tvAno);
        tvGenero  = itemView.findViewById(R.id.tvGenero);
        ibEditar  = itemView.findViewById(R.id.ibEditar);
        ibExcluir = itemView.findViewById(R.id.ibExcluir);

    }
}
