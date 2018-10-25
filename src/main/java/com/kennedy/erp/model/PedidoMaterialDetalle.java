package com.kennedy.erp.model;

import javax.persistence.*;

@Entity
public class PedidoMaterialDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Material material;

    private long cantidad;

    private double precio;

    public PedidoMaterialDetalle() {
    }

    public PedidoMaterialDetalle(Material material, long cantidad) {
        this.material = material;
        this.cantidad = cantidad;
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
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
