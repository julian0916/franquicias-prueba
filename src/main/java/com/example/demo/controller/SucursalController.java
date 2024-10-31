package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sucursal;
import com.example.demo.service.SucursalService;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @PostMapping
    public ResponseEntity<Sucursal> createSucursal(@RequestBody Sucursal sucursal) {
        return new ResponseEntity<>(sucursalService.save(sucursal), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> updateSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        Sucursal updatedSucursal = sucursalService.update(id, sucursal);
        if (updatedSucursal != null) {
            return ResponseEntity.ok(updatedSucursal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Sucursal>> getAllSucursales() {
        return ResponseEntity.ok(sucursalService.findAll());
    }
}
