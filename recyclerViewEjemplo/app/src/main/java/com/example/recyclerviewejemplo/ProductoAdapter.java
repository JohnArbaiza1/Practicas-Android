package com.example.recyclerviewejemplo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    //Definimos los atributos
    public ArrayList<Producto> dataProducto;
    public Context context;
    public Button btnDelete;
    //Constructor
    public ProductoAdapter(ArrayList<Producto> dataProducto, Context context) {
        this.dataProducto = dataProducto;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Definimnos la variable y asociamos el adapatador al diseño XML
        View vista = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position) {
        holder.bindProducto(dataProducto.get(position),this);

    }

    @Override
    public int getItemCount() {
        return dataProducto.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtPrecio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            btnDelete = itemView.findViewById(R.id.button);

        }

        //Nuevo metodo  para el adaptador
        public void bindProducto(Producto producto, ProductoAdapter adapter){
            txtName.setText(producto.getNombreProducto());
            txtPrecio.setText(String.valueOf(producto.getPrecio()));

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicion = getAdapterPosition();
                    adapter.dataProducto.remove(posicion);
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }
}
