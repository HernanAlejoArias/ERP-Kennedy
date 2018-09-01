package com.kennedy.erp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String apellido;

    private String razonSocial;

    private long dni;

    private long cuil;

    private long cuit;

    @OneToOne
    private TipoCliente tipoCliente;

    private String mail;

    private String direccion;

    private LocalDateTime fechaAlta;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String razonSocial, long dni, long cuil, long cuit, TipoCliente tipo_cliente, String mail, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.razonSocial = razonSocial;
        this.dni = dni;
        this.cuil = cuil;
        this.cuit = cuit;
        this.tipoCliente = tipo_cliente;
        this.mail = mail;
        this.direccion = direccion;
        this.fechaAlta = LocalDateTime.now();
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

    public TipoCliente getTipo_cliente() {
        return tipoCliente;
    }

    public void setTipo_cliente(TipoCliente tipo_cliente) {
        this.tipoCliente = tipo_cliente;
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

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

}
