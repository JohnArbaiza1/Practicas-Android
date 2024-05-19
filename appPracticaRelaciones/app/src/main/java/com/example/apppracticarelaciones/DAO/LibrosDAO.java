package com.example.apppracticarelaciones.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.apppracticarelaciones.models.Libro;
import com.example.apppracticarelaciones.models.libroAutor;

import java.util.List;

@Dao
public interface LibrosDAO {

    @Query("SELECT * FROM Libro")
    List<Libro> getLibro();

    @Transaction
    @Query("SELECT Autor.*, Libro.*, Editorial.* FROM Autor"+
            " INNER JOIN Libro ON Autor.idAutor = Libro.idAutor"+
            " INNER JOIN Editorial ON Libro.idEditorial = Editorial.idEditorial")
    List<libroAutor> getLibroAutor();

    @Insert
    void insertLibro(Libro libro);
}
