package com.example.ejerciciospracticalunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ejercicio3 extends AppCompatActivity {

    //Definimos los atributos a emplear
    public TextView lblrespuesta, lblContador;
    public EditText txtIngreso;
    public Button btnJugar,btnRegresar,btnSeguir;
    //contador de los intentos
    public int intentos = 0;

    //Defibimos las variables a emplear
    int numero = (int)(Math.random()*10+1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        //Capturamos el id de los elementos
        lblrespuesta = findViewById(R.id.textRespuestas);
        lblContador = findViewById(R.id.textContador);
        txtIngreso = findViewById(R.id.txtAdivinaNum);
        btnJugar = findViewById(R.id.btnJugar);
        btnRegresar = findViewById(R.id.btnregreEjer3);
        btnSeguir = findViewById(R.id.btnSigueEjerr3);

        //Evento
        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num = Integer.parseInt(txtIngreso.getText().toString());

                //Verificamos si el jugador acerto
                if (num > numero) {
                    lblrespuesta.setText("La suposición fue demasiado alta");
                    intentos++;
                    lblContador.setText(String.valueOf(intentos));
                } else if (num < numero) {
                    lblrespuesta.setText("La suposición fue demasiado baja");
                    intentos++;
                    lblContador.setText(String.valueOf(intentos));
                } else {
                    lblrespuesta.setText("¡Lo has logrado! ¡GANASTE!");
                    intentos++;
                    lblContador.setText(String.valueOf(intentos));
                }
            }
        });

        //Parte donde se encuentra el evento para regresar o avanzar de actividad
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Indicamos a la actividad a la que queremos pasar
                Intent intent = new Intent( ejercicio3.this,ejercicio2.class);
                startActivity(intent);
            }
        });

        btnSeguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ejercicio3.this,Ejercicio4.class);
                startActivity(intent);
            }
        });

    }
}