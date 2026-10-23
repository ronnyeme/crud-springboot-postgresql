package com.practica.crud.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "oficina")
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos originales de OFICINA.DBF (vSIAF)
    @Column(name = "entidad", length = 4)
    private String entidad;

    @Column(name = "unidad", length = 5)
    private String unidad;

    @Column(name = "codofic")
    private Integer codofic;

    @Column(name = "nomofic", length = 65)
    private String nomofic;

    @Column(name = "observ", columnDefinition = "TEXT")
    private String observ;

    @Column(name = "feult")
    private LocalDate feult;

    @Column(name = "usuar", length = 8)
    private String usuar;

    @Column(name = "api_estado")
    private Integer apiEstado;

    // Relación de consulta con la unidad administrativa.
    // Pendiente validar UNIQUE(entidad, unidad) en unidadadmin.
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad",
                    insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad",
                    insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Unidadadmin unidadAdministrativaReferencia;

    public Unidadadmin getUnidadAdministrativaReferencia() {
        return unidadAdministrativaReferencia;
    }

    public void setUnidadAdministrativaReferencia(Unidadadmin unidadAdministrativaReferencia) {
        this.unidadAdministrativaReferencia = unidadAdministrativaReferencia;
    }

    // Relación candidata: una oficina puede tener varios responsables.
    // Validar UNIQUE(entidad, unidad, codofic) en oficina antes de usarla.
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad",
                    insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad",
                    insertable = false, updatable = false),
            @JoinColumn(name = "codofic", referencedColumnName = "codofic",
                    insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Resp> responsables = new ArrayList<>();

    public List<Resp> getResponsables() { return responsables; }
    public void setResponsables(List<Resp> responsables) { this.responsables = responsables; }

    // Relación inversa de consulta: activos asignados a esta oficina.
    // La asociación propietaria se encuentra en Actual.oficinaReferencia.
    // Pendiente validar UNIQUE(entidad, unidad, codofic) en PostgreSQL.
    @JsonIgnore
    @OneToMany(mappedBy = "oficinaReferencia", fetch = FetchType.LAZY)
    private List<Actual> activos = new ArrayList<>();

    public List<Actual> getActivos() { return activos; }
    public void setActivos(List<Actual> activos) { this.activos = activos; }

    // Compatibilidad temporal con OficinaService y OficinaDTO actuales.
    // Estos campos no se persisten como columnas independientes.
    @Transient
    private String codigo;

    @Transient
    private String descripcion;

    public Oficina() {}

    public Oficina(String codigo, String nombre, String descripcion) {
        setCodigo(codigo);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }

    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    public Integer getCodofic() { return codofic; }
    public void setCodofic(Integer codofic) { this.codofic = codofic; }

    public String getNomofic() { return nomofic; }
    public void setNomofic(String nomofic) { this.nomofic = nomofic; }

    public String getObserv() { return observ; }
    public void setObserv(String observ) { this.observ = observ; }

    public LocalDate getFeult() { return feult; }
    public void setFeult(LocalDate feult) { this.feult = feult; }

    public String getUsuar() { return usuar; }
    public void setUsuar(String usuar) { this.usuar = usuar; }

    public Integer getApiEstado() { return apiEstado; }
    public void setApiEstado(Integer apiEstado) { this.apiEstado = apiEstado; }

    // Métodos de compatibilidad con el CRUD antiguo.
    public String getCodigo() {
        return codofic != null ? codofic.toString() : codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        if (codigo == null || codigo.isBlank()) {
            this.codofic = null;
        } else {
            this.codofic = Integer.valueOf(codigo.trim());
        }
    }

    public String getNombre() { return nomofic; }
    public void setNombre(String nombre) { this.nomofic = nombre; }

    public String getDescripcion() { return observ != null ? observ : descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        this.observ = descripcion;
    }
}
