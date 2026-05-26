package com.franquicias.franquicias_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franquicias.franquicias_api.domain.model.sucursal;

public interface SucursalRepository extends JpaRepository<sucursal, Long> {}