package com.franquicias.franquicias_api.application.mapper;

import com.franquicias.franquicias_api.application.dto.SucursalDTO;
import com.franquicias.franquicias_api.domain.model.Sucursal;

public class SucursalMapper {
public static SucursalDTO toDTO(Sucursal s) {
        SucursalDTO dto = new SucursalDTO();
        dto.setId(s.getId());
        dto.setNombre(s.getNombre());
        dto.setFranquiciaId(s.getFranquicia().getId());
        return dto;
    }

}
