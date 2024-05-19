package com.example.apppracticarelaciones.models;


import androidx.room.Embedded;
import androidx.room.Relation;

public class libroAutor {
    @Embedded public Autor autor;
    @Embedded public Editorial editorial;
    @Relation(
            parentColumn = "idAutor",
            entityColumn = "idAutor"
    )

    public Libro libros;

    @Relation(
            parentColumn = "idAutor",
            entityColumn = "idEditorial"
    )
    public Libro libroEditorial;
}
