package com.practica.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/** Campos originales de estado.dbf (vSIAF). */
@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codestado")
    private Integer codestado;

    @Column(name = "nomestado", length = 10)
    private String nomestado;

    // Relación inversa de consulta: Actual.estadoReferencia es el lado propietario.
    @JsonIgnore
    @OneToMany(mappedBy = "estadoReferencia", fetch = FetchType.LAZY)
    private List<Actual> activos = new ArrayList<>();

    public List<Actual> getActivos() { return activos; }
    public void setActivos(List<Actual> activos) { this.activos = activos; }

    // Compatibilidad temporal con EstadoDTO y EstadoService existentes.
    @Transient
    private String descripcion;

    public Estado() { }

    public Estado(String codigo, String nombre, String descripcion) {
        setCodigo(codigo);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getCodestado() { return codestado; }
    public void setCodestado(Integer codestado) { this.codestado = codestado; }

    public String getNomestado() { return nomestado; }
    public void setNomestado(String nomestado) { this.nomestado = nomestado; }

    public String getCodigo() {
        return codestado == null ? null : codestado.toString();
    }

    public void setCodigo(String codigo) {
        this.codestado = codigo == null || codigo.isBlank()
                ? null : Integer.valueOf(codigo.trim());
    }

    public String getNombre() { return nomestado; }
    public void setNombre(String nombre) { this.nomestado = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}

