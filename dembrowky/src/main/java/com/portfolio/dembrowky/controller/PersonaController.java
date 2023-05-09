package com.portfolio.dembrowky.Controller;

import com.portfolio.dembrowky.entity.Persona;
import com.portfolio.dembrowky.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
    @PutMapping ("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido
                               ) 
        {

            Persona persona = iPersonaService.buscarPersona(id);
            
            persona.setNombre(nuevoNombre);
            persona.setApellido(nuevoApellido);

            iPersonaService.crearPersona(persona);
            return persona;
        }
}