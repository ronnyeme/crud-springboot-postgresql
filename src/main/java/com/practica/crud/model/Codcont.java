package com.practica.crud.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "codcont")
public class Codcont {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos originales de CODCONT.DBF
    @Column(name = "codcont")
    private Integer codcont;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "vidautil")
    private Integer vidautil;

    @Column(name = "observ", columnDefinition = "TEXT")
    private String observ;

    @Column(name = "depreciar")
    private Boolean depreciar;

    @Column(name = "actualizar")
    private Boolean actualizar;

    @Column(name = "feult")
    private LocalDate feult;

    @Column(name = "usuar", length = 8)
    private String usuar;

    // Relacion inversa con AUXILIAR: el lado propietario esta en Auxiliar.codcontReferencia.
    // No crea una columna adicional ni una clave foranea fisica.
    @JsonIgnore
    @OneToMany(mappedBy = "codcontReferencia", fetch = FetchType.LAZY)
    private List<Auxiliar> auxiliares = new ArrayList<>();

    // Relacion inversa con ACTUAL: lado propietario en Actual.codcontReferencia.
    // Requiere validar UNIQUE(codcont) en PostgreSQL.
    @JsonIgnore
    @OneToMany(mappedBy = "codcontReferencia", fetch = FetchType.LAZY)
    private List<Actual> activos = new ArrayList<>();

    public List<Actual> getActivos() { return activos; }
    public void setActivos(List<Actual> activos) { this.activos = activos; }

    public List<Auxiliar> getAuxiliares() { return auxiliares; }
    public void setAuxiliares(List<Auxiliar> auxiliares) { this.auxiliares = auxiliares; }

    public Codcont() {}

    // Constructor compatible con el proyecto previo.
    public Codcont(String codigo, String nombre, String descripcion) {
        setCodigo(codigo);
        this.nombre = nombre;
        this.observ = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getCodcont() { return codcont; }
    public void setCodcont(Integer codcont) { this.codcont = codcont; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getVidautil() { return vidautil; }
    public void setVidautil(Integer vidautil) { this.vidautil = vidautil; }
    public String getObserv() { return observ; }
    public void setObserv(String observ) { this.observ = observ; }
    public Boolean getDepreciar() { return depreciar; }
    public void setDepreciar(Boolean depreciar) { this.depreciar = depreciar; }
    public Boolean getActualizar() { return actualizar; }
    public void setActualizar(Boolean actualizar) { this.actualizar = actualizar; }
    public LocalDate getFeult() { return feult; }
    public void setFeult(LocalDate feult) { this.feult = feult; }
    public String getUsuar() { return usuar; }
    public void setUsuar(String usuar) { this.usuar = usuar; }

    // Compatibilidad temporal con CodcontService y CodcontDTO existentes.
    @Transient
    public String getCodigo() { return codcont == null ? null : codcont.toString(); }
    public void setCodigo(String codigo) {
        this.codcont = (codigo == null || codigo.isBlank()) ? null : Integer.valueOf(codigo.trim());
    }
    @Transient
    public String getDescripcion() { return observ; }
    public void setDescripcion(String descripcion) { this.observ = descripcion; }
}
