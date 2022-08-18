package com.federicopedernera.fdp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotNull
    private String nomProyecto;
    @NotNull
    private String descripcionPro;
    @NotNull
    private String imgProyecto;
    @NotNull
    private String urlImg;
    @NotNull
    private String linkGithub;
    private String linkLive;

    public Proyecto(String nomProyecto, String descripcionPro, String imgProyecto, String urlImg, String linkGithub, String linkLive) {
        this.nomProyecto = nomProyecto;
        this.descripcionPro = descripcionPro;
        this.imgProyecto = imgProyecto;
        this.urlImg = urlImg;
        this.linkGithub = linkGithub;
        this.linkLive = linkLive;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

   

    public Proyecto() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNomProyecto() {
        return nomProyecto;
    }

    public void setNomProyecto(String nomProyecto) {
        this.nomProyecto = nomProyecto;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public String getImgProyecto() {
        return imgProyecto;
    }

    public void setImgProyecto(String imgProyecto) {
        this.imgProyecto = imgProyecto;
    }

    public String getLinkGithub() {
        return linkGithub;
    }

    public void setLinkGithub(String linkGithub) {
        this.linkGithub = linkGithub;
    }

    public String getLinkLive() {
        return linkLive;
    }

    public void setLinkLive(String linkLive) {
        this.linkLive = linkLive;
    }
    
    
}
