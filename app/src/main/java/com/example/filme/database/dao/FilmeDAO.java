package com.example.filme.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.filme.entity.Filme;

import java.util.List;

@Dao
public interface FilmeDAO {

    @Insert
    void salvarFilme(Filme filme);

    @Update
    void editarFilme(Filme filme);

    @Delete
    void excluirFilme(Filme filme);

    @Query("SELECT * FROM filmes_tb")
    List<Filme> buscarTodos();

}
