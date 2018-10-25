package com.kennedy.erp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class StockProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JsonIgnore
    private Producto producto;

    private long cantidad;

    public StockProducto() {
    }

    public StockProducto( Producto producto, long cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad += cantidad;
    }
}
