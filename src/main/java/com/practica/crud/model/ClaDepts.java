package com.practica.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "cla_depts")
public class ClaDepts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // CLA_DEPTS.DBF: CODIGO N(2,0)
    @Column(name = "codigo")
    private Integer codigoDbf;

    // CLA_DEPTS.DBF: DESC C(15)
    @Column(name = "\"desc\"", length = 15)
    private String desc;

    // CLA_DEPTS.DBF: SIGLA C(10)
    @Column(name = "sigla", length = 10)
    private String sigla;

    // Compatibilidad provisional con el DTO/Service antiguo.
    @Transient
    private String descripcionAnterior;

    public ClaDepts() {}

    public ClaDepts(String codigo, String nombre, String descripcion) {
        setCodigo(codigo);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getCodigoDbf() { return codigoDbf; }
    public void setCodigoDbf(Integer codigoDbf) { this.codigoDbf = codigoDbf; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    // Métodos utilizados por ClaDeptsService.java existente.
    public String getCodigo() {
        return codigoDbf == null ? null : codigoDbf.toString();
    }

    public void setCodigo(String codigo) {
        this.codigoDbf = codigo == null || codigo.isBlank()
                ? null : Integer.valueOf(codigo.trim());
    }

    public String getNombre() { return desc; }
    public void setNombre(String nombre) { this.desc = nombre; }

    public String getDescripcion() { return descripcionAnterior; }
    public void setDescripcion(String descripcion) {
        this.descripcionAnterior = descripcion;
    }
}
