package com.franquicias.franquicias_api.mapper;

import com.franquicias.franquicias_api.dto.SucursalDTO;
import com.franquicias.franquicias_api.model.sucursal;

public class SucursalMapper {
public static SucursalDTO toDTO(sucursal s) {
        SucursalDTO dto = new SucursalDTO();
        dto.setId(s.getId());
        dto.setNombre(s.getNombre());
        dto.setFranquiciaId(s.getFranquicia().getId());
        return dto;
    }

}
