package com.franquicias.franquicias_api.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicias.franquicias_api.application.dto.ProductoDTO;
import com.franquicias.franquicias_api.application.mapper.ProductoMapper;
import com.franquicias.franquicias_api.domain.model.Producto;
import com.franquicias.franquicias_api.domain.model.Sucursal;
import com.franquicias.franquicias_api.domain.repository.ProductoRepository;
import com.franquicias.franquicias_api.domain.repository.SucursalRepository;
@Service
public class ProductoService {
  @Autowired
    private ProductoRepository repo;

    @Autowired
    private SucursalRepository sucursalRepo;

    public ProductoDTO crear(ProductoDTO dto) {

        Sucursal s = sucursalRepo.findById(dto.getSucursalId())
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


    public ProductoDTO actualizarNombre(Long id, ProductoDTO dto){

        Producto p = repo.findById(id)
                .orElseThrow();

        p.setNombre(dto.getNombre());

        return ProductoMapper.toDTO(repo.save(p));
    }
}
