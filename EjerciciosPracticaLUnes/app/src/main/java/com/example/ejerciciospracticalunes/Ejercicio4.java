package com.example.ejerciciospracticalunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Ejercicio4 extends AppCompatActivity {

    //Definimos los atributos
    public EditText txtMOneda;
    public RadioButton rbEuro, rbPesos;
    public TextView respuesta;
    public Button regresa;

    public double respuestaOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);

        //Capturamos los id
        txtMOneda = findViewById(R.id.editTextText4);
        rbEuro = findViewById(R.id.radioEuro);
        rbPesos = findViewById(R.id.radioPesos);
        respuesta = findViewById(R.id.txtCantidad);
        regresa = findViewById(R.id.btnre);

        //Eventos de los RadioBUtton
        rbEuro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean estadoRadio) {
                if(estadoRadio){
                    //Definimos una variable local
                    double totalDolar = Double.parseDouble(txtMOneda.getText().toString());
                    respuestaOperacion = totalDolar * 0.93;
                    respuesta.setText(String.valueOf(redondear(respuestaOperacion)));

                }
            }
        });

        rbPesos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean estadoRadio) {
                if(estadoRadio){
                    //Definimos una variable local
                    double totalDolar = Double.parseDouble(txtMOneda.getText().toString());
                    respuestaOperacion = totalDolar * 17.06;
                    respuesta.setText(String.valueOf(redondear(respuestaOperacion)));
                }
            }
        });

        //Evento del boton regresar
        regresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ejercicio4.this,ejercicio3.class);
                startActivity(intent);
            }
        });

    }

    //Definimos una nueva funcion
    public double redondear(double redondear){
        DecimalFormatSymbols formato = new DecimalFormatSymbols(Locale.US);
        DecimalFormat formateado = new DecimalFormat("#.##",formato);
        double returnNumero = Double.parseDouble(formateado.format(redondear));
        return  returnNumero;
    }
}

