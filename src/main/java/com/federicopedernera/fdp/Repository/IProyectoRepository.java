package com.federicopedernera.fdp.Repository;

import com.federicopedernera.fdp.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto,Integer>{
    
}
