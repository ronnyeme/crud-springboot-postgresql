package com.practica.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "mes")
public class Mes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MES.DBF: MES N(2,0)
    @Column(name = "mes")
    private Integer mes;

    // MES.DBF: NOMMES C(10)
    @Column(name = "nommes", length = 10)
    private String nommes;

    // Compatibilidad temporal: no se guarda en la base de datos.
    @Transient
    private String descripcionAnterior;

    public Mes() { }

    public Mes(String codigo, String nombre, String descripcion) {
        setCodigo(codigo);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }

    public String getNommes() { return nommes; }
    public void setNommes(String nommes) { this.nommes = nommes; }

    // Alias temporales para el MesService y MesDTO actuales.
    public String getCodigo() { return mes == null ? null : mes.toString(); }
    public void setCodigo(String codigo) {
        this.mes = codigo == null || codigo.isBlank()
                ? null : Integer.valueOf(codigo.trim());
    }

    public String getNombre() { return nommes; }
    public void setNombre(String nombre) { this.nommes = nombre; }

    public String getDescripcion() { return descripcionAnterior; }
    public void setDescripcion(String descripcion) { this.descripcionAnterior = descripcion; }
}
