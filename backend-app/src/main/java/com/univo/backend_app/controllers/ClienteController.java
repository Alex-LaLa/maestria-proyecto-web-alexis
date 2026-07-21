package com.univo.backend_app.controllers;

import com.univo.backend_app.models.Cliente;
import com.univo.backend_app.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // ==========================
    // GET - Obtener todos los clientes
    // ==========================

    @GetMapping
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    // ==========================
    // GET - Obtener un cliente por ID
    // ==========================

    @GetMapping("/{id}")
    public Optional<Cliente> obtenerCliente(@PathVariable Long id) {
        return clienteRepository.findById(id);
    }

    // ==========================
    // POST - Crear un cliente
    // ==========================

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // ==========================
    // PUT - Actualizar un cliente
    // ==========================

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id,
                                     @RequestBody Cliente clienteActualizado) {

        Cliente cliente = clienteRepository.findById(id).orElseThrow();

        cliente.setNombreCompleto(clienteActualizado.getNombreCompleto());
        cliente.setEmail(clienteActualizado.getEmail());
        cliente.setCiudad(clienteActualizado.getCiudad());
        cliente.setFechaCreacion(clienteActualizado.getFechaCreacion());

        return clienteRepository.save(cliente);
    }

    // ==========================
    // DELETE - Eliminar un cliente
    // ==========================

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}