package com.kennedy.erp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class PedidoMaterialCabecera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Proveedor proveedor;

    private LocalDateTime fechaCreacion;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    Set<PedidoMaterialDetalle> items;

    public PedidoMaterialCabecera() {
    }

    public PedidoMaterialCabecera(Proveedor proveedor) {
        this.proveedor = proveedor;
        this.fechaCreacion = LocalDateTime.now();
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Set<PedidoMaterialDetalle> getItems() {
        return items;
    }

    public void setItems(Set<PedidoMaterialDetalle> items) {
        this.items = items;
    }

    public long getId(){
        return id;
    }

    public Map<String, Object> makeDTO(){
        Map<String, Object> pedidoDTO = new HashMap<>();

        pedidoDTO.put("id-proveedor", this.proveedor.getId());

        pedidoDTO.put("items", items);

        return pedidoDTO;
    }

}
