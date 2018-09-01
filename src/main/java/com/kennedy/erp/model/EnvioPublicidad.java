package com.kennedy.erp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EnvioPublicidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="publicidad_id")
    private Publicidad publicidad;

    private LocalDateTime fechaEnvio;

    public EnvioPublicidad() {
    }

    public EnvioPublicidad(Cliente cliente, Publicidad publicidad) {
        this.cliente = cliente;
        this.publicidad = publicidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Publicidad getPublicidad() {
        return publicidad;
    }

    public void setPublicidad(Publicidad publicidad) {
        this.publicidad = publicidad;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}
