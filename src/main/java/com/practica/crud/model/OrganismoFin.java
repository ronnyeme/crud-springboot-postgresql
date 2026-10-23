package com.practica.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organismo_fin")
public class OrganismoFin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos originales de ORGANISMO_FIN.DBF
    @Column(name = "gestion")
    private Integer gestion;

    @Column(name = "of", length = 3)
    private String of;

    @Column(name = "des", length = 100)
    private String des;

    @Column(name = "sigla", length = 15)
    private String sigla;

    // Campos anteriores, conservados para compatibilidad con el CRUD existente.
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    // Relación inversa de consulta: requiere unicidad de OF en PostgreSQL.
    // Si existen varias gestiones con el mismo OF, revisar el modelo antes de activarla.
    @JsonIgnore
    @OneToMany(mappedBy = "organismoFinReferencia", fetch = FetchType.LAZY)
    private List<Actual> activos = new ArrayList<>();

    public List<Actual> getActivos() { return activos; }
    public void setActivos(List<Actual> activos) { this.activos = activos; }

    public OrganismoFin() {}

    public OrganismoFin(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getGestion() { return gestion; }
    public void setGestion(Integer gestion) { this.gestion = gestion; }

    public String getOf() { return of; }
    public void setOf(String of) { this.of = of; }

    public String getDes() { return des; }
    public void setDes(String des) { this.des = des; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
