package com.kennedy.erp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class FacturaCabecera {

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
    Set<FacturaDetalle> items;

    public FacturaCabecera() {
    }

    public FacturaCabecera(Cliente cliente, Vendedor vendedor, ModoPago modoPago) {
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

    public Set<FacturaDetalle> getItems() {
        return items;
    }

    public void setItems(Set<FacturaDetalle> items) {
        this.items = items;
    }

    public long getId(){
        return id;
    }

    public Map<String, Object> makeDTO(){
        Map<String, Object> pedidoDTO = new HashMap<>();

        pedidoDTO.put("id-cliente", this.cliente.getId());
        pedidoDTO.put("id-vendedor", this.vendedor.getId());
        pedidoDTO.put("modo-pago", this.modoPago.getId());


        double total = 0;
        for (FacturaDetalle item: items ) total += item.getProducto().getPrecio() * item.getCantidad();

        pedidoDTO.put("importe-total", total);


        pedidoDTO.put("items", items);

        return pedidoDTO;
    }

}
