package com.portfolio.dembrowky.Controllera;

import com.portfolio.dembrowky.dto.DtoProyecto;
import com.portfolio.dembrowky.entity.Proyecto;
import com.portfolio.dembrowky.security.controller.Mensaje;
import com.portfolio.dembrowky.service.SProyecto;
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
@RequestMapping("proyecto")
@CrossOrigin(origins = "https://portfolio-frontend-dembrowky.web.app")
public class CProyecto {
    @Autowired
    
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.List();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> detail(@PathVariable("id") int id) {
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        
        Proyecto educacion = sProyecto.getById(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProyecto) {
        if(StringUtils.isBlank(dtoProyecto.getNombreP()))
            return new ResponseEntity(new Mensaje("El proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sProyecto.existsByNombreP(dtoProyecto.getNombreP()))
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtoProyecto.getNombreP(), dtoProyecto.getFechaP(), dtoProyecto.getDescripcionP(), dtoProyecto.getLinkP());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("proyecto Añadido"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProyecto){
        
        //valida si existe el id
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        //compara la descripcion
        if(sProyecto.existsByNombreP(dtoProyecto.getNombreP()) && sProyecto.getByNombreP(dtoProyecto.getNombreP()).get().getId() != id)
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        // no puede estar vacia
        if(StringUtils.isBlank(dtoProyecto.getNombreP()))
            return new ResponseEntity(new Mensaje("El proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyec = sProyecto.getById(id).get();
        proyec.setNombreP(dtoProyecto.getNombreP());
        proyec.setFechaP(dtoProyecto.getFechaP());
        proyec.setDescripcionP(dtoProyecto.getDescripcionP());
        proyec.setLinkP(dtoProyecto.getLinkP());
        
        sProyecto.save(proyec);
        return new ResponseEntity(new Mensaje("El proyecto fue creado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
         //valida si existe el id
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        sProyecto.delete(id);
        
        return new ResponseEntity(new Mensaje("El proyecto fue eliminado"), HttpStatus.OK);
    }

}