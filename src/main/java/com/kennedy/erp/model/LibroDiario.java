package com.kennedy.erp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class LibroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime fecha;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntradaLibroDiario> asiento;

    public LibroDiario() {
        this.fecha = LocalDateTime.now();
        this.asiento = new ArrayList<>();

    }

   public void addEntradaLibroDiario(EntradaLibroDiario entradaLibroDiario){

        this.asiento.add(entradaLibroDiario);

    }
}
