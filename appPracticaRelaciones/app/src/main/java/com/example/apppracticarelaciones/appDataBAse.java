package com.example.apppracticarelaciones;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.apppracticarelaciones.DAO.LibrosDAO;
import com.example.apppracticarelaciones.DAO.autorDAO;
import com.example.apppracticarelaciones.models.Autor;
import com.example.apppracticarelaciones.models.Editorial;
import com.example.apppracticarelaciones.models.Libro;

@Database(entities = {Autor.class, Libro.class, Editorial.class}, version = 2)
public abstract class appDataBAse  extends RoomDatabase {

    //Agregamos los DAO
    public abstract autorDAO  getAutorDAO();
    public abstract LibrosDAO getLibroDAO();
}
