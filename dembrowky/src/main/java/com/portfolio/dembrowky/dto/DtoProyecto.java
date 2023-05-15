package com.portfolio.dembrowky.dto;

import javax.validation.constraints.NotBlank;


public class DtoProyecto {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String fechaP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String linkP;
    
    // constructor

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreP, String fechaP, String descripcionP, String linkP) {
        this.nombreP = nombreP;
        this.fechaP = fechaP;
        this.descripcionP = descripcionP;
        this.linkP = linkP;
    }
    
    //getters y setters

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getFechaP() {
        return fechaP;
    }

    public void setFechaP(String fechaP) {
        this.fechaP = fechaP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getLinkP() {
        return linkP;
    }

    public void setLinkP(String linkP) {
        this.linkP = linkP;
    }
    
    
}
