package com.franquicias.franquicias_api.mapper;

import com.franquicias.franquicias_api.dto.FranquiciaDTO;
import com.franquicias.franquicias_api.model.Franquicia;

public class FranquiciaMapper {
public static FranquiciaDTO toDTO(Franquicia f) {
        FranquiciaDTO dto = new FranquiciaDTO();
        dto.setId(f.getId());
        dto.setNombre(f.getNombre());
        return dto;
    }

    public static Franquicia toEntity(FranquiciaDTO dto) {
        Franquicia f = new Franquicia();
        f.setNombre(dto.getNombre());
        return f;
    }
}
