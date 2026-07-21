package com.univo.backend_app.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Le dice a Spring que esto será una tabla en PostgreSQL
@Table(name = "inventario")
public class Inventario {

    // ==========================
    // ATRIBUTOS (Características)
    // ==========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private Integer unidadesDisponibles;
    private Integer nivelReorden;
    private LocalDateTime ultimaActualizacion;

    // ==========================
    // CONSTRUCTORES
    // ==========================

    // Constructor vacío
    public Inventario() {
    }

    // Constructor con parámetros
    public Inventario(Producto producto,
                      Integer unidadesDisponibles,
                      Integer nivelReorden,
                      LocalDateTime ultimaActualizacion) {

        this.producto = producto;
        this.unidadesDisponibles = unidadesDisponibles;
        this.nivelReorden = nivelReorden;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    // ==========================
    // GETTERS (Obtener información)
    // ==========================

    public Long getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public Integer getNivelReorden() {
        return nivelReorden;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    // ==========================
    // SETTERS (Modificar información)
    // ==========================

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setUnidadesDisponibles(Integer unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public void setNivelReorden(Integer nivelReorden) {
        this.nivelReorden = nivelReorden;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }
}