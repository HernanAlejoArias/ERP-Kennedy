package com.kennedy.erp.controller;

import com.kennedy.erp.model.Item;
import com.kennedy.erp.model.ItemMaterial;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTOMaterial {

    private long idProveedor;

    private List<ItemMaterial> items = new ArrayList<>();

    public PedidoDTOMaterial(long idProveedor, List<ItemMaterial> items) {
        this.idProveedor = idProveedor;
        this.items = items;
    }

    public PedidoDTOMaterial() {
    }

    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public List<ItemMaterial> getItems() {
        return items;
    }

    public void setItems(List<ItemMaterial> items) {
        this.items = items;
    }

}
