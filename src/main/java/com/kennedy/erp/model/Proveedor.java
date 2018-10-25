package com.kennedy.erp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String apellido;

    private String razonSocial;

    private long dni;

    private long cuil;

    private long cuit;

    private String mail;

    private String direccion;

    private LocalDateTime fechaAlta;

    public Proveedor() {
    }

    public Proveedor(String nombre, String apellido, String razonSocial, long dni, long cuil, long cuit, String mail, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.razonSocial = razonSocial;
        this.dni = dni;
        this.cuil = cuil;
        this.cuit = cuit;
        this.mail = mail;
        this.direccion = direccion;
        this.fechaAlta = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Map<String, Object> makeDTOCliente(){
        Map<String, Object> dto = new HashMap<>();

        dto.put("id", getId());
        dto.put("nombre", getNombre());
        dto.put("apellido", getApellido());
        dto.put("razonSocial", getRazonSocial());
        dto.put("dni", getDni());
        dto.put("cuil", getCuil());
        dto.put("cuit", getCuit());
        dto.put("mail", getMail());
        dto.put("direccion", getDireccion());
        dto.put("fechaAlta", getFechaAlta());

        return dto;
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
