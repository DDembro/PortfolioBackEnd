package com.portfolio.dembrowky.service;

import com.portfolio.dembrowky.entity.Habilidad;
import com.portfolio.dembrowky.repository.RHabilidad;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHabilidad {
    @Autowired
    RHabilidad rHabilidad;
    
    public List<Habilidad> List() {
        return rHabilidad.findAll();
    }
    
    public Optional<Habilidad> getById(int id) {
        return rHabilidad.findById(id);
    }
    
    public Optional<Habilidad> getByHabilidad(String habilidad) {
        return rHabilidad.findByHabilidad(habilidad);
    }
    
    public void save(Habilidad habilidad) {
        rHabilidad.save(habilidad);
    }
    
    public void delete(int id) {
        rHabilidad.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHabilidad.existsById(id);
    }
    
    public boolean existsByHabilidad(String nombreE){
        return rHabilidad.existsByHabilidad(nombreE);
    }
}
