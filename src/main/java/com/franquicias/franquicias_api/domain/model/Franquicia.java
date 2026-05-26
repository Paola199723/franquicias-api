package com.franquicias.franquicias_api.domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.franquicias.franquicias_api.application.dto.FranquiciaDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Franquicia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL)
    private List<Sucursal> sucursales = new ArrayList<>();

    public Franquicia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public Collection<FranquiciaDTO> getSucursal() {
        Collection<FranquiciaDTO> sucursal = new ArrayList<>();
        for (Sucursal s : sucursales) {
            sucursal.add(new FranquiciaDTO());
        }
        return sucursal;
    }
}