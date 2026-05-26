package com.franquicias.franquicias_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicias.franquicias_api.dto.FranquiciaDTO;
import com.franquicias.franquicias_api.mapper.FranquiciaMapper;
import com.franquicias.franquicias_api.model.Franquicia;
import com.franquicias.franquicias_api.repository.FranquiciaRepository;

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
