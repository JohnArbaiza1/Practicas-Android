package com.example.app_compras;

public class Categoria {

    //Definimos los atributos
    private String nombreCategoria;
    private int imagen;
    private int color;

    //constructor
    public Categoria(String nombreCategoria, int imagen, int color) {
        this.nombreCategoria = nombreCategoria;
        this.imagen = imagen;
        this.color = color;
    }

    //Getter and Setter
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.getNombreCategoria();
    }
}
