package com.univo.backend_app.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity // Le dice a Spring que esto será una tabla en PostgreSQL
@Table(name = "pagos")
public class Pago {

    // ==========================
    // ATRIBUTOS (Características)
    // ==========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    private String estadoPago;
    private String metodoPago;
    private Double monto;
    private LocalDateTime fechaPago;

    // ==========================
    // CONSTRUCTORES
    // ==========================

    // Constructor vacío
    public Pago() {
    }

    // Constructor con parámetros
    public Pago(Orden orden,
                String estadoPago,
                String metodoPago,
                Double monto,
                LocalDateTime fechaPago) {

        this.orden = orden;
        this.estadoPago = estadoPago;
        this.metodoPago = metodoPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    // ==========================
    // GETTERS (Obtener información)
    // ==========================

    public Long getId() {
        return id;
    }

    public Orden getOrden() {
        return orden;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public Double getMonto() {
        return monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    // ==========================
    // SETTERS (Modificar información)
    // ==========================

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }
}