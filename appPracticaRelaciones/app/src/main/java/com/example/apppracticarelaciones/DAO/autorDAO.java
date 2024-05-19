package com.example.apppracticarelaciones.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.apppracticarelaciones.models.Autor;

import java.util.List;

@Dao
public interface autorDAO {

    @Query("SELECT * FROM Autor")
    List<Autor> getAutores();

    @Insert
    void insertAUtor(Autor autor);
}
