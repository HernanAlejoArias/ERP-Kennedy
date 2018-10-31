package com.kennedy.erp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import java.text.*;

@Entity
public class Estudios {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_estudios;

    private String descripcion;

    @OneToOne
    private Empleado id_empleado;

    private LocalDateTime fechaAlta;

    public Estudios() {
    }

    public Estudios(Empleado id_empleado, String descripcion) {

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

    public void set_descripcion(Date fecha_desde) {
        this.descripcion = descripcion;
    }

    public void setid_Empleado(Empleado id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Empleado getid_Empleado() {
        return id_empleado;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }
}
