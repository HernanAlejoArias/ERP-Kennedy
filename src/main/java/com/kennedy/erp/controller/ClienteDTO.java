package com.kennedy.erp.controller;

import com.kennedy.erp.model.TipoCliente;

import javax.persistence.*;
import java.time.LocalDateTime;

public class ClienteDTO {

    private long id;

    private String nombre;

    private String apellido;

    private String razonSocial;

    private long dni;

    private long cuil;

    private long cuit;

    private int idTipoCliente;

    private String mail;

    private String direccion;

    private LocalDateTime fechaAlta;

    public ClienteDTO() {
    }

    public ClienteDTO(String nombre, String apellido, String razonSocial, long dni, long cuil, long cuit, int idTipoCliente, String mail, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.razonSocial = razonSocial;
        this.dni = dni;
        this.cuil = cuil;
        this.cuit = cuit;
        this.idTipoCliente = idTipoCliente;
        this.mail = mail;
        this.direccion = direccion;
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

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public int getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(int idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
