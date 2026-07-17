package com.univo.backend_app.controllers;

import com.univo.backend_app.models.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
    // =====================================
    // ATRIBUTOS
    // =====================================
    // Lista donde se almacenarán temporalmente los productos
    private List<Producto> productos = new ArrayList<>();
    // =====================================
    // ENDPOINT GET
    // =====================================
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productos;
    }
    // =====================================
    // ENDPOINT POST
    // =====================================
    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        productos.add(producto);
        return producto;
    }

}
