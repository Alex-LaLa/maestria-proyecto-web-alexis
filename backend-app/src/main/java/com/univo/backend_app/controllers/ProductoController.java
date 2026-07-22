package com.univo.backend_app.controllers;

import com.univo.backend_app.models.Producto;
import com.univo.backend_app.repositories.ProductoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    // ==========================
    // GET - Obtener todos los productos
    // ==========================
    // Ej. GET /productos

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    // ==========================
    // GET - Obtener un producto por ID
    // ==========================
    //Ej. GET /productos/1

    @GetMapping("/{id}")
    public Optional<Producto> obtenerProducto(@PathVariable Long id) {
        return productoRepository.findById(id);
    }

    // ==========================
    // POST - Crear un producto
    // ==========================
    //Ej.POST /productos
    // {
    //    "nombre":"Laptop",
    //    "categoria":"Electrónica",
    //    "precio":15000,
    //    "activo":true
    //}

    @PostMapping
    public Producto crearProducto(@Valid @RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // ==========================
    // PUT - Actualizar un producto
    // ==========================
    //Ej. PUT /productos/1
    //{
    //    "nombre":"Laptop Gamer",
    //    "categoria":"Electrónica",
    //    "precio":18000,
    //    "activo":true
    //}

    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id,
            @Valid @RequestBody Producto productoActualizado) {

        Producto producto = productoRepository.findById(id).orElseThrow();

        producto.setNombre(productoActualizado.getNombre());
        producto.setCategoria(productoActualizado.getCategoria());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setActivo(productoActualizado.getActivo());

        return productoRepository.save(producto);
    }

    // ==========================
    // DELETE - Eliminar un producto
    // ==========================
    //Ej. DELETE /productos/1

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoRepository.deleteById(id);
    }
}