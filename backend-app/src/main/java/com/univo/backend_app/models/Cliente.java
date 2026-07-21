package com.univo.backend_app.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity // Le dice a Spring que esto será una tabla en PostgreSQL
@Table(name = "clientes")
public class Cliente {

    // ==========================
    // ATRIBUTOS (Características)
    // ==========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private String email;
    private String ciudad;
    private LocalDateTime fechaCreacion;

    // ==========================
    // CONSTRUCTORES
    // ==========================

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(String nombreCompleto, String email, String ciudad, LocalDateTime fechaCreacion) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.ciudad = ciudad;
        this.fechaCreacion = fechaCreacion;
    }

    // ==========================
    // GETTERS (Obtener información)
    // ==========================

    public Long getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    // ==========================
    // SETTERS (Modificar información)
    // ==========================

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}