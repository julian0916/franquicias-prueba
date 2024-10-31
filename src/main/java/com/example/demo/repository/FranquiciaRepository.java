package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Franquicia;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
}
