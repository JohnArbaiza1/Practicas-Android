package com.example.spinnerpractica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Definimos los atributos
    public Spinner spinner1, spinner2, spinner3;
    //Definimos un array list
    public ArrayList<ciudad> listCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Capturamos los id
        spinner1 = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        //Instanciamos
        listCiudades = new ArrayList<ciudad>();
        listCiudades.add(new ciudad("San Miguel","CP3301"));
        listCiudades.add(new ciudad("Usulutan","CP3302"));

        //Arreglo local
        String[] arregloItems = {"Indice 0", "Indice 1", "Indice 2"};
        String[] arregloItems2 = new String[3];

        //Adaptador
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.itemsSpinner, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        //layout
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        //Asignamos al sppiner
        spinner1.setAdapter(adapter);

        //------------------------------------------------------------
        //objeto
        ArrayAdapter adapter1 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arregloItems);
        adapter1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);

        //------------------------------------------------------------

        //Ejemplo rellenando con objetos de otra clase
        ArrayAdapter<ciudad> adapter2 =new ArrayAdapter<ciudad>(this,androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listCiudades);
        adapter2.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter2);

    }
}