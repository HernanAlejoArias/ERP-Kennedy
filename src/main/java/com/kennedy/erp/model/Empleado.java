package com.kennedy.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String apellido;

    private long dni;

    private long cuil;

    private long cuit;

    private String direccion;

    private String email;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, long dni, long cuil, long cuit, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.cuil = cuil;
        this.cuit = cuit;
        this.direccion = direccion;
        this.email = email;
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

    public long getCuil() {
        return cuil;
    }

    public void setCuil(long cuil) {
        this.cuil = cuil;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
