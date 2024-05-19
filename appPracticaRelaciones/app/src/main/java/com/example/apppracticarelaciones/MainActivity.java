package com.example.apppracticarelaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.apppracticarelaciones.DAO.LibrosDAO;
import com.example.apppracticarelaciones.DAO.autorDAO;
import com.example.apppracticarelaciones.models.Autor;
import com.example.apppracticarelaciones.models.Libro;
import com.example.apppracticarelaciones.models.libroAutor;

import java.util.List;

public class MainActivity extends AppCompatActivity {

            public appDataBAse db;
    public autorDAO autordao;
    public LibrosDAO librodao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(), appDataBAse.class,"dbLibros2").allowMainThreadQueries().build();


        autordao = db.getAutorDAO();
        librodao = db.getLibroDAO();
        /*Autor autor = new Autor();
        autor.nombreAuotor = "Edagar Allan Poe";
        autordao.insertAUtor(autor);
        List<Autor> listAutor = autordao.getAutores();
        for(Autor itemAutor: listAutor){
            Log.d("Autor ->", itemAutor.nombreAuotor);
        }*/

        Libro libro = new Libro();
        libro.nombreLibro = "Vuelta al mundo en 90 Dias";
        libro.idAutor = 1;
        librodao.insertLibro(libro);
        List<libroAutor> listLibro = librodao.getLibroAutor();
        for (libroAutor itemRespuesta: listLibro){
            Log.d("Libros ->", itemRespuesta.libros.nombreLibro + " "+ itemRespuesta.autor.nombreAuotor);
            //Log.d("Libros ->", itemRespuesta.autor.nombreAuotor);
        }


    }
}