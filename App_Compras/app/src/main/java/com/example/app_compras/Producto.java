package com.example.app_compras;

public class Producto {

    //Definimos los atributos que tendra la clase de producto
    private String nombreProducto;
    private int cantidad;
    private double precio;
    private double total;
    private Categoria categoria;

    //Constructor
    public Producto(String nombreProducto, int cantidad, double precio, double total, Categoria categoria) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.categoria = categoria;
    }

    //Constructor sin parametros
    public Producto() {
    }

    //Getter and Setter
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
