package com.kennedy.erp.controller;

import com.kennedy.erp.model.Item;
import org.graalvm.compiler.lir.alloc.lsra.LinearScan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PedidoDTO {

    private long idCliente;

    private long idVendedor;

    private long idModoPago;

    //private List<Map<String, Long>> items;
    private List<Item> items = new ArrayList<>();

//    public PedidoDTO(long idCliente, long idVendedor, long idModoPago,  List<Map<String, Long>> items) {
    public PedidoDTO(long idCliente, long idVendedor, long idModoPago,  List<Item> items) {
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.items = items;
    }

    public PedidoDTO() {
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(long idVendedor) {
        this.idVendedor = idVendedor;
    }

//    public List<Map<String, Long>> getItems() {
    public List<Item> getItems() {
        return items;
    }

//    public void setItems(List<Map<String, Long>> items) {
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public long getIdModoPago() {
        return idModoPago;
    }

    public void setIdModoPago(long idModoPago) {
        this.idModoPago = idModoPago;
    }
}
