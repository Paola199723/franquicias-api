package com.franquicias.franquicias_api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "franquicia_id")
    private Franquicia franquicia;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)   
    private List<Producto> lista_productos;

    public void setNombre(Object nombre2) {
        nombre = (String) nombre2;
    }

    public void setFranquicia(Franquicia f) {
        franquicia = f;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }
}
