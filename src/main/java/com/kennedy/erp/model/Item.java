package com.kennedy.erp.model;

public class Item {

    private long producto;

    private long cantidad;

    public Item(long producto, long cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Item() {
    }

    public long getProducto() {
        return producto;
    }

    public void setProducto(long producto) {
        this.producto = producto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

}
