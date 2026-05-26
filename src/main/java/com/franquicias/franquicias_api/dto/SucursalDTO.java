package com.franquicias.franquicias_api.dto;

import lombok.Data;

@Data
public class SucursalDTO {
    private Long id;
    private String nombre;
    private Long franquiciaId;

}
