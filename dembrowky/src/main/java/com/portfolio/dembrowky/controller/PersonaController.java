package com.portfolio.dembrowky.Controller;

import com.portfolio.dembrowky.dto.DtoPersona;
import com.portfolio.dembrowky.entity.Persona;
import com.portfolio.dembrowky.security.controller.Mensaje;
import com.portfolio.dembrowky.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-frontend-dembrowky.web.app")
public class PersonaController {
    
    @Autowired
    private IPersonaService iPersonaService;
    
    
    @GetMapping ("/persona/ver")
    @ResponseBody
    public List<Persona> verPersonas() {
       return iPersonaService.verPersonas();
    }
    
    @GetMapping ("/persona/conseguir/{id}")
    public Persona buscarPersona(@PathVariable Long id) {
       return iPersonaService.buscarPersona(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/persona/crear")
    public void agregarPersona (@RequestBody Persona pers) {
        iPersonaService.crearPersona( pers);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/persona/borrar/{id}")
    public void borrarPersona (@PathVariable Long id) {
        iPersonaService.borrarPersona(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/persona/editar")
    public ResponseEntity<?> editPersona(@RequestBody DtoPersona dtoPerso) 
        {

            Persona persona = iPersonaService.buscarPersona(1l);
            
            persona.setNombre(dtoPerso.getNombre());
            persona.setApellido(dtoPerso.getApellido());
            persona.setDescripcion(dtoPerso.getDescripcion());
            persona.setFotoPerfil(dtoPerso.getFotoPerfil());
            persona.setAcercaDe(dtoPerso.getAcercaDe());

            iPersonaService.crearPersona(persona);
            return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
        }
}