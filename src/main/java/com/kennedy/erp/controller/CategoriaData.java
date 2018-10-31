package com.kennedy.erp.controller;

import java.time.LocalDateTime;

public class CategoriaData {

    private long id_categoria;

    private String descripcion;

    private LocalDateTime fechaAlta;

    public CategoriaData() {
    }

    public CategoriaData(String descripcion) {
        this.descripcion = descripcion;
        this.fechaAlta = LocalDateTime.now();
    }

    public long getId() {
        return id_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }
}
