package com.portfolio.dembrowky.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity

public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String nombre;
    private String apellido;
    private String descripcion;
    private String fotoPerfil;
    private String acercaDe;
 
    public Persona() {
    }
    
    public Persona(Long id, String nombre, String apellido, String descripcion, String fotoPerfil, String acercaDe) {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.apellido = fotoPerfil;
        this.acercaDe = acercaDe;
        
    }
}
