package com.franquicias.franquicias_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicias.franquicias_api.dto.SucursalDTO;
import com.franquicias.franquicias_api.mapper.SucursalMapper;
import com.franquicias.franquicias_api.model.Franquicia;
import com.franquicias.franquicias_api.model.sucursal;
import com.franquicias.franquicias_api.repository.FranquiciaRepository;
import com.franquicias.franquicias_api.repository.SucursalRepository;
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
