/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.federicopedernera.fdp.Dto;

/**
 *
 * @author Mauricio
 */
public class DtoEmail {
    private String emisor;
    private String mensaje;

    public DtoEmail(String emisor, String mensaje) {
        this.emisor = emisor;
        this.mensaje = mensaje;
    }

    public DtoEmail() {
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
