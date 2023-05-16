package com.portfolio.dembrowky.controller;

import com.portfolio.dembrowky.dto.DtoEstudio;
import com.portfolio.dembrowky.entity.Estudio;
import com.portfolio.dembrowky.security.controller.Mensaje;
import com.portfolio.dembrowky.service.SEstudio;
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
@RequestMapping("estudio")
@CrossOrigin(origins = "https://portfolio-frontend-dembrowky.web.app")
public class CEstudio {
    
    @Autowired
    
    SEstudio sEstudio;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list() {
        List<Estudio> list = sEstudio.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> detail(@PathVariable("id") int id) {
        if(!sEstudio.existsById(id)){
            return new ResponseEntity(new Mensaje("La educacion no existe"), HttpStatus.NOT_FOUND);
        }
        
        Estudio educacion = sEstudio.getById(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEstudio dtoEstudio) {
        if(StringUtils.isBlank(dtoEstudio.getNombreE()))
            return new ResponseEntity(new Mensaje("El estudio es obligatoria"), HttpStatus.BAD_REQUEST);
        if(sEstudio.existsByNombreE(dtoEstudio.getNombreE()))
            return new ResponseEntity(new Mensaje("El estudio ya existe"), HttpStatus.BAD_REQUEST);
        
        Estudio estudio = new Estudio(dtoEstudio.getNombreE(), dtoEstudio.getFechaE(), dtoEstudio.getTituloE());
        sEstudio.save(estudio);
        
        return new ResponseEntity(new Mensaje("Estudio Añadida"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEstudio dtoEstudio){
        
        //valida si existe el id
        if(!sEstudio.existsById(id))
            return new ResponseEntity(new Mensaje("El estudio no existe"), HttpStatus.BAD_REQUEST);
        //compara la descripcion
        if(sEstudio.existsByNombreE(dtoEstudio.getNombreE()) && sEstudio.getByNombreE(dtoEstudio.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El estudio ya existe"), HttpStatus.BAD_REQUEST);
        // no puede estar vacia
        if(StringUtils.isBlank(dtoEstudio.getNombreE()))
            return new ResponseEntity(new Mensaje("El estudio es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Estudio estu = sEstudio.getById(id).get();
        estu.setNombreE(dtoEstudio.getNombreE());
        estu.setFechaE(dtoEstudio.getFechaE());
        estu.setTituloE(dtoEstudio.getTituloE());
        
        sEstudio.save(estu);
        return new ResponseEntity(new Mensaje("El estudio fue creado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
         //valida si existe el id
        if(!sEstudio.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        sEstudio.delete(id);
        
        return new ResponseEntity(new Mensaje("El estudio fue eliminado"), HttpStatus.OK);
    }
    
}