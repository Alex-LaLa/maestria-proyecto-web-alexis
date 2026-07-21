package com.univo.backend_app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    // ==========================
    // ATRIBUTOS
    // ==========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String categoria;
    private Double precio;
    private Boolean activo;

    // ==========================
    // CONSTRUCTORES
    // ==========================

    // Constructor vacío
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(String nombre, String categoria, Double precio, Boolean activo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.activo = activo;
    }

    // ==========================
    // GETTERS
    // ==========================

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public Boolean getActivo() {
        return activo;
    }

    // ==========================
    // SETTERS
    // ==========================

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}