
package com.federicopedernera.fdp.Dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;


public class DtoExperiencia {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private Date fechaInicioExp;
    
    private Date fechaFinalExp;
    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExp, String descripcionExp, Date fechaInicioExp, Date fechaFinalExp) {
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
