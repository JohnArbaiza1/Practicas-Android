package com.example.practicafragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Atributos de la clase
    public Button btnInicio1,btnInicio2;

    Fragment Inicio, Inicio2;
    FragmentTransaction fragmentTransaction;
    public FragmentContainerView contenedor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //capturamos el id
        btnInicio1 = findViewById(R.id.button);
        btnInicio2 = findViewById(R.id.button2);
        contenedor = findViewById(R.id.fragmentContainerView);
        //objetos de fragmento
        Inicio = new inicioFragment();
        Inicio2 = new inicio2Fragment();

        //Eventos del button
        btnInicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,Inicio).commit();
            }
        });

        btnInicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,Inicio2).commit();
            }
        });

    }
}