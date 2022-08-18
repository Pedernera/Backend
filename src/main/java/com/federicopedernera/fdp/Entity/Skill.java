package com.federicopedernera.fdp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nomSkill;
    
    private int porcentaje;

    @NotNull
    private String nivel;
    
    @NotNull
    private String categoria;
    
    private String color;
    public Skill(String nomSkill, int porcentaje, String nivel, String categoria, String color) {
        this.nomSkill = nomSkill;
        this.porcentaje = porcentaje;
        this.nivel = nivel;
        this.categoria = categoria;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomSkill() {
        return nomSkill;
    }

    public void setNomSkill(String nomSkill) {
        this.nomSkill = nomSkill;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
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
    

    public Skill() {
    }

    public Skill(int id, String nomSkill, int porcentaje, String nivel, String categoria) {
        this.id = id;
        this.nomSkill = nomSkill;
        this.porcentaje = porcentaje;
        this.nivel = nivel;
        this.categoria = categoria;
    }
}
