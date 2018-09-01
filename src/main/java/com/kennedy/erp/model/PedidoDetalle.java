package com.kennedy.erp.model;

import javax.persistence.Entity;

@Entity
public class PedidoDetalle {

    private long id;

    private int item;

    private Producto producto;

    private int cantidad;

}
