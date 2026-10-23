package com.practica.crud.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "entidades")
public class Entidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gestion")
    private Integer gestion;

    @Column(name = "entidad", length = 4)
    private String entidad;

    @Column(name = "desc_ent", length = 110)
    private String descEnt;

    @Column(name = "sigla_ent", length = 15)
    private String siglaEnt;

    @Column(name = "sector_ent")
    private Integer sectorEnt;

    @Column(name = "subsec_ent")
    private Integer subsecEnt;

    @Column(name = "area_ent")
    private Integer areaEnt;

    @Column(name = "subareaent")
    private Integer subareaent;

    @Column(name = "nivel_inst")
    private Integer nivelInst;

    // Asociación provisional por código de entidad.
    // ENTIDADES incluye GESTION, pero UNIDADADMIN no; revisar el modelo
    // histórico antes de crear restricciones de integridad referencial.
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "entidad", referencedColumnName = "entidad",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Unidadadmin> unidadesAdministrativas = new ArrayList<>();

    public List<Unidadadmin> getUnidadesAdministrativas() {
        return unidadesAdministrativas;
    }

    public void setUnidadesAdministrativas(List<Unidadadmin> unidadesAdministrativas) {
        this.unidadesAdministrativas = unidadesAdministrativas;
    }

    public Entidades() {}

    public Entidades(String codigo, String nombre, String descripcion) {
        this.entidad = codigo;
        this.descEnt = descripcion != null ? descripcion : nombre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getGestion() { return gestion; }
    public void setGestion(Integer value) { this.gestion = value; }

    public String getEntidad() { return entidad; }
    public void setEntidad(String value) { this.entidad = value; }

    public String getDescEnt() { return descEnt; }
    public void setDescEnt(String value) { this.descEnt = value; }

    public String getSiglaEnt() { return siglaEnt; }
    public void setSiglaEnt(String value) { this.siglaEnt = value; }

    public Integer getSectorEnt() { return sectorEnt; }
    public void setSectorEnt(Integer value) { this.sectorEnt = value; }

    public Integer getSubsecEnt() { return subsecEnt; }
    public void setSubsecEnt(Integer value) { this.subsecEnt = value; }

    public Integer getAreaEnt() { return areaEnt; }
    public void setAreaEnt(Integer value) { this.areaEnt = value; }

    public Integer getSubareaent() { return subareaent; }
    public void setSubareaent(Integer value) { this.subareaent = value; }

    public Integer getNivelInst() { return nivelInst; }
    public void setNivelInst(Integer value) { this.nivelInst = value; }

    // Alias para mantener el servicio y DTO anteriores.
    @Transient
    public String getCodigo() { return entidad; }
    public void setCodigo(String codigo) { this.entidad = codigo; }

    @Transient
    public String getNombre() { return descEnt; }
    public void setNombre(String nombre) { this.descEnt = nombre; }

    @Transient
    public String getDescripcion() { return descEnt; }
    public void setDescripcion(String descripcion) { this.descEnt = descripcion; }
}
