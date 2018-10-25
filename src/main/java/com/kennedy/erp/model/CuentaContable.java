package com.kennedy.erp.model;


import javax.persistence.*;

@Entity
public class CuentaContable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descripcion;

    public CuentaContable(String descripcion) {
        this.descripcion = descripcion;
    }

    public CuentaContable() {
    }

    public long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
