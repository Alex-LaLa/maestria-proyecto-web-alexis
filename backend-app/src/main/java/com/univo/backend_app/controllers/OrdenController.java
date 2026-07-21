package com.univo.backend_app.controllers;

import com.univo.backend_app.models.Orden;
import com.univo.backend_app.repositories.OrdenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    @Autowired
    private OrdenRepository ordenRepository;

    @GetMapping
    public List<Orden> obtenerOrdenes() {
        return ordenRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Orden> obtenerOrden(@PathVariable Long id) {
        return ordenRepository.findById(id);
    }

    @PostMapping
    public Orden crearOrden(@RequestBody Orden orden) {
        return ordenRepository.save(orden);
    }

    @PutMapping("/{id}")
    public Orden actualizarOrden(@PathVariable Long id,
                                 @RequestBody Orden ordenActualizada) {

        Orden orden = ordenRepository.findById(id).orElseThrow();

        orden.setCliente(ordenActualizada.getCliente());
        orden.setEstado(ordenActualizada.getEstado());
        orden.setMotivoCancelacion(ordenActualizada.getMotivoCancelacion());
        orden.setFechaOrden(ordenActualizada.getFechaOrden());
        orden.setTotal(ordenActualizada.getTotal());

        return ordenRepository.save(orden);
    }

    @DeleteMapping("/{id}")
    public void eliminarOrden(@PathVariable Long id) {
        ordenRepository.deleteById(id);
    }
}