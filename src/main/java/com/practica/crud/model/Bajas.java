package com.practica.crud.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bajas")
public class Bajas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entidad", length = 4)
    private String entidad;

    @Column(name = "unidad", length = 5)
    private String unidad;

    @Column(name = "codigo", length = 15)
    private String codigo;

    @Column(name = "codbaja")
    private Integer codbaja;

    @Column(name = "codcont")
    private Integer codcont;

    @Column(name = "codaux")
    private Integer codaux;

    @Column(name = "codofic")
    private Integer codofic;

    @Column(name = "codresp")
    private Integer codresp;

    @Column(name = "costo", precision = 15, scale = 2)
    private BigDecimal costo;

    @Column(name = "depacu_ant", precision = 15, scale = 2)
    private BigDecimal depacuAnt;

    @Column(name = "descrip", length = 120)
    private String descrip;

    @Column(name = "d_baja")
    private Integer dBaja;

    @Column(name = "dia")
    private Integer dia;

    @Column(name = "m_baja")
    private Integer mBaja;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "a_baja")
    private Integer aBaja;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "b_rev")
    private Boolean bRev;

    @Column(name = "vidautil", precision = 5, scale = 2)
    private BigDecimal vidautil;

    @Column(name = "resolucion", length = 16)
    private String resolucion;

    @Column(name = "observ", columnDefinition = "TEXT")
    private String observ;

    @Column(name = "motivo", length = 120)
    private String motivo;

    @Column(name = "depacu", precision = 15, scale = 2)
    private BigDecimal depacu;

    @Column(name = "actua", precision = 15, scale = 2)
    private BigDecimal actua;

    @Column(name = "depgestion", precision = 15, scale = 2)
    private BigDecimal depgestion;

    @Column(name = "cosbajini", precision = 15, scale = 2)
    private BigDecimal cosbajini;

    @Column(name = "cosdaini", precision = 15, scale = 2)
    private BigDecimal cosdaini;

    @Column(name = "cosactbaj", precision = 15, scale = 2)
    private BigDecimal cosactbaj;

    @Column(name = "actdabaj", precision = 15, scale = 2)
    private BigDecimal actdabaj;

    @Column(name = "usuar", length = 8)
    private String usuar;

    @Column(name = "feult")
    private LocalDate feult;

    @Column(name = "fec_mod")
    private LocalDate fecMod;

    @Column(name = "usu_mod", length = 8)
    private String usuMod;

    // Campo temporal para el CRUD anterior; no pertenece a BAJAS.DBF.
    @Transient
    private String estado;

    public Bajas() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }

    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Integer getCodbaja() { return codbaja; }
    public void setCodbaja(Integer codbaja) { this.codbaja = codbaja; }

    public Integer getCodcont() { return codcont; }
    public void setCodcont(Integer codcont) { this.codcont = codcont; }

    public Integer getCodaux() { return codaux; }
    public void setCodaux(Integer codaux) { this.codaux = codaux; }

    public Integer getCodofic() { return codofic; }
    public void setCodofic(Integer codofic) { this.codofic = codofic; }

    public Integer getCodresp() { return codresp; }
    public void setCodresp(Integer codresp) { this.codresp = codresp; }

    public BigDecimal getCosto() { return costo; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }

    public BigDecimal getDepacuAnt() { return depacuAnt; }
    public void setDepacuAnt(BigDecimal depacuAnt) { this.depacuAnt = depacuAnt; }

    public String getDescrip() { return descrip; }
    public void setDescrip(String descrip) { this.descrip = descrip; }

    public Integer getDBaja() { return dBaja; }
    public void setDBaja(Integer dBaja) { this.dBaja = dBaja; }

    public Integer getDia() { return dia; }
    public void setDia(Integer dia) { this.dia = dia; }

    public Integer getMBaja() { return mBaja; }
    public void setMBaja(Integer mBaja) { this.mBaja = mBaja; }

    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }

    public Integer getABaja() { return aBaja; }
    public void setABaja(Integer aBaja) { this.aBaja = aBaja; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public Boolean getBRev() { return bRev; }
    public void setBRev(Boolean bRev) { this.bRev = bRev; }

    public BigDecimal getVidautil() { return vidautil; }
    public void setVidautil(BigDecimal vidautil) { this.vidautil = vidautil; }

    public String getResolucion() { return resolucion; }
    public void setResolucion(String resolucion) { this.resolucion = resolucion; }

    public String getObserv() { return observ; }
    public void setObserv(String observ) { this.observ = observ; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public BigDecimal getDepacu() { return depacu; }
    public void setDepacu(BigDecimal depacu) { this.depacu = depacu; }

    public BigDecimal getActua() { return actua; }
    public void setActua(BigDecimal actua) { this.actua = actua; }

    public BigDecimal getDepgestion() { return depgestion; }
    public void setDepgestion(BigDecimal depgestion) { this.depgestion = depgestion; }

    public BigDecimal getCosbajini() { return cosbajini; }
    public void setCosbajini(BigDecimal cosbajini) { this.cosbajini = cosbajini; }

    public BigDecimal getCosdaini() { return cosdaini; }
    public void setCosdaini(BigDecimal cosdaini) { this.cosdaini = cosdaini; }

    public BigDecimal getCosactbaj() { return cosactbaj; }
    public void setCosactbaj(BigDecimal cosactbaj) { this.cosactbaj = cosactbaj; }

    public BigDecimal getActdabaj() { return actdabaj; }
    public void setActdabaj(BigDecimal actdabaj) { this.actdabaj = actdabaj; }

    public String getUsuar() { return usuar; }
    public void setUsuar(String usuar) { this.usuar = usuar; }

    public LocalDate getFeult() { return feult; }
    public void setFeult(LocalDate feult) { this.feult = feult; }

    public LocalDate getFecMod() { return fecMod; }
    public void setFecMod(LocalDate fecMod) { this.fecMod = fecMod; }

    public String getUsuMod() { return usuMod; }
    public void setUsuMod(String usuMod) { this.usuMod = usuMod; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // Relacion candidata: el codigo de motivo de baja corresponde al catalogo BAJA.DBF.
    // Solo lectura; no genera una restriccion fisica de clave foranea.
    @com.fasterxml.jackson.annotation.JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(
            name = "codbaja",
            referencedColumnName = "codbaja",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private Baja bajaReferencia;

    public Baja getBajaReferencia() { return bajaReferencia; }
    public void setBajaReferencia(Baja bajaReferencia) { this.bajaReferencia = bajaReferencia; }

    // Alias de compatibilidad con el DTO y servicio actuales.
    public String getDescripcion() { return descrip; }
    public void setDescripcion(String descripcion) { this.descrip = descripcion; }
}
