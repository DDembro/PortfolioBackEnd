package com.portfolio.dembrowky.dto;

import javax.validation.constraints.NotBlank;


public class DtoEstudio {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String fechaE;
    @NotBlank
    private String tituloE;
    
    //constructor

    public DtoEstudio() {
    }

    public DtoEstudio(String nombreE, String fechaE, String tituloE) {
        this.nombreE = nombreE;
        this.fechaE = fechaE;
        this.tituloE = tituloE;
    }

    //Getters y Setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getFechaE() {
        return fechaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }
}
