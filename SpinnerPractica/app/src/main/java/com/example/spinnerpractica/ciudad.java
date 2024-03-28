package com.example.spinnerpractica;

public class ciudad {

    //AGregamos dos atributos
    public  String nombre;
    public String codigoPOstal;

    public ciudad(String nombre, String codigoPOstal) {
        this.nombre = nombre;
        this.codigoPOstal = codigoPOstal;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
