package com.practica.crud.dto;

public class OrguserDTO {

    private Long id;
    private String codigo;
    private String usuario;
    private String descripcion;

    public OrguserDTO() {
    }

    public OrguserDTO(Long id, String codigo, String usuario, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}