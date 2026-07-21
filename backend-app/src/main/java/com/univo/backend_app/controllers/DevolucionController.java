package com.univo.backend_app.controllers;

import com.univo.backend_app.models.Devolucion;
import com.univo.backend_app.repositories.DevolucionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionRepository devolucionRepository;

    @GetMapping
    public List<Devolucion> obtenerDevoluciones() {
        return devolucionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Devolucion> obtenerDevolucion(@PathVariable Long id) {
        return devolucionRepository.findById(id);
    }

    @PostMapping
    public Devolucion crearDevolucion(@RequestBody Devolucion devolucion) {
        return devolucionRepository.save(devolucion);
    }

    @PutMapping("/{id}")
    public Devolucion actualizarDevolucion(@PathVariable Long id,
                                           @RequestBody Devolucion devolucionActualizada) {

        Devolucion devolucion = devolucionRepository.findById(id).orElseThrow();

        devolucion.setDetalleOrden(devolucionActualizada.getDetalleOrden());
        devolucion.setCantidadDevuelta(devolucionActualizada.getCantidadDevuelta());
        devolucion.setMontoReembolsado(devolucionActualizada.getMontoReembolsado());
        devolucion.setMotivo(devolucionActualizada.getMotivo());
        devolucion.setEstado(devolucionActualizada.getEstado());
        devolucion.setFechaCreacion(devolucionActualizada.getFechaCreacion());

        return devolucionRepository.save(devolucion);
    }

    @DeleteMapping("/{id}")
    public void eliminarDevolucion(@PathVariable Long id) {
        devolucionRepository.deleteById(id);
    }
}