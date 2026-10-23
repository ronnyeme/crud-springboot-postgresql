
package com.practica.crud.dto;

public class EntidadesDTO {

    // ATRIBUTOS
    private Long id;
    private Integer gestion;
    private String entidad;
    private String descEnt;
    private String siglaEnt;
    private Integer sectorEnt;
    private Integer subsecEnt;
    private Integer areaEnt;
    private Integer subareaent;
    private Integer nivelInst;

    // CONSTRUCTOR VACIO
    public EntidadesDTO() {
    }

    // CONSTRUCTOR COMPLETO
    public EntidadesDTO(
            Long id,
            Integer gestion,
            String entidad,
            String descEnt,
            String siglaEnt,
            Integer sectorEnt,
            Integer subsecEnt,
            Integer areaEnt,
            Integer subareaent,
            Integer nivelInst) {

        this.id = id;
        this.gestion = gestion;
        this.entidad = entidad;
        this.descEnt = descEnt;
        this.siglaEnt = siglaEnt;
        this.sectorEnt = sectorEnt;
        this.subsecEnt = subsecEnt;
        this.areaEnt = areaEnt;
        this.subareaent = subareaent;
        this.nivelInst = nivelInst;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGestion() {
        return gestion;
    }

    public void setGestion(Integer gestion) {
        this.gestion = gestion;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getDescEnt() {
        return descEnt;
    }

    public void setDescEnt(String descEnt) {
        this.descEnt = descEnt;
    }

    public String getSiglaEnt() {
        return siglaEnt;
    }

    public void setSiglaEnt(String siglaEnt) {
        this.siglaEnt = siglaEnt;
    }

    public Integer getSectorEnt() {
        return sectorEnt;
    }

    public void setSectorEnt(Integer sectorEnt) {
        this.sectorEnt = sectorEnt;
    }

    public Integer getSubsecEnt() {
        return subsecEnt;
    }

    public void setSubsecEnt(Integer subsecEnt) {
        this.subsecEnt = subsecEnt;
    }

    public Integer getAreaEnt() {
        return areaEnt;
    }

    public void setAreaEnt(Integer areaEnt) {
        this.areaEnt = areaEnt;
    }

    public Integer getSubareaent() {
        return subareaent;
    }

    public void setSubareaent(Integer subareaent) {
        this.subareaent = subareaent;
    }

    public Integer getNivelInst() {
        return nivelInst;
    }

    public void setNivelInst(Integer nivelInst) {
        this.nivelInst = nivelInst;
    }
}
