package com.practica.crud.dto;

public class BajaDTO {

    private Long id;
    private String codigo;
    private String motivo;
    private String fecha;

    public BajaDTO() {
    }

    public BajaDTO(Long id, String codigo, String motivo, String fecha) {
        this.id = id;
        this.codigo = codigo;
        this.motivo = motivo;
        this.fecha = fecha;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}