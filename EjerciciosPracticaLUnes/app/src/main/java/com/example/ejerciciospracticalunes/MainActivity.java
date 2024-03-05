package com.example.ejerciciospracticalunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Definiendo los atributos a emplear

    //Atributos del radioButton y CheckBox
    public RadioButton rb1, rb2, rb3,rb4;
    public CheckBox ch1;
    //Atributos de los EditText
    public EditText n1, n2;
    //Atributos de los botones
    public Button btn1, btn2;
    //Atributos del textView
    public TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Seccion donde se encuentran los eventos

        //Asociando los radioButtons
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        //Asociando el checkBox
        ch1 = findViewById(R.id.checkBox);
        //Asociamos el boton
        btn1 = findViewById(R.id.button);
        //Asociamos para los textos
        n1 = findViewById(R.id.editTextText);
        n2 = findViewById(R.id.editTextText2);
        txtResultado = findViewById(R.id.textView3);

        //Solucion del problema del boton y a la hora de hacer los calculos
        //Definiendo el evento del boton
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Definiendo las variables
                float resultado = 0;
                float num1 = 0;
                float num2 = 0;

                if (rb1.isChecked()) {
                    num1 = Float.parseFloat(n1.getText().toString());
                    num2 = Float.parseFloat(n2.getText().toString());
                    resultado = num1 + num2;

                    if (ch1.isChecked()) {
                        Math.ceil(resultado);
                    }

                } else if (rb2.isChecked()) {
                    num1 = Float.parseFloat(n1.getText().toString());
                    num2 = Float.parseFloat(n2.getText().toString());
                    resultado = num1 - num2;

                    if (ch1.isChecked()) {
                        Math.ceil(resultado);
                    }

                } else if (rb3.isChecked()) {
                    num1 = Float.parseFloat(n1.getText().toString());
                    num2 = Float.parseFloat(n2.getText().toString());
                    resultado = num1 * num2;

                    if (ch1.isChecked()) {
                        Math.ceil(resultado);
                    }

                } else if (rb4.isChecked()) {
                    num1 = Float.parseFloat(n1.getText().toString());
                    num2 = Float.parseFloat(n2.getText().toString());
                    resultado = num1 / num2;

                    if (ch1.isChecked()) {
                        Math.ceil(resultado);
                    }
                }
                txtResultado.setText(String.valueOf(resultado));
            }
        });

        //Evento para el radioButton
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Suma Seleccionada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Resta Seleccionada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Multiplicacion Seleccionada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Division Seleccionada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Evento para poder cambiar de actividad

        //Capturamos el id
        btn2 = findViewById(R.id.btnSiguiente);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Indicamos a la actividad a la que queremos pasar
                Intent intent = new Intent(MainActivity.this, ejercicio2.class);
                startActivity(intent);
            }
        });


    }
}