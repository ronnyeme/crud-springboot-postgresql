package com.practica.crud.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/** Tabla BACKUPS.DBF de vSIAF: historial de respaldos. */
@Entity
@Table(name = "backups")
public class Backups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dia")
    private LocalDate dia;

    @Column(name = "hora", length = 8)
    private String hora;

    @Column(name = "archivo", length = 12)
    private String archivo;

    @Column(name = "observ", columnDefinition = "TEXT")
    private String observ;

    @Column(name = "usuar", length = 8)
    private String usuar;

    @Column(name = "feult")
    private LocalDate feult;

    public Backups() {}

    // Métodos de compatibilidad para el servicio anterior.
    // No son columnas persistentes; deben sustituirse al actualizar el DTO/servicio.
    @Transient
    public String getNombre() { return archivo; }
    public void setNombre(String nombre) { this.archivo = nombre; }

    @Transient
    public String getUbicacion() { return observ; }
    public void setUbicacion(String ubicacion) { this.observ = ubicacion; }

    @Transient
    public String getFecha() { return dia == null ? null : dia.toString(); }
    public void setFecha(String fecha) {
        this.dia = (fecha == null || fecha.isBlank()) ? null : LocalDate.parse(fecha);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDia() { return dia; }
    public void setDia(LocalDate dia) { this.dia = dia; }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    public String getArchivo() { return archivo; }
    public void setArchivo(String archivo) { this.archivo = archivo; }
    public String getObserv() { return observ; }
    public void setObserv(String observ) { this.observ = observ; }
    public String getUsuar() { return usuar; }
    public void setUsuar(String usuar) { this.usuar = usuar; }
    public LocalDate getFeult() { return feult; }
    public void setFeult(LocalDate feult) { this.feult = feult; }
}
