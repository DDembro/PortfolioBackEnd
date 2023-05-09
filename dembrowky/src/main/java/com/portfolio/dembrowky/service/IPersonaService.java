package com.portfolio.dembrowky.service;

import com.portfolio.dembrowky.entity.Persona;
import java.util.List;

public interface IPersonaService {
    // Traer lista de personas
    public List<Persona> verPersonas();
    
    // Guardar una persona
    public void crearPersona (Persona per); 
    
    // Eliminar por id una persona
    public void borrarPersona (Long id);
    
    // Buscar una persona por id
    public Persona buscarPersona (Long id);
}
