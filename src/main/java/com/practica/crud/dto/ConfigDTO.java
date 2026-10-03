package com.practica.crud.dto;

public class ConfigDTO {

    private Long id;
    private String parametro;
    private String valor;
    private String descripcion;

    public ConfigDTO() {
    }

    public ConfigDTO(Long id, String parametro, String valor, String descripcion) {
        this.id = id;
        this.parametro = parametro;
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
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