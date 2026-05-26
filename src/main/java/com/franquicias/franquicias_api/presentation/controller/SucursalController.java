package com.franquicias.franquicias_api.presentation.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franquicias.franquicias_api.application.dto.SucursalDTO;
import com.franquicias.franquicias_api.application.service.SucursalService;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping
    public SucursalDTO crearSucursal(@RequestBody SucursalDTO dto) {
        return sucursalService.crear(dto);
    }

    @PutMapping("/{id}")
    public SucursalDTO actualizarNombre(
            @PathVariable Long id,
            @RequestBody SucursalDTO dto
    ) {
        return sucursalService.actualizarNombre(id, dto);
    }
}