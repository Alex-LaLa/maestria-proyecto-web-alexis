package com.univo.backend_app.models;

import jakarta.persistence.*;

@Entity // Le dice a Spring que esto será una tabla en PostgreSQL
@Table(name = "detalle_orden")
public class DetalleOrden {

    // ==========================
    // ATRIBUTOS (Características)
    // ==========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    private Integer cantidad;
    private Double precioUnitario;

    // ==========================
    // CONSTRUCTORES
    // ==========================

    // Constructor vacío
    public DetalleOrden() {
    }

    // Constructor con parámetros
    public DetalleOrden(Orden orden,
                        Producto producto,
                        Integer cantidad,
                        Double precioUnitario) {

        this.orden = orden;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
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

    public Producto getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    // ==========================
    // SETTERS (Modificar información)
    // ==========================

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}