package com.practica.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.ConstraintMode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unidadadmin")
public class Unidadadmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entidad", length = 4)
    private String entidad;

    @Column(name = "unidad", length = 5)
    private String unidad;

    @Column(name = "descrip", length = 120)
    private String descrip;

    @Column(name = "ciudad", length = 20)
    private String ciudad;

    @Column(name = "estadouni")
    private Integer estadouni;

    // Asociación provisional, de solo lectura, por clave de negocio compuesta.
    // Requiere verificar la unicidad de (entidad, unidad) antes de habilitarla.
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad",
                    insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad",
                    insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Oficina> oficinas = new ArrayList<>();

    public List<Oficina> getOficinas() { return oficinas; }
    public void setOficinas(List<Oficina> oficinas) { this.oficinas = oficinas; }

    // Relación inversa provisional con la entidad institucional.
    // ENTIDADES incluye gestion y UNIDADADMIN no: validar unicidad
    // de entidades.entidad en PostgreSQL antes de habilitar el mapeo.
    @JsonIgnore
    @jakarta.persistence.ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "entidad", referencedColumnName = "entidad",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Entidades entidadReferencia;

    public Entidades getEntidadReferencia() { return entidadReferencia; }
    public void setEntidadReferencia(Entidades entidadReferencia) {
        this.entidadReferencia = entidadReferencia;
    }

    // Relación inversa con Actual.unidadAdministrativaReferencia.
    // Requiere validar la unicidad de (entidad, unidad) en UNIDADADMIN.
    @JsonIgnore
    @OneToMany(mappedBy = "unidadAdministrativaReferencia", fetch = FetchType.LAZY)
    private List<Actual> activos = new ArrayList<>();

    public List<Actual> getActivos() { return activos; }
    public void setActivos(List<Actual> activos) { this.activos = activos; }

    public Unidadadmin() {}

    // Constructor de compatibilidad con el proyecto original.
    public Unidadadmin(String codigo, String nombre, String descripcion) {
        this.unidad = codigo;
        this.descrip = descripcion != null ? descripcion : nombre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }

    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    public String getDescrip() { return descrip; }
    public void setDescrip(String descrip) { this.descrip = descrip; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public Integer getEstadouni() { return estadouni; }
    public void setEstadouni(Integer estadouni) { this.estadouni = estadouni; }

    // Alias de compatibilidad: no crean columnas adicionales.
    @Transient
    public String getCodigo() { return unidad; }
    public void setCodigo(String codigo) { this.unidad = codigo; }

    @Transient
    public String getNombre() { return descrip; }
    public void setNombre(String nombre) { this.descrip = nombre; }

    @Transient
    public String getDescripcion() { return descrip; }
    public void setDescripcion(String descripcion) { this.descrip = descripcion; }
}
