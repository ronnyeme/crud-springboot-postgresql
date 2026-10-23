package com.practica.crud.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "actual")
public class Actual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unidad", length = 5)
    private String unidad;

    @Column(name = "entidad", length = 4)
    private String entidad;

    @Column(name = "codigo", length = 15)
    private String codigo;

    @Column(name = "codcont")
    private Integer codcont;

    @Column(name = "codaux")
    private Integer codaux;

    @Column(name = "vidautil", precision = 6, scale = 2)
    private BigDecimal vidautil;

    @Column(name = "descrip", length = 150)
    private String descrip;

    @Column(name = "costo", precision = 15, scale = 2)
    private BigDecimal costo;

    @Column(name = "depacu", precision = 15, scale = 2)
    private BigDecimal depacu;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "b_rev")
    private Boolean bRev;

    @Column(name = "dia")
    private Integer dia;

    @Column(name = "codofic")
    private Integer codofic;

    @Column(name = "codresp")
    private Integer codresp;

    @Column(name = "observ", columnDefinition = "TEXT")
    private String observ;

    @Column(name = "dia_ant")
    private Integer diaAnt;

    @Column(name = "mes_ant")
    private Integer mesAnt;

    @Column(name = "ano_ant")
    private Integer anoAnt;

    @Column(name = "vut_ant")
    private Integer vutAnt;

    @Column(name = "costo_ant", precision = 15, scale = 2)
    private BigDecimal costoAnt;

    @Column(name = "band_ufv")
    private Boolean bandUfv;

    @Column(name = "codestado")
    private Integer codestado;

    @Column(name = "cod_rube", length = 15)
    private String codRube;

    @Column(name = "nro_conv", length = 10)
    private String nroConv;

    @Column(name = "org_fin", length = 3)
    private String orgFin;

    @Column(name = "feult")
    private LocalDate feult;

    @Column(name = "usuar", length = 8)
    private String usuar;

    @Column(name = "api_estado")
    private Integer apiEstado;

    @Column(name = "codigosec", length = 15)
    private String codigosec;

    @Column(name = "banderas", length = 12)
    private String banderas;

    @Column(name = "fec_mod")
    private LocalDate fecMod;

    @Column(name = "usu_mod", length = 8)
    private String usuMod;

    // Relación de consulta con el catálogo ESTADO.DBF.
    // CODESTADO debe ser único en la tabla estado para que esta asociación sea válida.
    // insertable=false/updatable=false conservan a codestado como campo persistido.
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "codestado", referencedColumnName = "codestado",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Estado estadoReferencia;

    // Relación de consulta con CODCONT.DBF.
    // Verificado en el archivo original: 39 códigos CODCONT distintos.
    // Requiere UNIQUE(codcont) en PostgreSQL antes de activar consultas JPA.
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "codcont", referencedColumnName = "codcont",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Codcont codcontReferencia;

    // Asociación candidata con AUXILIAR.DBF por clave de contexto y clasificación.
    // Ambos DBF tienen cero registros: validar unicidad y correspondencia en datos reales.
    // PostgreSQL requiere UNIQUE(entidad, unidad, codcont, codaux) en auxiliar
    // antes de utilizar esta asociación como referencia estable.
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad", insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad", insertable = false, updatable = false),
            @JoinColumn(name = "codcont", referencedColumnName = "codcont", insertable = false, updatable = false),
            @JoinColumn(name = "codaux", referencedColumnName = "codaux", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Auxiliar auxiliarReferencia;

    // Asociación candidata con OFICINA.DBF mediante entidad, unidad y codofic.
    // No hay registros en el DBF para comprobar unicidad o integridad referencial.
    // Requiere UNIQUE(entidad, unidad, codofic) en oficina antes de usarla.
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad", insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad", insertable = false, updatable = false),
            @JoinColumn(name = "codofic", referencedColumnName = "codofic", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Oficina oficinaReferencia;

    // Asociación candidata con RESP.DBF: contexto administrativo y código responsable.
    // Pendiente: validar UNIQUE(entidad, unidad, codofic, codresp) en resp
    // y la correspondencia de los registros antes de consultar esta relación.
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad", insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad", insertable = false, updatable = false),
            @JoinColumn(name = "codofic", referencedColumnName = "codofic", insertable = false, updatable = false),
            @JoinColumn(name = "codresp", referencedColumnName = "codresp", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Resp responsableReferencia;

    // Asociación candidata con ORGANISMO_FIN.DBF mediante ORG_FIN -> OF.
    // En el DBF original los 142 valores OF son únicos, pero todos pertenecen
    // a GESTION=2013. Si se agregan otras gestiones, OF podría repetirse.
    // Antes de consultar esta asociación en PostgreSQL, validar UNIQUE(of)
    // o definir una clave compuesta con la gestión correcta.
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "org_fin", referencedColumnName = "of",
            insertable = false, updatable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private OrganismoFin organismoFinReferencia;

    public OrganismoFin getOrganismoFinReferencia() { return organismoFinReferencia; }
    public void setOrganismoFinReferencia(OrganismoFin organismoFinReferencia) {
        this.organismoFinReferencia = organismoFinReferencia;
    }

    // Relación candidata con UNIDADADMIN.DBF: ENTIDAD + UNIDAD.
    // Verificar unicidad de la clave compuesta en PostgreSQL antes de usarla.
    // No se genera una restricción FK automáticamente.
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad", insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Unidadadmin unidadAdministrativaReferencia;

    public Unidadadmin getUnidadAdministrativaReferencia() {
        return unidadAdministrativaReferencia;
    }

    public void setUnidadAdministrativaReferencia(Unidadadmin unidadAdministrativaReferencia) {
        this.unidadAdministrativaReferencia = unidadAdministrativaReferencia;
    }

    // Relación histórica candidata: un activo puede registrar varias revalorizaciones.
    // La clave natural propuesta es (entidad, unidad, codigo).
    // Antes de consultar, validar UNIQUE en actual y correspondencia de los datos.
    // No crea una FK física; colección de solo lectura.
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad", insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad", insertable = false, updatable = false),
            @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Reval> revalorizaciones;

    public List<Reval> getRevalorizaciones() { return revalorizaciones; }

    // Relación histórica candidata: transferencias del activo por entidad, unidad y código.
    // Validar unicidad de (entidad, unidad, codigo) en ACTUAL y correspondencia
    // de registros en TRASFE antes de consultar esta asociación en PostgreSQL.
    // Es de solo lectura y no crea una clave foránea física.
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad", insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad", insertable = false, updatable = false),
            @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Trasfe> transferencias;

    public List<Trasfe> getTransferencias() { return transferencias; }

    // Asociación histórica candidata con BAJAS.DBF.
    // Validar UNIQUE(entidad, unidad, codigo) en ACTUAL antes de consultar.
    // La asociación no crea una clave foránea física.
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumns(value = {
            @JoinColumn(name = "entidad", referencedColumnName = "entidad", insertable = false, updatable = false),
            @JoinColumn(name = "unidad", referencedColumnName = "unidad", insertable = false, updatable = false),
            @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    }, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<Bajas> historialBajas;

    public List<Bajas> getHistorialBajas() { return historialBajas; }

    @Transient
    private String estado;

    public Actual() {}

    // Constructor compatible con el CRUD anterior.
    public Actual(String codigo, String descripcion, String estado) {
        this.codigo = codigo;
        this.descrip = descripcion;
        this.estado = estado;
    }

    // Compatibilidad temporal con ActualService y ActualDTO existentes.
    // Estos métodos no crean columnas adicionales en la tabla.
    public String getDescripcion() { return descrip; }
    public void setDescripcion(String descripcion) { this.descrip = descripcion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUnidad() { return unidad; }
    public void setUnidad(String unidad) { this.unidad = unidad; }

    public String getEntidad() { return entidad; }
    public void setEntidad(String entidad) { this.entidad = entidad; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Codcont getCodcontReferencia() { return codcontReferencia; }
    public void setCodcontReferencia(Codcont codcontReferencia) { this.codcontReferencia = codcontReferencia; }

    public Integer getCodcont() { return codcont; }
    public void setCodcont(Integer codcont) { this.codcont = codcont; }

    public Auxiliar getAuxiliarReferencia() { return auxiliarReferencia; }
    public void setAuxiliarReferencia(Auxiliar auxiliarReferencia) { this.auxiliarReferencia = auxiliarReferencia; }

    public Integer getCodaux() { return codaux; }
    public void setCodaux(Integer codaux) { this.codaux = codaux; }

    public BigDecimal getVidautil() { return vidautil; }
    public void setVidautil(BigDecimal vidautil) { this.vidautil = vidautil; }

    public String getDescrip() { return descrip; }
    public void setDescrip(String descrip) { this.descrip = descrip; }

    public BigDecimal getCosto() { return costo; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }

    public BigDecimal getDepacu() { return depacu; }
    public void setDepacu(BigDecimal depacu) { this.depacu = depacu; }

    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public Boolean getBRev() { return bRev; }
    public void setBRev(Boolean bRev) { this.bRev = bRev; }

    public Integer getDia() { return dia; }
    public void setDia(Integer dia) { this.dia = dia; }

    public Oficina getOficinaReferencia() { return oficinaReferencia; }
    public void setOficinaReferencia(Oficina oficinaReferencia) { this.oficinaReferencia = oficinaReferencia; }

    public Integer getCodofic() { return codofic; }
    public void setCodofic(Integer codofic) { this.codofic = codofic; }

    public Integer getCodresp() { return codresp; }
    public void setCodresp(Integer codresp) { this.codresp = codresp; }

    public String getObserv() { return observ; }
    public void setObserv(String observ) { this.observ = observ; }

    public Integer getDiaAnt() { return diaAnt; }
    public void setDiaAnt(Integer diaAnt) { this.diaAnt = diaAnt; }

    public Integer getMesAnt() { return mesAnt; }
    public void setMesAnt(Integer mesAnt) { this.mesAnt = mesAnt; }

    public Integer getAnoAnt() { return anoAnt; }
    public void setAnoAnt(Integer anoAnt) { this.anoAnt = anoAnt; }

    public Integer getVutAnt() { return vutAnt; }
    public void setVutAnt(Integer vutAnt) { this.vutAnt = vutAnt; }

    public BigDecimal getCostoAnt() { return costoAnt; }
    public void setCostoAnt(BigDecimal costoAnt) { this.costoAnt = costoAnt; }

    public Boolean getBandUfv() { return bandUfv; }
    public void setBandUfv(Boolean bandUfv) { this.bandUfv = bandUfv; }

    public Estado getEstadoReferencia() { return estadoReferencia; }
    public void setEstadoReferencia(Estado estadoReferencia) { this.estadoReferencia = estadoReferencia; }

    public Integer getCodestado() { return codestado; }
    public void setCodestado(Integer codestado) { this.codestado = codestado; }

    public String getCodRube() { return codRube; }
    public void setCodRube(String codRube) { this.codRube = codRube; }

    public String getNroConv() { return nroConv; }
    public void setNroConv(String nroConv) { this.nroConv = nroConv; }

    public String getOrgFin() { return orgFin; }
    public void setOrgFin(String orgFin) { this.orgFin = orgFin; }

    public LocalDate getFeult() { return feult; }
    public void setFeult(LocalDate feult) { this.feult = feult; }

    public String getUsuar() { return usuar; }
    public void setUsuar(String usuar) { this.usuar = usuar; }

    public Integer getApiEstado() { return apiEstado; }
    public void setApiEstado(Integer apiEstado) { this.apiEstado = apiEstado; }

    public String getCodigosec() { return codigosec; }
    public void setCodigosec(String codigosec) { this.codigosec = codigosec; }

    public String getBanderas() { return banderas; }
    public void setBanderas(String banderas) { this.banderas = banderas; }

    public LocalDate getFecMod() { return fecMod; }
    public void setFecMod(LocalDate fecMod) { this.fecMod = fecMod; }

    public String getUsuMod() { return usuMod; }
    public void setUsuMod(String usuMod) { this.usuMod = usuMod; }
    public Resp getResponsableReferencia() { return responsableReferencia; }
    public void setResponsableReferencia(Resp responsableReferencia) { this.responsableReferencia = responsableReferencia; }
}
