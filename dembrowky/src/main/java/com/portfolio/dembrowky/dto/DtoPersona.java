package com.portfolio.dembrowky.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoPersona {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descripcion;    
    @NotBlank
    private String fotoPerfil;
    @NotBlank
    private String acercaDe;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String descripcion, String fotoPerfil, String acercaDe) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.fotoPerfil = fotoPerfil;
        this.acercaDe = acercaDe;
    }
}