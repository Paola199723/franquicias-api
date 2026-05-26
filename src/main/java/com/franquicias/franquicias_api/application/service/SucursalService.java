package com.franquicias.franquicias_api.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicias.franquicias_api.application.dto.SucursalDTO;
import com.franquicias.franquicias_api.application.mapper.SucursalMapper;
import com.franquicias.franquicias_api.domain.model.Franquicia;
import com.franquicias.franquicias_api.domain.model.sucursal;
import com.franquicias.franquicias_api.domain.repository.FranquiciaRepository;
import com.franquicias.franquicias_api.domain.repository.SucursalRepository;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository repo;

    @Autowired
    private FranquiciaRepository franquiciaRepo;

    public SucursalDTO crear(SucursalDTO dto) {

        Franquicia f = franquiciaRepo.findById(dto.getFranquiciaId())
                .orElseThrow();

        sucursal s = new sucursal();
        s.setNombre(dto.getNombre());
        s.setFranquicia(f);

        return SucursalMapper.toDTO(repo.save(s));
    }
}
