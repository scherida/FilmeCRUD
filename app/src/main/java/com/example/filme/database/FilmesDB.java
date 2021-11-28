package com.example.filme.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.filme.database.dao.FilmeDAO;
import com.example.filme.entity.Filme;

@Database(entities = {Filme.class}, version = 1, exportSchema = false)
public abstract class FilmesDB extends RoomDatabase {

    private static FilmesDB instance;

    public static FilmesDB getInstance(Context context)
    {
        if (instance == null)
        {
            instance =  Room.databaseBuilder(context, FilmesDB.class, "filmes_db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract FilmeDAO getFilmeDAO();

}
