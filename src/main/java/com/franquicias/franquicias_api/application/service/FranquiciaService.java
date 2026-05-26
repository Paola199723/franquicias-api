package com.franquicias.franquicias_api.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicias.franquicias_api.application.dto.FranquiciaDTO;
import com.franquicias.franquicias_api.application.mapper.FranquiciaMapper;
import com.franquicias.franquicias_api.domain.model.Franquicia;
import com.franquicias.franquicias_api.domain.repository.FranquiciaRepository;

@Service
public class FranquiciaService {
    @Autowired
    private FranquiciaRepository repo;

    public FranquiciaDTO crear(FranquiciaDTO dto) {
        Franquicia f = new Franquicia();
        f.setNombre(dto.getNombre());

        Franquicia saved = repo.save(f);

        return FranquiciaMapper.toDTO(saved);
    }

    public List<FranquiciaDTO> listar() {
        return repo.findAll()
                .stream()
                .map(FranquiciaMapper::toDTO)
                .toList();
    }
}
