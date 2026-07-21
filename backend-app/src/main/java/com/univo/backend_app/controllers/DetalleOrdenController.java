package com.univo.backend_app.controllers;

import com.univo.backend_app.models.DetalleOrden;
import com.univo.backend_app.repositories.DetalleOrdenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle-orden")
public class DetalleOrdenController {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @GetMapping
    public List<DetalleOrden> obtenerDetalles() {
        return detalleOrdenRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DetalleOrden> obtenerDetalle(@PathVariable Long id) {
        return detalleOrdenRepository.findById(id);
    }

    @PostMapping
    public DetalleOrden crearDetalle(@RequestBody DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    @PutMapping("/{id}")
    public DetalleOrden actualizarDetalle(@PathVariable Long id,
                                          @RequestBody DetalleOrden detalleActualizado) {

        DetalleOrden detalle = detalleOrdenRepository.findById(id).orElseThrow();

        detalle.setOrden(detalleActualizado.getOrden());
        detalle.setProducto(detalleActualizado.getProducto());
        detalle.setCantidad(detalleActualizado.getCantidad());
        detalle.setPrecioUnitario(detalleActualizado.getPrecioUnitario());

        return detalleOrdenRepository.save(detalle);
    }

    @DeleteMapping("/{id}")
    public void eliminarDetalle(@PathVariable Long id) {
        detalleOrdenRepository.deleteById(id);
    }
}