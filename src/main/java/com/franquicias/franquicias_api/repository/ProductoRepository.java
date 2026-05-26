package com.franquicias.franquicias_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franquicias.franquicias_api.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}