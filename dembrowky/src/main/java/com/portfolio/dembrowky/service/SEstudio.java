package com.portfolio.dembrowky.service;

import com.portfolio.dembrowky.entity.Estudio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.dembrowky.repository.REstudio;


@Service
@Transactional
public class SEstudio {
    @Autowired
    REstudio rEstudio;
    
    public List<Estudio> List() {
        return rEstudio.findAll();
    }
    
    public Optional<Estudio> getById(int id) {
        return rEstudio.findById(id);
    }
    
    public Optional<Estudio> getByNombreE(String nombreE) {
        return rEstudio.findByNombreE(nombreE);
    }
    
    public void save(Estudio estudio) {
        rEstudio.save(estudio);
    }
    
    public void delete(int id) {
        rEstudio.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEstudio.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rEstudio.existsByNombreE(nombreE);
    }
}
