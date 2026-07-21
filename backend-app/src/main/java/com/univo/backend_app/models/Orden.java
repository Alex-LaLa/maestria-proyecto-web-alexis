package com.univo.backend_app.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Le dice a Spring que esto será una tabla en PostgreSQL
@Table(name = "ordenes")
public class Orden {

    // ==========================
    // ATRIBUTOS (Características)
    // ==========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private String estado;
    private String motivoCancelacion;
    private LocalDateTime fechaOrden;
    private Double total;

    // ==========================
    // CONSTRUCTORES
    // ==========================

    // Constructor vacío
    public Orden() {
    }

    // Constructor con parámetros
    public Orden(Cliente cliente,
                 String estado,
                 String motivoCancelacion,
                 LocalDateTime fechaOrden,
                 Double total) {

        this.cliente = cliente;
        this.estado = estado;
        this.motivoCancelacion = motivoCancelacion;
        this.fechaOrden = fechaOrden;
        this.total = total;
    }

    // ==========================
    // GETTERS (Obtener información)
    // ==========================

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getEstado() {
        return estado;
    }

    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }

    public LocalDateTime getFechaOrden() {
        return fechaOrden;
    }

    public Double getTotal() {
        return total;
    }

    // ==========================
    // SETTERS (Modificar información)
    // ==========================

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMotivoCancelacion(String motivoCancelacion) {
        this.motivoCancelacion = motivoCancelacion;
    }

    public void setFechaOrden(LocalDateTime fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}