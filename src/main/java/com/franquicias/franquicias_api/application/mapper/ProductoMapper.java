package com.franquicias.franquicias_api.application.mapper;

import com.franquicias.franquicias_api.application.dto.ProductoDTO;
import com.franquicias.franquicias_api.domain.model.Producto;

import lombok.Data;
@Data
public class ProductoMapper {
 public static ProductoDTO toDTO(Producto p) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setStock(p.getStock());
        dto.setSucursalId(p.getSucursal().getId());
        return dto;
    }
}
