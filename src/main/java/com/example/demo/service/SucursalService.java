package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.model.Sucursal;
import com.example.demo.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Sucursal update(Long id, Sucursal sucursal) {
        Optional<Sucursal> existingSucursalOpt = sucursalRepository.findById(id);
        if (existingSucursalOpt.isPresent()) {
            Sucursal existingSucursal = existingSucursalOpt.get();

            existingSucursal.setNombre(sucursal.getNombre());

            existingSucursal.setFranquicia(sucursal.getFranquicia());

            if (sucursal.getProductos() != null) {
                existingSucursal.getProductos().removeIf(producto -> sucursal.getProductos().stream()
                        .noneMatch(p -> p.getId().equals(producto.getId())));

                for (Producto nuevoProducto : sucursal.getProductos()) {
                    if (nuevoProducto.getId() != null) {
                        existingSucursal.getProductos().stream()
                                .filter(p -> p.getId().equals(nuevoProducto.getId()))
                                .forEach(p -> p.setNombre(nuevoProducto.getNombre()));

                    } else {
                        nuevoProducto.setSucursal(existingSucursal);
                        existingSucursal.getProductos().add(nuevoProducto);
                    }
                }
            }

            return sucursalRepository.save(existingSucursal);
        }
        return null;
    }

    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }
}
