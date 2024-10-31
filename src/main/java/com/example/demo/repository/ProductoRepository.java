package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	List<Producto> findBySucursalId(Long sucursalId);

	@Query("SELECT p FROM Producto p WHERE p.stock = (SELECT MAX(p2.stock) FROM Producto p2 WHERE p2.sucursal.id = p.sucursal.id) AND p.sucursal.franquicia.id = :franquiciaId")
	List<Producto> findMaxStockProductsByFranquicia(@Param("franquiciaId") Long franquiciaId);

}
