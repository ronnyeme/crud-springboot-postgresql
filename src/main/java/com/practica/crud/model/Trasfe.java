package com.practica.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;

/** Transferencias de activos fijos (estructura de trasfe.dbf). */
@Entity
@Table(name = "trasfe")
public class Trasfe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entidad", length = 4)
    private String entidad;

    @Column(name = "unidad", length = 5)
    private String unidad;

    @Column(name = "codigo", length = 15)
    private String codigo;

    @Column(name = "codofic")
    private Integer codofic;

    @Column(name = "codresp")
    private Integer codresp;

    @Column(name = "feult")
    private LocalDate feult;

    @Column(name = "usuar", length = 8)
    private String usuar;

    @Column(name = "unidadini", length = 5)
    private String unidadini;

    // Compatibilidad temporal con TrasfeService y TrasfeDTO existentes.
    // No se guardan en PostgreSQL: adaptar DTO y servicio antes de usar el CRUD.
    @Transient
    private String descripcion;

    @Transient
    private String estado;

    public Trasfe() {}

    public Trasfe(String codigo, String descripcion, String estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }

    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Integer getCodofic() { return codofic; }
    public void setCodofic(Integer codofic) { this.codofic = codofic; }

    public Integer getCodresp() { return codresp; }
    public void setCodresp(Integer codresp) { this.codresp = codresp; }

    public LocalDate getFeult() { return feult; }
    public void setFeult(LocalDate feult) { this.feult = feult; }

    public String getUsuar() { return usuar; }
    public void setUsuar(String usuar) { this.usuar = usuar; }

    public String getUnidadini() { return unidadini; }
    public void setUnidadini(String unidadini) { this.unidadini = unidadini; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
