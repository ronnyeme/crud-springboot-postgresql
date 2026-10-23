package com.practica.crud.model;

import jakarta.persistence.*;

/** Estructura basada en REPORTS.DBF de vSIAF. */
@Entity
@Table(name = "reports")
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reportname", length = 8)
    private String reportname;

    @Column(name = "contents", length = 50)
    private String contents;

    @Column(name = "modtype", length = 8)
    private String modtype;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name = "cb1", length = 20)
    private String cb1;

    @Column(name = "cb2", length = 20)
    private String cb2;

    @Column(name = "cb3", length = 20)
    private String cb3;

    @Column(name = "cb4", length = 20)
    private String cb4;

    @Column(name = "cb5", length = 20)
    private String cb5;

    @Column(name = "cb6", length = 20)
    private String cb6;

    @Column(name = "cb7", length = 20)
    private String cb7;

    @Column(name = "cb8", length = 20)
    private String cb8;

    @Column(name = "cb9", length = 20)
    private String cb9;

    @Column(name = "cb10", length = 20)
    private String cb10;

    @Column(name = "cb11", length = 20)
    private String cb11;

    @Column(name = "cb12", length = 20)
    private String cb12;

    @Column(name = "cb13", length = 20)
    private String cb13;

    @Column(name = "cb14", length = 20)
    private String cb14;

    @Column(name = "cb15", length = 20)
    private String cb15;

    @Column(name = "cb16", length = 20)
    private String cb16;

    @Column(name = "cb17", length = 20)
    private String cb17;

    @Column(name = "cb18", length = 20)
    private String cb18;

    @Column(name = "cb19", length = 20)
    private String cb19;

    @Column(name = "cb20", length = 20)
    private String cb20;

    @Column(name = "cb21", length = 20)
    private String cb21;

    @Column(name = "cb22", length = 20)
    private String cb22;

    @Column(name = "cb23", length = 20)
    private String cb23;

    @Column(name = "cb24", length = 20)
    private String cb24;

    @Column(name = "cb25", length = 20)
    private String cb25;

    @Column(name = "cb26", length = 20)
    private String cb26;

    @Column(name = "cb27", length = 20)
    private String cb27;

    @Column(name = "cb28", length = 20)
    private String cb28;

    public Reports() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReportname() { return reportname; }
    public void setReportname(String reportname) { this.reportname = reportname; }

    public String getContents() { return contents; }
    public void setContents(String contents) { this.contents = contents; }

    public String getModtype() { return modtype; }
    public void setModtype(String modtype) { this.modtype = modtype; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public String getCb1() { return cb1; }
    public void setCb1(String cb1) { this.cb1 = cb1; }

    public String getCb2() { return cb2; }
    public void setCb2(String cb2) { this.cb2 = cb2; }

    public String getCb3() { return cb3; }
    public void setCb3(String cb3) { this.cb3 = cb3; }

    public String getCb4() { return cb4; }
    public void setCb4(String cb4) { this.cb4 = cb4; }

    public String getCb5() { return cb5; }
    public void setCb5(String cb5) { this.cb5 = cb5; }

    public String getCb6() { return cb6; }
    public void setCb6(String cb6) { this.cb6 = cb6; }

    public String getCb7() { return cb7; }
    public void setCb7(String cb7) { this.cb7 = cb7; }

    public String getCb8() { return cb8; }
    public void setCb8(String cb8) { this.cb8 = cb8; }

    public String getCb9() { return cb9; }
    public void setCb9(String cb9) { this.cb9 = cb9; }

    public String getCb10() { return cb10; }
    public void setCb10(String cb10) { this.cb10 = cb10; }

    public String getCb11() { return cb11; }
    public void setCb11(String cb11) { this.cb11 = cb11; }

    public String getCb12() { return cb12; }
    public void setCb12(String cb12) { this.cb12 = cb12; }

    public String getCb13() { return cb13; }
    public void setCb13(String cb13) { this.cb13 = cb13; }

    public String getCb14() { return cb14; }
    public void setCb14(String cb14) { this.cb14 = cb14; }

    public String getCb15() { return cb15; }
    public void setCb15(String cb15) { this.cb15 = cb15; }

    public String getCb16() { return cb16; }
    public void setCb16(String cb16) { this.cb16 = cb16; }

    public String getCb17() { return cb17; }
    public void setCb17(String cb17) { this.cb17 = cb17; }

    public String getCb18() { return cb18; }
    public void setCb18(String cb18) { this.cb18 = cb18; }

    public String getCb19() { return cb19; }
    public void setCb19(String cb19) { this.cb19 = cb19; }

    public String getCb20() { return cb20; }
    public void setCb20(String cb20) { this.cb20 = cb20; }

    public String getCb21() { return cb21; }
    public void setCb21(String cb21) { this.cb21 = cb21; }

    public String getCb22() { return cb22; }
    public void setCb22(String cb22) { this.cb22 = cb22; }

    public String getCb23() { return cb23; }
    public void setCb23(String cb23) { this.cb23 = cb23; }

    public String getCb24() { return cb24; }
    public void setCb24(String cb24) { this.cb24 = cb24; }

    public String getCb25() { return cb25; }
    public void setCb25(String cb25) { this.cb25 = cb25; }

    public String getCb26() { return cb26; }
    public void setCb26(String cb26) { this.cb26 = cb26; }

    public String getCb27() { return cb27; }
    public void setCb27(String cb27) { this.cb27 = cb27; }

    public String getCb28() { return cb28; }
    public void setCb28(String cb28) { this.cb28 = cb28; }

    // Alias temporales para el ReportsService y ReportsDTO existentes.
    @Transient
    public String getNombre() { return reportname; }
    public void setNombre(String nombre) { this.reportname = nombre; }

    @Transient
    public String getDescripcion() { return contents; }
    public void setDescripcion(String descripcion) { this.contents = descripcion; }

    @Transient
    public String getTipo() { return modtype; }
    public void setTipo(String tipo) { this.modtype = tipo; }
}
