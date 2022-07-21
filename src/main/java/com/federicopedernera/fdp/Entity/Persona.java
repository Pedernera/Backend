package com.federicopedernera.fdp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max=50, message = "no cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max=50, message = "no cumple con la longitud")
    private String apellido;
    
    @Size(min = 1, max=500, message = "no cumple con la longitud")
    private String img;
    
    @Size(min = 1, max=500, message = "no cumple con la longitud")
    private String sobreMi;
    
    @Size(min = 1, max=50, message = "no cumple con la longitud")
    private String posicion;

    public Persona(String nombre, String apellido, String img, String sobreMi, String posicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.sobreMi = sobreMi;
        this.posicion = posicion;
    }
    
    public Persona() {
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

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
