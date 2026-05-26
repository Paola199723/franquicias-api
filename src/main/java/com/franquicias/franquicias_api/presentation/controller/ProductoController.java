package com.franquicias.franquicias_api.presentation.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franquicias.franquicias_api.application.dto.ProductoDTO;
import com.franquicias.franquicias_api.application.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ProductoDTO crearProducto(@RequestBody ProductoDTO dto) {
        return productoService.crear(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminar(id);
    }

    @PutMapping("/{id}/stock")
    public ProductoDTO actualizarStock(
            @PathVariable Long id,
            @RequestBody ProductoDTO dto
    ) {
        return productoService.actualizarStock(id, dto.getStock());
    }

    @PutMapping("/{id}")
    public ProductoDTO actualizarNombre(
            @PathVariable Long id,
            @RequestBody ProductoDTO dto
    ) {
        return productoService.actualizarNombre(id, dto);
    }
}