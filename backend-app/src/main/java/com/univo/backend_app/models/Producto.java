package com.univo.backend_app.models;

public class Producto {
    // ==========================
    // ATRIBUTOS (Características)
    // ==========================
    private Long id;
    private String nombre;
    private double precio;
    private int stock;
    // ==========================
    // CONSTRUCTORES
    // ==========================

    // Constructor vacío
    public Producto() {
    }
    // Constructor con parámetros
    public Producto(Long id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    // ==========================
    // GETTERS (Obtener información)
    // ==========================

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }


    // ==========================
    // SETTERS (Modificar información)
    // ==========================

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}