package com.example.ejerciciospracticalunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ejercicio2 extends AppCompatActivity {


    public EditText txtIngreso;
    public TextView lblres;
    public Button btnverifica, btnregresa, btnsigue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        //Capturamos los id de los elementos
        txtIngreso = findViewById(R.id.editTextText3);
        lblres = findViewById(R.id.txtEdad);
        btnverifica = findViewById(R.id.btnVerificar);
        btnregresa = findViewById(R.id.btnRegre);
        btnsigue = findViewById(R.id.btnSigue);

        //Evento del boton
        btnverifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Definimos las variables a emplear
                int edad = Integer.parseInt(txtIngreso.getText().toString());

                //Verificamos la edad
                if(edad > 0 && edad < 120){
                    lblres.setText("Edad validad");
                }
                else {
                    lblres.setText("¡ERROR! Edad no validad");
                }
            }
        });

        //Parte donde se encuentra el evento para regresar o avanzar de actividad
        btnregresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Indicamos a la actividad a la que queremos pasar
                Intent intent = new Intent( ejercicio2.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnsigue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ejercicio2.this,ejercicio3.class);
                startActivity(intent);
            }
        });

    }
}