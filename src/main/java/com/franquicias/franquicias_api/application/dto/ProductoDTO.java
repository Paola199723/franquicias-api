package com.franquicias.franquicias_api.application.dto;

import lombok.Data;

@Data
public class ProductoDTO {

    private Long id;
    private String nombre;
    private Integer stock;
    private Long sucursalId;
   
}
