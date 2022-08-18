
package com.federicopedernera.fdp.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombreExp;
    @NotNull
    private String descripcionExp;
    @NotNull
    private Date fechaInicioExp;
    
    private Date fechaFinalExp;
    public Experiencia() {
    }

    public Experiencia(String nombreExp, String descripcionExp, Date fechaInicioExp, Date fechaFinalExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.fechaInicioExp = fechaInicioExp;
        this.fechaFinalExp = fechaFinalExp;
    }

    public Date getFechaInicioExp() {
        return fechaInicioExp;
    }

    public void setFechaInicioExp(Date fechaInicioExp) {
        this.fechaInicioExp = fechaInicioExp;
    }

    public Date getFechaFinalExp() {
        return fechaFinalExp;
    }

    public void setFechaFinalExp(Date fechaFinalExp) {
        this.fechaFinalExp = fechaFinalExp;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }
}
