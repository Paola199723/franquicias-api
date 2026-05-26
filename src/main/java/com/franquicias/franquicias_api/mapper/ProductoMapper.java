package com.franquicias.franquicias_api.mapper;

import com.franquicias.franquicias_api.dto.ProductoDTO;
import com.franquicias.franquicias_api.model.Producto;

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
