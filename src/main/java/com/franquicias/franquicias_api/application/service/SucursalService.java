package com.franquicias.franquicias_api.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicias.franquicias_api.application.dto.SucursalDTO;
import com.franquicias.franquicias_api.application.mapper.SucursalMapper;
import com.franquicias.franquicias_api.domain.model.Franquicia;
import com.franquicias.franquicias_api.domain.model.Sucursal;
import com.franquicias.franquicias_api.domain.repository.FranquiciaRepository;
import com.franquicias.franquicias_api.domain.repository.SucursalRepository;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public SucursalDTO crear(SucursalDTO dto) {

        Franquicia franquicia = franquiciaRepository.findById(dto.getFranquiciaId())
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        Sucursal sucursal = new Sucursal();

        sucursal.setNombre(dto.getNombre());
        sucursal.setFranquicia(franquicia);

        Sucursal sucursalGuardada = sucursalRepository.save(sucursal);

        return SucursalMapper.toDTO(sucursalGuardada);
    }

    public SucursalDTO actualizarNombre(Long id, SucursalDTO dto) {

        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        sucursal.setNombre(dto.getNombre());

        Sucursal sucursalActualizada = sucursalRepository.save(sucursal);

        return SucursalMapper.toDTO(sucursalActualizada);
    }
}