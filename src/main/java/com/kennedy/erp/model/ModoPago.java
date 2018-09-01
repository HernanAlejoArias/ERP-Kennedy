package com.kennedy.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ModoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descripcion;

    public ModoPago() {
    }

    public ModoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
