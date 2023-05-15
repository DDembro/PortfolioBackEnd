package com.portfolio.dembrowky.controller;

import com.portfolio.dembrowky.dto.DtoHabilidad;
import com.portfolio.dembrowky.entity.Habilidad;
import com.portfolio.dembrowky.security.controller.Mensaje;
import com.portfolio.dembrowky.service.SHabilidad;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("habilidad")
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidad {
    @Autowired
    
    SHabilidad sHabilidad;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidad>> list() {
        List<Habilidad> list = sHabilidad.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> detail(@PathVariable("id") int id) {
        if(!sHabilidad.existsById(id)){
            return new ResponseEntity(new Mensaje("La habilidad no existe"), HttpStatus.NOT_FOUND);
        }
        
        Habilidad habilidad = sHabilidad.getById(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHabilidad dtoHabilidad) {
        if(StringUtils.isBlank(dtoHabilidad.getHabilidad()))
            return new ResponseEntity(new Mensaje("habilidad es obligatoria"), HttpStatus.BAD_REQUEST);
        if(sHabilidad.existsByHabilidad(dtoHabilidad.getHabilidad()))
            return new ResponseEntity(new Mensaje("habilidad ya existe"), HttpStatus.BAD_REQUEST);
        
        Habilidad habilidad = new Habilidad(dtoHabilidad.getHabilidad());
        sHabilidad.save(habilidad);
        
        return new ResponseEntity(new Mensaje("habilidad Añadida"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHabilidad dtoHabilidad){
        
        //valida si existe el id
        if(!sHabilidad.existsById(id))
            return new ResponseEntity(new Mensaje("habilidad no existe"), HttpStatus.BAD_REQUEST);
        //compara la descripcion
        if(sHabilidad.existsByHabilidad(dtoHabilidad.getHabilidad()) && sHabilidad.getByHabilidad(dtoHabilidad.getHabilidad()).get().getId() != id)
            return new ResponseEntity(new Mensaje("habilidad ya existe"), HttpStatus.BAD_REQUEST);
        // no puede estar vacia
        if(StringUtils.isBlank(dtoHabilidad.getHabilidad()))
            return new ResponseEntity(new Mensaje("habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Habilidad hab = sHabilidad.getById(id).get();
        hab.setHabilidad(dtoHabilidad.getHabilidad());
        
        sHabilidad.save(hab);
        return new ResponseEntity(new Mensaje("habilidad fue creada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
         //valida si existe el id
        if(!sHabilidad.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        sHabilidad.delete(id);
        
        return new ResponseEntity(new Mensaje("habilidad fue eliminada"), HttpStatus.OK);
    }
}
