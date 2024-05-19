package com.example.apppracticarelaciones.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Libro {

    @PrimaryKey(autoGenerate = true)
    public int idLibro;

    @ColumnInfo
    public String nombreLibro;

    @ColumnInfo
    public int idAutor;

    @ColumnInfo
    public int idEditorial;
}
