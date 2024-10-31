package com.example.demo.service;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.model.Producto;
import com.example.demo.model.Sucursal;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private SucursalRepository sucursalRepository;

	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	public void delete(Long id) {
		productoRepository.deleteById(id);
	}

	public Producto updateStock(Long id, int stock) {
		Optional<Producto> optionalProducto = productoRepository.findById(id);
		if (optionalProducto.isPresent()) {
			Producto producto = optionalProducto.get();
			producto.setStock(stock);
			return productoRepository.save(producto);
		}
		return null;
	}

	public Producto updateNombre(Long id, String nombre) {
		Optional<Producto> optionalProducto = productoRepository.findById(id);
		if (optionalProducto.isPresent()) {
			Producto producto = optionalProducto.get();
			producto.setNombre(nombre);
			return productoRepository.save(producto);
		}
		return null;
	}

	public List<Producto> findBySucursalId(Long sucursalId) {
		return productoRepository.findBySucursalId(sucursalId);
	}

	public Producto addProductoToSucursal(Long sucursalId, Producto producto) {
		Optional<Sucursal> sucursalOptional = sucursalRepository.findById(sucursalId);
		if (sucursalOptional.isPresent()) {
			Sucursal sucursal = sucursalOptional.get();
			producto.setSucursal(sucursal);
			producto.setFranquicia(sucursal.getFranquicia());
			return productoRepository.save(producto);
		}
		return null;
	}

	public List<ProductoDTO> getMaxStockFranquicia(Long franquiciaId) {
		List<Producto> productos = productoRepository.findMaxStockProductsByFranquicia(franquiciaId);

		return productos.stream()
				.map(producto -> new ProductoDTO(producto.getId(), producto.getNombre(), producto.getStock(),
						producto.getSucursal().getId()))
				.collect(Collectors.toList());
	}
}
