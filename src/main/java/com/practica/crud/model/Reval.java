package com.practica.crud.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "reval")
public class Reval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entidad", length = 4)
    private String entidad;

    @Column(name = "unidad", length = 5)
    private String unidad;

    @Column(name = "codigo", length = 15)
    private String codigo;

    @Column(name = "costo", precision = 15, scale = 2)
    private BigDecimal costo;

    @Column(name = "depacu_ant", precision = 15, scale = 2)
    private BigDecimal depacuAnt;

    @Column(name = "d_reval")
    private Integer dReval;

    @Column(name = "dia")
    private Integer dia;

    @Column(name = "m_reval")
    private Integer mReval;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "a_reval")
    private Integer aReval;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "vidautil", precision = 5, scale = 2)
    private BigDecimal vidautil;

    @Column(name = "resolucion", length = 16)
    private String resolucion;

    @Column(name = "observ", columnDefinition = "TEXT")
    private String observ;

    @Column(name = "usuar", length = 8)
    private String usuar;

    @Column(name = "feult")
    private LocalDate feult;

    @Column(name = "depacu", precision = 15, scale = 2)
    private BigDecimal depacu;

    @Column(name = "actua", precision = 15, scale = 2)
    private BigDecimal actua;

    @Column(name = "depgestion", precision = 15, scale = 2)
    private BigDecimal depgestion;

    @Column(name = "fec_mod")
    private LocalDate fecMod;

    @Column(name = "usu_mod", length = 8)
    private String usuMod;

    @Transient
    private String descripcion;

    @Transient
    private String estado;

    public Reval() {}

    public Reval(String codigo, String descripcion, String estado) {
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

    public BigDecimal getCosto() { return costo; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }

    public BigDecimal getDepacuAnt() { return depacuAnt; }
    public void setDepacuAnt(BigDecimal depacuAnt) { this.depacuAnt = depacuAnt; }

    public Integer getDReval() { return dReval; }
    public void setDReval(Integer dReval) { this.dReval = dReval; }

    public Integer getDia() { return dia; }
    public void setDia(Integer dia) { this.dia = dia; }

    public Integer getMReval() { return mReval; }
    public void setMReval(Integer mReval) { this.mReval = mReval; }

    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }

    public Integer getAReval() { return aReval; }
    public void setAReval(Integer aReval) { this.aReval = aReval; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public BigDecimal getVidautil() { return vidautil; }
    public void setVidautil(BigDecimal vidautil) { this.vidautil = vidautil; }

    public String getResolucion() { return resolucion; }
    public void setResolucion(String resolucion) { this.resolucion = resolucion; }

    public String getObserv() { return observ; }
    public void setObserv(String observ) { this.observ = observ; }

    public String getUsuar() { return usuar; }
    public void setUsuar(String usuar) { this.usuar = usuar; }

    public LocalDate getFeult() { return feult; }
    public void setFeult(LocalDate feult) { this.feult = feult; }

    public BigDecimal getDepacu() { return depacu; }
    public void setDepacu(BigDecimal depacu) { this.depacu = depacu; }

    public BigDecimal getActua() { return actua; }
    public void setActua(BigDecimal actua) { this.actua = actua; }

    public BigDecimal getDepgestion() { return depgestion; }
    public void setDepgestion(BigDecimal depgestion) { this.depgestion = depgestion; }

    public LocalDate getFecMod() { return fecMod; }
    public void setFecMod(LocalDate fecMod) { this.fecMod = fecMod; }

    public String getUsuMod() { return usuMod; }
    public void setUsuMod(String usuMod) { this.usuMod = usuMod; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

}
