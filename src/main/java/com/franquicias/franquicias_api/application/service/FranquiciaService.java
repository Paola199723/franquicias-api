package com.franquicias.franquicias_api.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicias.franquicias_api.application.dto.FranquiciaDTO;
import com.franquicias.franquicias_api.application.dto.ProductoDTO;
import com.franquicias.franquicias_api.application.mapper.FranquiciaMapper;
import com.franquicias.franquicias_api.application.mapper.ProductoMapper;
import com.franquicias.franquicias_api.domain.model.Franquicia;
import com.franquicias.franquicias_api.domain.model.Producto;
import com.franquicias.franquicias_api.domain.repository.FranquiciaRepository;

@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public FranquiciaDTO crear(FranquiciaDTO dto) {

        Franquicia franquicia = new Franquicia();

        franquicia.setNombre(dto.getNombre());

        Franquicia franquiciaGuardada = franquiciaRepository.save(franquicia);

        return FranquiciaMapper.toDTO(franquiciaGuardada);
    }

    public List<FranquiciaDTO> listar() {

        return franquiciaRepository.findAll()
                .stream()
                .map(FranquiciaMapper::toDTO)
                .toList();
    }

    public FranquiciaDTO actualizarNombre(Long id, FranquiciaDTO dto) {

        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        franquicia.setNombre(dto.getNombre());

        Franquicia franquiciaActualizada = franquiciaRepository.save(franquicia);

        return FranquiciaMapper.toDTO(franquiciaActualizada);
    }
public List<ProductoDTO> obtenerProductosConMasStock(Long franquiciaId) {

    Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
            .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

    return franquicia.getSucursales()
            .stream()
            .flatMap(sucursal -> sucursal.getProductos().stream())
            .sorted(Comparator.comparing(Producto::getStock).reversed())
            .map(ProductoMapper::toDTO)
            .toList();
}

}