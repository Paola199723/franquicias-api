package com.franquicias.franquicias_api.application.dto;

import lombok.Data;

@Data
public class SucursalDTO {
    private Long id;
    private String nombre;
    private Long franquiciaId;

}
