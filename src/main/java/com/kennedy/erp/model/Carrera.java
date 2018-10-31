package com.kennedy.erp.model;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import java.text.*;
@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_carrera;

    private Date fecha_desde;

    private Date fecha_hasta;

    @OneToOne
    private Empleado id_empleado;

    @OneToOne
    private Categoria id_categoria;

    private LocalDateTime fechaAlta;

    public Carrera() {
    }

    public Carrera(Empleado id_empleado, Categoria id_categoria, String fechaDesde, String fechaHasta) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.id_empleado = id_empleado;
        this.id_categoria = id_categoria;
        try
        {
            this.fecha_desde = sdf.parse(fechaDesde);
            this.fecha_hasta = sdf.parse(fechaHasta);
        }
        catch(ParseException ex)
        {
            System.out.println(ex.toString());
        }
        this.fechaAlta = LocalDateTime.now();
    }

    public long getId() {
        return id_carrera;
    }

    public Date getfecha_Desde() {
        return fecha_desde;
    }

    public void setfecha_desde(Date fecha_desde) {
        this.fecha_desde = fecha_desde;
    }

    public Date getfecha_Hasta() {
        return fecha_hasta;
    }

    public void setfecha_Hasta(Date fecha_hasta) {
        this.fecha_hasta = fecha_hasta;
    }

    public void setid_Empleado(Empleado id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Empleado getid_Empleado() {
        return id_empleado;
    }

    public void setid_Categoria(Categoria id_Categoria) {
        this.id_categoria = id_categoria;
    }

    public Categoria getid_Categoria() {
        return id_categoria;
    }



    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }
}
