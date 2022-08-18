package com.federicopedernera.fdp.Dto;
import java.util.Date;
import javax.validation.constraints.NotBlank;

public class DtoEducacion {
    @NotBlank
    private String tituloEdu;
    
    @NotBlank
    private String nomInstituto;
    
    @NotBlank
    private Date fechaInicioEdu;
    
    private Date fechaFinalEdu;
    public DtoEducacion() {
    }

    public DtoEducacion(String tituloEdu, String nomInstituto, Date fechaInicioEdu, Date fechaFinalEdu) {
        this.tituloEdu = tituloEdu;
        this.nomInstituto = nomInstituto;
        this.fechaInicioEdu = fechaInicioEdu;
        this.fechaFinalEdu = fechaFinalEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public Date getFechaInicioEdu() {
        return fechaInicioEdu;
    }

    public void setFechaInicioEdu(Date fechaInicioEdu) {
        this.fechaInicioEdu = fechaInicioEdu;
    }

    public Date getFechaFinalEdu() {
        return fechaFinalEdu;
    }

    public void setFechafinalEdu(Date fechaFinalEdu) {
        this.fechaFinalEdu = fechaFinalEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getNomInstituto() {
        return nomInstituto;
    }

    public void setNomInstituto(String nomInstituto) {
        this.nomInstituto = nomInstituto;
    }
    
    
    
    
}
