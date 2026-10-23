package com.practica.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campo original de DATA.DBF (Visual FoxPro: Character(50)).
    @Column(name = "data", length = 50)
    private String data;

    // Compatibilidad temporal con DataService y DataDTO existentes.
    // Estos campos NO se guardan en la base de datos.
    @Transient
    private String codigo;

    @Transient
    private String valor;

    @Transient
    private String descripcion;

    public Data() {
    }

    public Data(String codigo, String valor, String descripcion) {
        this.codigo = codigo;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
