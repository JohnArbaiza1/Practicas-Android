package com.example.recyclerviewejemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Atributos
    public RecyclerView listaProducto;
    public ArrayList<Producto> dataProducto;
    public ProductoAdapter productoAdapter;
    public Button btnInsertar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciamos
        listaProducto = findViewById(R.id.listRecycler);
        dataProducto = new ArrayList<Producto>();
        dataProducto.add(new Producto("Jugo de lata",0.75));
        dataProducto.add(new Producto("Soda de lata",0.75));
        dataProducto.add(new Producto("Agua",0.50));
        //Instanciamos el adaptador
        productoAdapter = new ProductoAdapter(dataProducto,this);
        //listaProducto.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        //listaProducto.setLayoutManager(new GridLayoutManager(this,2));
        listaProducto.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        listaProducto.setAdapter(productoAdapter);
        //--------------------------------------------------------------------------------------
        btnInsertar = findViewById(R.id.btnInsertar);
        //Evento del button
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataProducto.add(new Producto("Churros",0.20));
                productoAdapter.notifyDataSetChanged();
            }
        });
    }


}