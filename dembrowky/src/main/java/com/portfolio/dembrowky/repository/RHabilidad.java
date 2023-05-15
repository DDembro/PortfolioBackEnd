package com.portfolio.dembrowky.repository;

import com.portfolio.dembrowky.entity.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidad extends JpaRepository<Habilidad, Integer>{
    public Optional<Habilidad> findByHabilidad (String habilidad);
    public boolean existsByHabilidad (String habilidad);
}