package com.example.app_compras;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {

    //Atributos
    public ArrayList<Producto> dataProductos;
    public Context context;

    //Definmos un atributo
    private MainActivity clasePrincipal;

    //Constructor
    public ProductoAdapter(ArrayList<Producto> dataProductos, Context context) {
        this.dataProductos = dataProductos;
        this.context = context;
    }

    public ProductoAdapter(ArrayList<Producto> dataProductos, Context context, MainActivity clasePrincipal) {
        this.dataProductos = dataProductos;
        this.context = context;
        this.clasePrincipal = clasePrincipal;
    }

    @Override
    public int getCount() {
        return this.dataProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.dataProductos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list,null);
        Producto productoItem = dataProductos.get(position);
        //Asociamos los elementos
        TextView lbNombreProducto = convertView.findViewById(R.id.lblNombre);
        TextView lbPrecio = convertView.findViewById(R.id.lblPrecio);
        TextView lbCantidad = convertView.findViewById(R.id.lblCantidad);
        TextView lbTotal = convertView.findViewById(R.id.lblTotal);
        ImageView imgProducto = convertView.findViewById(R.id.imageView);
        ImageButton btnEliminar = convertView.findViewById(R.id.imageButton);
        ImageButton btnMenos = convertView.findViewById(R.id.btnMenos);
        ImageButton btnMas = convertView.findViewById(R.id.btnMas);
        //Asiganamos los valores
        lbNombreProducto.setText(productoItem.getNombreProducto());
        lbPrecio.setText(String.valueOf(productoItem.getPrecio()));
        lbCantidad.setText(String.valueOf(productoItem.getCantidad()));
        lbTotal.setText((String.valueOf(productoItem.getTotal())));
        //Definimos el color y la imagen a mostrar
        imgProducto.setImageResource(productoItem.getCategoria().getImagen());
        imgProducto.setColorFilter(context.getResources().getColor(productoItem.getCategoria().getColor()));

        //Evento del button
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*dataProductos.remove(position);
                notifyDataSetChanged();
                //Toast.makeText(context, "Producto Eliminado", Toast.LENGTH_SHORT).show();
                //Referencia a la clase principal
                clasePrincipal.calcularTotalCompra();*/

                //Objeto de tipo ALertDialog
                AlertDialog dialogo = alertaEliminar(position);
                dialogo.show();
            }
        });

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto productoItem = dataProductos.get(position);
                int cantidad = productoItem.getCantidad() + 1;
                productoItem.setCantidad(cantidad);
                double nuevoTotal = productoItem.getPrecio() * cantidad;
                productoItem.setTotal(nuevoTotal);
                notifyDataSetChanged();
                clasePrincipal.calcularTotalCompra();
            }
        });

        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto productoItem = dataProductos.get(position);
                int cantidad = productoItem.getCantidad() - 1;
                productoItem.setCantidad(cantidad);
                double nuevoTotal = productoItem.getPrecio() * cantidad;
                productoItem.setTotal(nuevoTotal);
                //Validamos que si se llega a cero se elimine el item
                if (cantidad == 0){
                    dataProductos.remove(position);
                }
                notifyDataSetChanged();
                clasePrincipal.calcularTotalCompra();
            }
        });
        return convertView;
    }

    public AlertDialog alertaEliminar(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Eliminar") .setMessage("Seguro que desea eliminar el registro")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataProductos.remove(position);
                        notifyDataSetChanged();
                        clasePrincipal.calcularTotalCompra();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Registro no eliminado", Toast.LENGTH_SHORT).show();
                    }
                });

        //Me crea un objeton de tipo alert dialog
        return  builder.create();
    }
}
