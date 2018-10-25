package com.kennedy.erp.model;

import javax.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descripcion;

    private double precio;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private StockProducto stock;

    public Producto() {
    }

    public Producto(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public StockProducto getStock() {
        return stock;
    }

    public void setStock(StockProducto stock) {
        this.stock = stock;
    }
}
