package com.kennedy.erp.controller;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import java.text.*;


public class EstudiosData {



    private long id_estudios;

    private String descripcion;


    private long id_empleado;

    private LocalDateTime fechaAlta;

    public EstudiosData() {
    }

    public EstudiosData(long id_empleado, String descripcion) {

        this.id_empleado = id_empleado;
        this.descripcion = descripcion;

        this.fechaAlta = LocalDateTime.now();
    }

    public long getId() {
        return id_estudios;
    }

    public String get_descripcion() {
        return descripcion;
    }

    public void set_descripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setid_Empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public long getid_Empleado() {
        return id_empleado;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }
}
