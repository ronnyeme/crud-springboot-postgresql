package com.practica.crud.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Estructura de RESP.DBF (vSIAF). Relaciones pendientes de validación. */
@Entity
@Table(name = "resp")
public class Resp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entidad", length = 4)
    private String entidad;

    @Column(name = "unidad", length = 5)
    private String unidad;

    @Column(name = "codofic")
    private Integer codofic;

    @Column(name = "codresp")
    private Integer codresp;

    @Column(name = "nomresp", length = 35)
    private String nomresp;

    @Column(name = "cargo", length = 35)
    private String cargo;

    @Column(name = "observ", columnDefinition = "TEXT")
    private String observ;

    @Column(name = "ci", length = 20)
    private String ci;

    @Column(name = "feult")
    private LocalDate feult;

    @Column(name = "usuar", length = 8)
    private String usuar;

    @Column(name = "cod_exp")
    private Integer codExp;

    @Column(name = "api_estado")
    private Integer apiEstado;

    // Relación candidata de consulta: RESP(entidad, unidad, codofic) -> OFICINA.
    // Requiere validar UNIQUE(entidad, unidad, codofic) en oficina.
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad",
                    insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad",
                    insertable = false, updatable = false),
            @JoinColumn(name = "codofic", referencedColumnName = "codofic",
                    insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Oficina oficinaReferencia;

    public Oficina getOficinaReferencia() { return oficinaReferencia; }
    public void setOficinaReferencia(Oficina oficinaReferencia) {
        this.oficinaReferencia = oficinaReferencia;
    }

    // Relación inversa de Actual.responsableReferencia.
    // Pendiente validar la unicidad de (entidad, unidad, codofic, codresp).
    @JsonIgnore
    @OneToMany(mappedBy = "responsableReferencia", fetch = FetchType.LAZY)
    private List<Actual> activos = new ArrayList<>();

    public List<Actual> getActivos() { return activos; }
    public void setActivos(List<Actual> activos) { this.activos = activos; }

    // Compatibilidad temporal con RespDTO/RespService existentes.
    @Transient
    private String codigo;
    @Transient
    private String descripcion;

    public Resp() {}

    public Resp(String codigo, String nombre, String descripcion) {
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

    public Integer getCodresp() { return codresp; }
    public void setCodresp(Integer codresp) { this.codresp = codresp; }

    public String getNomresp() { return nomresp; }
    public void setNomresp(String nomresp) { this.nomresp = nomresp; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getObserv() { return observ; }
    public void setObserv(String observ) { this.observ = observ; }

    public String getCi() { return ci; }
    public void setCi(String ci) { this.ci = ci; }

    public LocalDate getFeult() { return feult; }
    public void setFeult(LocalDate feult) { this.feult = feult; }

    public String getUsuar() { return usuar; }
    public void setUsuar(String usuar) { this.usuar = usuar; }

    public Integer getCodExp() { return codExp; }
    public void setCodExp(Integer codExp) { this.codExp = codExp; }

    public Integer getApiEstado() { return apiEstado; }
    public void setApiEstado(Integer apiEstado) { this.apiEstado = apiEstado; }

    public String getCodigo() {
        return codresp != null ? codresp.toString() : codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        this.codresp = (codigo == null || codigo.isBlank())
                ? null : Integer.valueOf(codigo.trim());
    }

    public String getNombre() { return nomresp; }
    public void setNombre(String nombre) { this.nomresp = nombre; }

    public String getDescripcion() {
        return observ != null ? observ : descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        this.observ = descripcion;
    }
}
