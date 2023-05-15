package com.portfolio.dembrowky.repository;

import com.portfolio.dembrowky.entity.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REstudio extends JpaRepository<Estudio, Integer> {
    public Optional<Estudio> findByNombreE (String nombreE);
    public boolean existsByNombreE (String nombreE);
}
