package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private int stock;

	@ManyToOne
	@JoinColumn(name = "sucursal_id", nullable = false)
	private Sucursal sucursal;

	@ManyToOne
	@JoinColumn(name = "franquicia_id")
	private Franquicia franquicia;

	public Producto() {
	}

	public Producto(String nombre, int stock, Sucursal sucursal) {
		this.nombre = nombre;
		this.stock = stock;
		this.sucursal = sucursal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Franquicia getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(Franquicia franquicia) {
		this.franquicia = franquicia;
	}
}
