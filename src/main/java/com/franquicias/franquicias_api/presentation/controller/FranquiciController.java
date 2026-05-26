package com.franquicias.franquicias_api.presentation.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franquicias.franquicias_api.application.dto.FranquiciaDTO;
import com.franquicias.franquicias_api.application.service.FranquiciaService;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciController {
@Autowired
    private FranquiciaService franquiciaService;

    // Crear franquicia
    @PostMapping
    public FranquiciaDTO crearFranquicia(
            @RequestBody FranquiciaDTO dto
    ) {
        return franquiciaService.crear(dto);
    }

    // Listar franquicias
    @GetMapping
    public List<FranquiciaDTO> listarFranquicias() {
        return franquiciaService.listar();
    }
}
