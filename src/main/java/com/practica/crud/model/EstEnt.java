package com.practica.crud.model;

import jakarta.persistence.*;

/** Estructura institucional de VSIAF (EST_ENT.DBF). */
@Entity
@Table(name = "est_ent")
public class EstEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gestion")
    private Integer gestion;

    @Column(name = "sector_ent")
    private Integer sectorEnt;

    @Column(name = "subsec_ent")
    private Integer subsecEnt;

    @Column(name = "area_ent")
    private Integer areaEnt;

    @Column(name = "subareaent")
    private Integer subareaent;

    @Column(name = "nivel_inst")
    private Integer nivelInst;

    @Column(name = "des_estruc", length = 60)
    private String desEstruc;

    @Column(name = "siglaestru", length = 15)
    private String siglaestru;

    @Column(name = "apropiable", length = 1)
    private String apropiable;

    // Campos del CRUD anterior; se mantienen persistidos por compatibilidad.
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private String estado;

    public EstEnt() {}
    public EstEnt(String codigo, String nombre, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getGestion() { return gestion; }
    public void setGestion(Integer gestion) { this.gestion = gestion; }
    public Integer getSectorEnt() { return sectorEnt; }
    public void setSectorEnt(Integer sectorEnt) { this.sectorEnt = sectorEnt; }
    public Integer getSubsecEnt() { return subsecEnt; }
    public void setSubsecEnt(Integer subsecEnt) { this.subsecEnt = subsecEnt; }
    public Integer getAreaEnt() { return areaEnt; }
    public void setAreaEnt(Integer areaEnt) { this.areaEnt = areaEnt; }
    public Integer getSubareaent() { return subareaent; }
    public void setSubareaent(Integer subareaent) { this.subareaent = subareaent; }
    public Integer getNivelInst() { return nivelInst; }
    public void setNivelInst(Integer nivelInst) { this.nivelInst = nivelInst; }
    public String getDesEstruc() { return desEstruc; }
    public void setDesEstruc(String desEstruc) { this.desEstruc = desEstruc; }
    public String getSiglaestru() { return siglaestru; }
    public void setSiglaestru(String siglaestru) { this.siglaestru = siglaestru; }
    public String getApropiable() { return apropiable; }
    public void setApropiable(String apropiable) { this.apropiable = apropiable; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
