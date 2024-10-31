package com.example.demo.controller;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/sucursal/{sucursalId}")
    public ResponseEntity<Producto> addProductoToSucursal(@PathVariable Long sucursalId,
            @RequestBody Producto producto) {
        Producto newProducto = productoService.addProductoToSucursal(sucursalId, producto);
        if (newProducto != null) {
            return new ResponseEntity<>(newProducto, HttpStatus.CREATED);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<Producto> updateStock(@PathVariable Long id, @RequestParam int stock) {
        return ResponseEntity.ok(productoService.updateStock(id, stock));
    }

    @PutMapping("/{id}/nombre")
    public ResponseEntity<Producto> updateNombre(@PathVariable Long id, @RequestParam String nombre) {
        Producto updatedProducto = productoService.updateNombre(id, nombre);
        if (updatedProducto != null) {
            return ResponseEntity.ok(updatedProducto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/franquicia/{franquiciaId}/max-stock")
    public ResponseEntity<List<ProductoDTO>> getMaxStockProductsByFranquicia(@PathVariable Long franquiciaId) {
        List<ProductoDTO> productos = productoService.getMaxStockFranquicia(franquiciaId);
        return ResponseEntity.ok(productos);
    }
}
