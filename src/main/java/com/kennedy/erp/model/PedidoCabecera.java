package com.kennedy.erp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class PedidoCabecera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Vendedor vendedor;

    @OneToOne
    private ModoPago modoPago;

    private LocalDateTime fechaCreacion;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    Set<PedidoDetalle> items;

    public PedidoCabecera() {
    }

    public PedidoCabecera(Cliente cliente, Vendedor vendedor, ModoPago modoPago) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.modoPago = modoPago;
        this.fechaCreacion = LocalDateTime.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ModoPago getModoPago() {
        return modoPago;
    }

    public void setModoPago(ModoPago modoPago) {
        this.modoPago = modoPago;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Set<PedidoDetalle> getItems() {
        return items;
    }

    public void setItems(Set<PedidoDetalle> items) {
        this.items = items;
    }
}
