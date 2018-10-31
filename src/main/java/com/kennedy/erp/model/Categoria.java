package com.kennedy.erp.model;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_categoria;

    private String descripcion;

    private LocalDateTime fechaAlta;

    public Categoria() {
    }

    public Categoria(String descripcion) {
        this.descripcion = descripcion;
        this.fechaAlta = LocalDateTime.now();
    }

    public long getId() {
        return id_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }
}
