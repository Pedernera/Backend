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
public class DtoPersona {
     @NotBlank
     private String nombre;
     @NotBlank
     private String apellido;
     @NotBlank
     private String img;
     
     @NotBlank
     private String sobreMi;
     
     @NotBlank
     private String posicion;
    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String img, String sobreMi, String posicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.sobreMi = sobreMi;
        this.posicion = posicion;
    }

    public String getSobreMi() {
        return sobreMi;
    }

    public void setSobreMi(String sobreMi) {
        this.sobreMi = sobreMi;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
     
     
}
