package com.practica.crud.dto;

public class DataDTO {

    private Long id;
    private String codigo;
    private String valor;
    private String descripcion;

    public DataDTO() {
    }

    public DataDTO(Long id, String codigo, String valor, String descripcion) {
        this.id = id;
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