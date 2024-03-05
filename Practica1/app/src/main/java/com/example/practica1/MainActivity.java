package com.example.practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText txtMensaje;
    public TextView lbMensaje;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMensaje = findViewById(R.id.editTextText);
        lbMensaje = findViewById(R.id.lbMensajeView);
    }

    //Evento para capturar info
    public void eventoBoton(View v){
        lbMensaje.setText(txtMensaje.getText());
    }
}