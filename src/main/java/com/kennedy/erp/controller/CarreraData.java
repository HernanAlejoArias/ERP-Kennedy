package com.kennedy.erp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class CarreraData {



    private String fechaDesde;

    private String fechaHasta;

    private long id_empleado;

    private long id_categoria;

    private long id_carrera;

    private LocalDateTime fechaAlta;

    public CarreraData() {
    }

    public CarreraData(String fechaDesde, String fechaHasta, long id_empleado, int id_categoria ) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta= fechaHasta;

        this.id_empleado = id_empleado;
        this.id_categoria = id_categoria;
        this.fechaAlta = LocalDateTime.now();
    }

    public long getId() {
        return id_carrera;
    }

    public String getfecha_Desde() {
        return fechaDesde;
    }

    public void setfecha_desde(String fecha_desde) {
        this.fechaDesde = fecha_desde;
    }

    public String getfecha_Hasta() {
        return fechaHasta;
    }

    public void setfecha_Hasta(String fecha_hasta) {
        this.fechaHasta = fecha_hasta;
    }

    public void setid_Empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public long getid_Empleado() {
        return id_empleado;
    }

    public void setid_Categoria(long id_Categoria) {
        this.id_categoria = id_categoria;
    }

    public long getid_Categoria() {
        return id_categoria;
    }



    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }
}
