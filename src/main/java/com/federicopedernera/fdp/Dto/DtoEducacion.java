/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.federicopedernera.fdp.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Mauricio
 */
public class DtoEducacion {
    @NotBlank
    private String tituloEdu;
    
    @NotBlank
    private String nomInstituto;

    public DtoEducacion() {
    }

    public DtoEducacion(String tituloEdu, String nomInstituto) {
        this.tituloEdu = tituloEdu;
        this.nomInstituto = nomInstituto;
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
