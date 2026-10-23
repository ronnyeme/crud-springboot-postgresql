package com.practica.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cta_par")
public class CtaPar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos originales de CTA_PAR.DBF
    @Column(name = "codcont")
    private Integer codcont;

    @Column(name = "partida", length = 5)
    private String partida;

    @Column(name = "gestion")
    private Integer gestion;

    // Campos del CRUD anterior: se conservan temporalmente para
    // no romper CtaParDTO ni CtaParService.
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    public CtaPar() {}

    public CtaPar(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getCodcont() { return codcont; }
    public void setCodcont(Integer codcont) { this.codcont = codcont; }

    public String getPartida() { return partida; }
    public void setPartida(String partida) { this.partida = partida; }

    public Integer getGestion() { return gestion; }
    public void setGestion(Integer gestion) { this.gestion = gestion; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
