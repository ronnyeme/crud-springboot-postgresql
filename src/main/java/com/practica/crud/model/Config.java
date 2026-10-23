package com.practica.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "config")
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entidad", length = 4)
    private String entidad;

    @Column(name = "descent", length = 120)
    private String descent;

    @Column(name = "unidad", length = 5)
    private String unidad;

    @Column(name = "descuni", length = 120)
    private String descuni;

    @Column(name = "usuario", length = 10)
    private String usuario;

    // Compatibilidad provisional con ConfigService y ConfigDTO anteriores.
    // No se almacenan en la tabla: adaptar DTO y servicio antes de probar el CRUD.
    @Transient
    private String parametro;

    @Transient
    private String valor;

    @Transient
    private String descripcion;

    public Config() {}

    public Config(String parametro, String valor, String descripcion) {
        this.parametro = parametro;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }

    public String getDescent() { return descent; }
    public void setDescent(String descent) { this.descent = descent; }

    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    public String getDescuni() { return descuni; }
    public void setDescuni(String descuni) { this.descuni = descuni; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getParametro() { return parametro; }
    public void setParametro(String parametro) { this.parametro = parametro; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
