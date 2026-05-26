package com.franquicias.franquicias_api.model;

import java.util.List;

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
private long id;

private String nombre;

@OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL)
private List<sucursal> Sucursallista;
}
