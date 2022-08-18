package com.federicopedernera.fdp.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSkill {
    @NotBlank
    private String nomSkill;
    @NotBlank
    private String nivel;
    private int porcentaje;
    @NotBlank
    private String categoria;
    
    private String color;
    public DtoSkill() {
    }

    public DtoSkill(String nomSkill, int porcentaje,String nivel, String categoria, String color) {
        this.nomSkill = nomSkill;
        this.nivel = nivel;
        this.porcentaje = porcentaje;
        this.categoria = categoria;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    

    public String getNomSkill() {
        return nomSkill;
    }

    public void setNomSkill(String nomSkill) {
        this.nomSkill = nomSkill;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
