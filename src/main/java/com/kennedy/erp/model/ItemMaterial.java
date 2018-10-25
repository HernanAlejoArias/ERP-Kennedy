package com.kennedy.erp.model;

public class ItemMaterial {

    private long material;

    private long cantidad;

    public ItemMaterial(long material, long cantidad) {
        this.material = material;
        this.cantidad = cantidad;
    }

    public ItemMaterial() {
    }

    public long getMaterial() {
        return material;
    }

    public void setMaterial(long material) {
        this.material = material;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

}
