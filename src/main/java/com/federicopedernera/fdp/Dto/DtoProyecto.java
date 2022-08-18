package com.federicopedernera.fdp.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {
    @NotBlank
    private String nomProyecto;
    @NotBlank
    private String descripcionPro;
    @NotBlank
    private String imgProyecto;
    @NotBlank
    private String urlImg;
    @NotBlank
    private String linkGithub;
    private String linkLive;

    public DtoProyecto() {
    }

    public DtoProyecto(String nomProyecto, String descripcionPro, String imgProyecto, String urlImg, String linkGithub, String linkLive) {
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
