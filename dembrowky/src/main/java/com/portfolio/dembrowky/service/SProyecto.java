package com.portfolio.dembrowky.service;

import com.portfolio.dembrowky.entity.Proyecto;
import com.portfolio.dembrowky.repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    @Autowired
    RProyecto rProyecto;
    
    public List<Proyecto> List() {
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getById(int id) {
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombreP(String nombreP) {
        return rProyecto.findByNombreP(nombreP);
    }
    
    public void save(Proyecto proyecto) {
        rProyecto.save(proyecto);
    }
    
    public void delete(int id) {
        rProyecto.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyecto.existsById(id);
    }
    
    public boolean existsByNombreP(String nombreP){
        return rProyecto.existsByNombreP(nombreP);
    }
}
