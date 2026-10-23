package com.practica.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "objgasto")
public class Objgasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos originales de OBJGASTO.DBF
    @Column(name = "gestion")
    private Integer gestion;

    @Column(name = "partida", length = 5)
    private String partida;

    @Column(name = "descrip", length = 50)
    private String descrip;

    // Campos existentes: compatibilidad temporal con DTO y Service.
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    public Objgasto() {}

    public Objgasto(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getGestion() { return gestion; }
    public void setGestion(Integer gestion) { this.gestion = gestion; }

    public String getPartida() { return partida; }
    public void setPartida(String partida) { this.partida = partida; }

    public String getDescrip() { return descrip; }
    public void setDescrip(String descrip) { this.descrip = descrip; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
