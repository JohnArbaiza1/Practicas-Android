package com.example.ejemploclaselist;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

//Acá implementaremos la interfaz base adapter
public class AdaptadorLista extends BaseAdapter {

    //Definiendo los atributos a emplear
    public Context context;
    public ArrayList<producto> dataProducto;

    public int contenedor;

    //Constructor de la clase
    public AdaptadorLista(Context context, ArrayList<producto> dataProducto, int contenedor) {
        this.context = context;
        this.dataProducto = dataProducto;
        this.contenedor = contenedor;
    }

    //Para retornar el tamaño del array
    @Override
    public int getCount() {
        return dataProducto.size();
    }

    @Override
    public Object getItem(int i) {
        return dataProducto.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        //asignamos la nueva vista al adaptador
        vista = layoutInflater.inflate(R.layout.item_list,null);
        //asociamos los elementos
        producto productoItem = dataProducto.get(i);
        //Mostramos los datos de los objetos del arrayList en cada item
        TextView txt1 = vista.findViewById(R.id.textView);
        TextView txt2 = vista.findViewById(R.id.textView2);
        //----------------------------------------------------------------------
        //Para eliminar un elemento en la lista
        Button btnDelete = vista.findViewById(R.id.btnEliminar);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataProducto.remove(i); //Se puede eliminar con el objeto o con el indice
                //Metodo para actualizar la vista cuando se elimine un elemento
                notifyDataSetChanged();

            }
        });
        //-----------------------------------------------------------------------
        txt1.setText(productoItem.getNombreProducto());
        txt2.setText(String.valueOf(productoItem.getPrecio()));
        //retornamos la vista
        return vista;
    }



}
