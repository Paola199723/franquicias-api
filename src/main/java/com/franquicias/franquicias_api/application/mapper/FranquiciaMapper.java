package com.franquicias.franquicias_api.application.mapper;

import com.franquicias.franquicias_api.application.dto.FranquiciaDTO;
import com.franquicias.franquicias_api.domain.model.Franquicia;


public class FranquiciaMapper {

    public static FranquiciaDTO toDTO(Franquicia franquicia) {

        FranquiciaDTO dto = new FranquiciaDTO();

        dto.setId(franquicia.getId());
        dto.setNombre(franquicia.getNombre());

        return dto;
    }

    public static Franquicia toEntity(FranquiciaDTO dto) {

        Franquicia franquicia = new Franquicia();

        franquicia.setNombre(dto.getNombre());

        return franquicia;
    }
}