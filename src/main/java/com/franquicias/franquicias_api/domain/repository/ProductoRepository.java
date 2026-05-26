package com.franquicias.franquicias_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franquicias.franquicias_api.domain.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}