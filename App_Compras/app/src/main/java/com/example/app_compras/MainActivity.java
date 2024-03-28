package com.example.app_compras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Definimos los atributos
    public Spinner spCategoria;
    ArrayList<Categoria>listaCategoria;
    public EditText txtNombre, txtPrecio,TxtCantidad;
    public Button btnAdd;
    public double total;
    public ArrayList<Producto> listProducto;
    public ListView listaData;
    public ProductoAdapter adapter;
    public TextView lbTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asociando los atributos
        spCategoria = findViewById(R.id.spinner);
        txtNombre = findViewById(R.id.editTextText2);
        TxtCantidad = findViewById(R.id.editTextText4);
        txtPrecio = findViewById(R.id.editTextText3);
        btnAdd = findViewById(R.id.button);
        listaData = findViewById(R.id.listaCompras);
        lbTotal = findViewById(R.id.lblTotalCompra);
        //instanciamos el sppiner
        listaCategoria = new ArrayList<Categoria>();
        listProducto = new ArrayList<Producto>();
        adapter = new ProductoAdapter(listProducto, this,this);
        listaData.setAdapter(adapter);
        //Lamamos al metodo
        rellenarSpinner();


        //Evento del button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos un objeto temporal
                Producto objetoProducto = new Producto();
                objetoProducto.setNombreProducto(txtNombre.getText().toString());
                objetoProducto.setCantidad(Integer.parseInt(TxtCantidad.getText().toString()));
                objetoProducto.setPrecio(Double.parseDouble(txtPrecio.getText().toString()));
                total = Integer.parseInt(TxtCantidad.getText().toString()) * Double.parseDouble(txtPrecio.getText().toString());
                objetoProducto.setTotal(total);
                objetoProducto.setCategoria((Categoria) spCategoria.getSelectedItem());
                listProducto.add(objetoProducto);
                adapter.notifyDataSetChanged();
                //Lamamos al metodo calcular
                calcularTotalCompra();
            }
        });
    }

    //Definimos un metodo
    public  void rellenarSpinner(){
        listaCategoria.add(new Categoria("Juguetes",R.drawable.categoria1,R.color.categoriaJuguete));
        listaCategoria.add(new Categoria("Hospital",R.drawable.categoria2,R.color.categoriaHospital));
        ArrayAdapter<Categoria> adapter = new ArrayAdapter<Categoria>(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        ,listaCategoria);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spCategoria.setAdapter(adapter);

    }

    //Metodo para sacar el total
    public void calcularTotalCompra(){
        double sumatoria = 0;
        for(Producto itemProducto:listProducto){
            sumatoria += itemProducto.getTotal();
        }

        lbTotal.setText(String.valueOf(sumatoria));
    }
}