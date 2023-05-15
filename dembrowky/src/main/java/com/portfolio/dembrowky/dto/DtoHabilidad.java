package com.portfolio.dembrowky.dto;

import javax.validation.constraints.NotBlank;


public class DtoHabilidad {
    @NotBlank
    private String habilidad;
    
    //constructor

    public DtoHabilidad() {
    }

    public DtoHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
    
    //getters y setters

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }
    
    
}
