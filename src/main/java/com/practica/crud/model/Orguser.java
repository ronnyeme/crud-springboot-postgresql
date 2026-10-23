package com.practica.crud.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orguser")
public class Orguser {

    // Identificador técnico del CRUD existente (no es el ID del DBF).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campos existentes: se conservan para no romper el servicio y el DTO actuales.
    private String codigo;
    private String usuario;
    private String descripcion;

    // Siete atributos originales de ORGUSER.DBF.
    @Column(name = "type", length = 12)
    private String type;

    @Column(name = "org_id", length = 12)
    private String orgId;

    @Column(name = "name", length = 24)
    private String name;

    @Column(name = "readonly")
    private Boolean readOnly;

    @Column(name = "ckval")
    private Integer ckval;

    // El tipo Memo (M) de FoxPro se representa como texto largo.
    @Column(name = "data", columnDefinition = "TEXT")
    private String data;

    @Column(name = "updated")
    private LocalDate updated;

    public Orguser() {}

    public Orguser(String codigo, String usuario, String descripcion) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.descripcion = descripcion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getOrgId() { return orgId; }
    public void setOrgId(String orgId) { this.orgId = orgId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Boolean getReadOnly() { return readOnly; }
    public void setReadOnly(Boolean readOnly) { this.readOnly = readOnly; }
    public Integer getCkval() { return ckval; }
    public void setCkval(Integer ckval) { this.ckval = ckval; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public LocalDate getUpdated() { return updated; }
    public void setUpdated(LocalDate updated) { this.updated = updated; }
}
