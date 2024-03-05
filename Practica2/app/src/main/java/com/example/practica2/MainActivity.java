package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Definiendo los atributos
    public CheckBox ch1, ch2;
    public Button btn;
    //Atributos para el radioButton
    public RadioButton rb1, rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Parte donde se encuentran los eventos de cambio de estado
         ch1 = findViewById(R.id.checkBox);
         ch2 = findViewById(R.id.checkBox2);

         //asociamos el boton
         btn = findViewById(R.id.button);

         //Asociamos los radioButtons
         rb1 = findViewById(R.id.radioButton);
         rb2 = findViewById(R.id.radioButton2);

         //Evento para el checkBox
         ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean estadoCheckbox) {
                 if(estadoCheckbox){
                     Toast.makeText(MainActivity.this, "Checkbox 1 seleccionado", Toast.LENGTH_SHORT).show();
                 }
                 else{
                     Toast.makeText(MainActivity.this, "Checkbox 1 deseleccionado", Toast.LENGTH_SHORT).show();
                 }

             }
         });

         //Evento del bobton haciendo uso de listener
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //Verificamos el checkbox 2
                 if(ch2.isChecked()){
                     Toast.makeText(MainActivity.this, "Checkbox 2 seleccionado", Toast.LENGTH_SHORT).show();
                 } else{
                     Toast.makeText(MainActivity.this, "Checkbox 2 sin selccionar", Toast.LENGTH_SHORT).show();
                 }
                 if(rb2.isChecked()){
                     Toast.makeText(MainActivity.this, "RadioBUtton2 seleccionado", Toast.LENGTH_SHORT).show();
                 }
             }
         });

         //Evento para el radioButton
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "RadioButton1 Seleccionado", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "RadioButton1 sin seleccionar", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}