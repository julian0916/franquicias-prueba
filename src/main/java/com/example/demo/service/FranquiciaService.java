package com.example.demo.service;

import com.example.demo.model.Franquicia;
import com.example.demo.repository.FranquiciaRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranquiciaService {

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Franquicia save(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public List<Franquicia> findAll() {
        return franquiciaRepository.findAll();
    }

    public Franquicia findById(Long id) {
        return franquiciaRepository.findById(id).orElse(null);
    }

    public Franquicia update(Long id, Franquicia franquicia) {
        Franquicia existingFranquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Franquicia no encontrada"));

        existingFranquicia.setNombre(franquicia.getNombre());

        if (franquicia.getSucursales() != null) {

            franquicia.getSucursales().forEach(sucursal -> {
                if (!existingFranquicia.getSucursales().contains(sucursal)) {
                    sucursal.setFranquicia(existingFranquicia);
                    existingFranquicia.getSucursales().add(sucursal);
                }
            });
        }

        return franquiciaRepository.save(existingFranquicia);
    }
}
