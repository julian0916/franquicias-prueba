package com.example.demo.controller;

import com.example.demo.model.Franquicia;
import com.example.demo.service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {

    @Autowired
    private FranquiciaService franquiciaService;

    @PostMapping
    public ResponseEntity<Franquicia> createFranquicia(@RequestBody Franquicia franquicia) {
        return new ResponseEntity<>(franquiciaService.save(franquicia), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Franquicia> updateFranquicia(@PathVariable Long id, @RequestBody Franquicia franquicia) {
        return ResponseEntity.ok(franquiciaService.update(id, franquicia));
    }

    @GetMapping
    public ResponseEntity<List<Franquicia>> getAllFranquicias() {
        return ResponseEntity.ok(franquiciaService.findAll());
    }
}
