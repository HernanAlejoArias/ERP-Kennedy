package com.kennedy.erp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class StockMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JsonIgnore
    private Material material;

    private long cantidad;

    public StockMaterial() {
    }

    public StockMaterial(Material material, long cantidad) {
        this.material = material;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad += cantidad;
    }
}
