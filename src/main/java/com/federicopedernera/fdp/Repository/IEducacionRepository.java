package com.federicopedernera.fdp.Repository;

import com.federicopedernera.fdp.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByTituloEdu(String tituloEdu);
    public boolean existsByTituloEdu(String tituloEdu);
}
