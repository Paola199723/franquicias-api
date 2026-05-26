package com.franquicias.franquicias_api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.franquicias.franquicias_api.dto.ProductoDTO;
import com.franquicias.franquicias_api.mapper.ProductoMapper;
import com.franquicias.franquicias_api.model.Producto;
import com.franquicias.franquicias_api.model.sucursal;
import com.franquicias.franquicias_api.repository.ProductoRepository;
import com.franquicias.franquicias_api.repository.SucursalRepository;

public class ProductoService {
  @Autowired
    private ProductoRepository repo;

    @Autowired
    private SucursalRepository sucursalRepo;

    public ProductoDTO crear(ProductoDTO dto) {

        sucursal s = sucursalRepo.findById(dto.getSucursalId())
                .orElseThrow();

        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setStock(dto.getStock());
        p.setSucursal(s);

        return ProductoMapper.toDTO(repo.save(p));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public ProductoDTO actualizarStock(Long id, Integer stock) {

        Producto p = repo.findById(id)
                .orElseThrow();

        p.setStock(stock);

        return ProductoMapper.toDTO(repo.save(p));
    }
}
