package com.kennedy.erp.model;

import javax.persistence.*;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descripcion;

    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private StockMaterial stock;

    public Material() {
    }

    public Material(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public StockMaterial getStock() {
        return stock;
    }

    public void setStock(StockMaterial stock) {
        this.stock = stock;
    }
}
