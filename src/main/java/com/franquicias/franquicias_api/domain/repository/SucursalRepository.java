package com.franquicias.franquicias_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franquicias.franquicias_api.domain.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {}