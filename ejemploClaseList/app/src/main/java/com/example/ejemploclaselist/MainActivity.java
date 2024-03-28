package com.example.ejemploclaselist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Definimos los atributos
    public ListView listaView;
    public ArrayList<producto> listaProducto;
    //---------------------------------------------------
    public  AdaptadorLista adaptador;
    public Button btnAgregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaView = findViewById(R.id.lista);
        listaProducto = new ArrayList<producto>();
        rellenarListView();
        btnAgregar = findViewById(R.id.btnAgregar);

        listaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                producto objetoProducto = listaProducto.get(position);
                Toast.makeText(MainActivity.this , "Producto -> " + objetoProducto.getNombreProducto(),Toast.LENGTH_SHORT).show();
            }
        });

        //----------------------------------------------------------------------
        //Evento para agregar
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaProducto.add(new producto("Jugo",2.50));
                adaptador.notifyDataSetChanged();
            }
        });

    }

    public  void rellenarListView(){
        listaProducto.add(new producto("Agua", 1.00));
        listaProducto.add(new producto("Soda", 1.25));
        listaProducto.add(new producto("Jugo del valle", 0.75));

        //Creamos un objeto
         adaptador = new AdaptadorLista(MainActivity.this,listaProducto,R.layout.item_list);


        //asiganamos el adapatador al listaView
        listaView.setAdapter(adaptador);
    }
}