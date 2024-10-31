package com.example.demo.dto;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private int stock;
    private Long sucursalId;

    public ProductoDTO(Long id, String nombre, int stock, Long sucursalId) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.sucursalId = sucursalId;
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

    public Long getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Long sucursalId) {
        this.sucursalId = sucursalId;
    }
}
