package com.practica.crud.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "baja")
public class Baja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos originales de BAJA.DBF
    @Column(name = "codbaja")
    private Integer codbaja;

    @Column(name = "descbaja", length = 120)
    private String descbaja;

    // Relacion inversa de Bajas.bajaReferencia; no crea una segunda columna de union.
    // Pendiente: validar unicidad de baja.codbaja en PostgreSQL.
    @JsonIgnore
    @OneToMany(mappedBy = "bajaReferencia", fetch = FetchType.LAZY)
    private List<Bajas> registrosBajas = new ArrayList<>();

    public List<Bajas> getRegistrosBajas() { return registrosBajas; }
    public void setRegistrosBajas(List<Bajas> registrosBajas) { this.registrosBajas = registrosBajas; }

    // Campos temporales del CRUD anterior; no pertenecen a BAJA.DBF.
    @Transient
    private String codigo;

    @Transient
    private String fecha;

    public Baja() {}

    public Baja(String codigo, String motivo, String fecha) {
        this.codigo = codigo;
        this.descbaja = motivo;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getCodbaja() { return codbaja; }
    public void setCodbaja(Integer codbaja) { this.codbaja = codbaja; }

    public String getDescbaja() { return descbaja; }
    public void setDescbaja(String descbaja) { this.descbaja = descbaja; }

    // Compatibilidad provisional con BajaService y BajaDTO.
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getMotivo() { return descbaja; }
    public void setMotivo(String motivo) { this.descbaja = motivo; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}
