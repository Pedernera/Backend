
package com.federicopedernera.fdp.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String tituloEdu;
    @NotNull
    private String nomInstituto;
    
    @NotNull
    private Date fechaInicioEdu;
    
    private Date fechaFinalEdu;
    public Educacion() {
    }

    public Educacion(String tituloEdu, String nomInstituto, Date fechaInicioEdu, Date fechaFinalEdu) {
        this.tituloEdu = tituloEdu;
        this.nomInstituto = nomInstituto;
        this.fechaInicioEdu = fechaInicioEdu;
        this.fechaFinalEdu = fechaFinalEdu;
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

    public void setFechaFinalEdu(Date fechaFinalEdu) {
        this.fechaFinalEdu = fechaFinalEdu;
    }

 

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloEdu() {
        return tituloEdu;
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
