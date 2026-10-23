package com.practica.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passw")
public class Passw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ocho campos presentes en PASSW.DBF.
    @Column(name = "usuario", length = 10)
    private String usuario;

    @Column(name = "completo", length = 40)
    private String completo;

    @Column(name = "des", length = 50)
    private String des;

    // Campo heredado del DBF. No exponer ni utilizar para autenticar usuarios.
    @JsonIgnore
    @Column(name = "psw", length = 10)
    private String psw;

    @Column(name = "tipo")
    private Boolean tipo;

    @Column(name = "grupo", length = 8)
    private String grupo;

    @Column(name = "feult")
    private LocalDate feult;

    @Column(name = "usuar", length = 8)
    private String usuar;

    // Compatibilidad temporal con PasswService y PasswDTO antiguos.
    // No persistir claves antiguas como texto plano.
    @Transient
    @JsonIgnore
    private String clave;

    @Transient
    private String estado;

    public Passw() {}

    public Passw(String usuario, String clave, String estado) {
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getCompleto() { return completo; }
    public void setCompleto(String completo) { this.completo = completo; }
    public String getDes() { return des; }
    public void setDes(String des) { this.des = des; }
    @JsonIgnore
    public String getPsw() { return psw; }
    @JsonIgnore
    public void setPsw(String psw) { this.psw = psw; }
    public Boolean getTipo() { return tipo; }
    public void setTipo(Boolean tipo) { this.tipo = tipo; }
    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }
    public LocalDate getFeult() { return feult; }
    public void setFeult(LocalDate feult) { this.feult = feult; }
    public String getUsuar() { return usuar; }
    public void setUsuar(String usuar) { this.usuar = usuar; }
    @JsonIgnore
    public String getClave() { return clave; }
    @JsonIgnore
    public void setClave(String clave) { this.clave = clave; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
