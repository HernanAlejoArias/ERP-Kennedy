package com.kennedy.erp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Familiares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String apellido;

    private String parentezco;

    private long dni;

    @OneToOne
    private Empleado id_empleado;

    private String mail;


    private LocalDateTime fechaAlta;

    public Familiares() {
    }

    public Familiares(String nombre, String apellido, long dni, Empleado id_empleado, String mail, String parentezco) {
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


    public Empleado getid_Empleado() {
        return id_empleado;
    }

    public void setid_Empleado(Empleado id_empleado) {
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
