package com.kennedy.erp.controller;


import javax.persistence.*;
import java.time.LocalDateTime;


public class FamiliaresData {


    private long id;

    private String nombre;

    private String apellido;

    private String parentezco;

    private long dni;

    private long id_empleado;

    private String mail;


    private LocalDateTime fechaAlta;

    public FamiliaresData() {
    }

    public FamiliaresData(String nombre, String apellido, long dni, int id_empleado, String mail, String parentezco) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.id_empleado = id_empleado;
        this.mail = mail;
        this.parentezco = parentezco;
        this.fechaAlta = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }


    public long getid_Empleado() {
        return id_empleado;
    }

    public void setid_Empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getMail() {
        return mail;
    }

    public void setParentezco(String mail) {
        this.parentezco = mail;
    }

    public String getParentezco() {
        return parentezco;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }
}
