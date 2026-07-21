package com.univo.backend_app.controllers;

import com.univo.backend_app.models.Inventario;
import com.univo.backend_app.repositories.InventarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioRepository inventarioRepository;

    @GetMapping
    public List<Inventario> obtenerInventario() {
        return inventarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Inventario> obtenerInventario(@PathVariable Long id) {
        return inventarioRepository.findById(id);
    }

    @PostMapping
    public Inventario crearInventario(@RequestBody Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @PutMapping("/{id}")
    public Inventario actualizarInventario(@PathVariable Long id,
                                           @RequestBody Inventario inventarioActualizado) {

        Inventario inventario = inventarioRepository.findById(id).orElseThrow();

        inventario.setProducto(inventarioActualizado.getProducto());
        inventario.setUnidadesDisponibles(inventarioActualizado.getUnidadesDisponibles());
        inventario.setNivelReorden(inventarioActualizado.getNivelReorden());
        inventario.setUltimaActualizacion(inventarioActualizado.getUltimaActualizacion());

        return inventarioRepository.save(inventario);
    }

    @DeleteMapping("/{id}")
    public void eliminarInventario(@PathVariable Long id) {
        inventarioRepository.deleteById(id);
    }
}