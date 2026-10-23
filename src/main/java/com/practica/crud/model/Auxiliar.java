package com.practica.crud.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "auxiliar")
public class Auxiliar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos originales de auxiliar.DBF
    @Column(name = "entidad", length = 4)
    private String entidad;

    @Column(name = "unidad", length = 5)
    private String unidad;

    @Column(name = "codcont")
    private Integer codcont;

    @Column(name = "codaux")
    private Integer codaux;

    @Column(name = "nomaux", length = 50)
    private String nomaux;

    @Column(name = "observ", columnDefinition = "TEXT")
    private String observ;

    @Column(name = "feult")
    private LocalDate feult;

    @Column(name = "usuar", length = 8)
    private String usuar;

    // Relacion de consulta con la clasificacion contable.
    // Requiere que codcont.codcont sea UNIQUE en PostgreSQL.
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "codcont", referencedColumnName = "codcont",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Codcont codcontReferencia;

    public Codcont getCodcontReferencia() { return codcontReferencia; }
    public void setCodcontReferencia(Codcont codcontReferencia) {
        this.codcontReferencia = codcontReferencia;
    }

    // Relación inversa de Actual. Requiere validar la unicidad de
    // (entidad, unidad, codcont, codaux) en auxiliar antes de usarla.
    @com.fasterxml.jackson.annotation.JsonIgnore
    @OneToMany(mappedBy = "auxiliarReferencia", fetch = FetchType.LAZY)
    private List<Actual> activos = new ArrayList<>();

    public List<Actual> getActivos() { return activos; }
    public void setActivos(List<Actual> activos) { this.activos = activos; }

    // Compatibilidad temporal con AuxiliarService y AuxiliarDTO existentes.
    // Estos tres campos no forman parte del archivo DBF original.
    @Transient
    private String codigo;

    @Transient
    private String descripcion;

    public Auxiliar() {}

    public Auxiliar(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nomaux = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }
    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }
    public Integer getCodcont() { return codcont; }
    public void setCodcont(Integer codcont) { this.codcont = codcont; }
    public Integer getCodaux() { return codaux; }
    public void setCodaux(Integer codaux) { this.codaux = codaux; }
    public String getNomaux() { return nomaux; }
    public void setNomaux(String nomaux) { this.nomaux = nomaux; }
    public String getObserv() { return observ; }
    public void setObserv(String observ) { this.observ = observ; }
    public LocalDate getFeult() { return feult; }
    public void setFeult(LocalDate feult) { this.feult = feult; }
    public String getUsuar() { return usuar; }
    public void setUsuar(String usuar) { this.usuar = usuar; }

    // Métodos conservados para que el servicio actual compile.
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nomaux; }
    public void setNombre(String nombre) { this.nomaux = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
