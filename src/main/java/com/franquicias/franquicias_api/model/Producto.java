package com.franquicias.franquicias_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Producto {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;
private Integer stock;

@ManyToOne
@JoinColumn(name = "sucursal_id")
private sucursal sucursal;

public void setNombre(Object nombre2) {
    nombre = (String) nombre2;
}

public void setStock(Object stock2) {
    stock = (Integer) stock2;
}

public void setSucursal(sucursal s) {
    sucursal = s;

}

public void setStock(Integer stock) {
        this.stock = stock;
}

public Long getId() {
        return id;
}

public String getNombre() {
        return nombre;
}

public Integer getStock() {
        return stock;
}

public sucursal getSucursal() {
        return sucursal;
}
}

