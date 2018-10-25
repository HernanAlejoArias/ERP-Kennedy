package com.kennedy.erp.model;

import javax.persistence.*;

@Entity
public class EntradaLibroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private DebeHaber tipo;

    private double monto;

    @OneToOne
    private CuentaContable cuentaContable;

    public EntradaLibroDiario(){}

    public EntradaLibroDiario(CuentaContable cuentaImputada, double monto, DebeHaber tipo){

        this.tipo = tipo;
        this.cuentaContable = cuentaImputada;
        this.monto = monto;

    }

    public long getId() {
        return id;
    }

}
