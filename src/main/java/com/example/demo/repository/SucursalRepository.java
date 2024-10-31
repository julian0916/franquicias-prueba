package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
}
