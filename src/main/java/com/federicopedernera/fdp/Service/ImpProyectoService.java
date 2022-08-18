package com.federicopedernera.fdp.Service;

import com.federicopedernera.fdp.Entity.Proyecto;
import com.federicopedernera.fdp.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoService {
    @Autowired
    IProyectoRepository iProyectoRepository;
    
    public List<Proyecto> list(){
        return iProyectoRepository.findAll();
    }
    
    public Optional<Proyecto>getOne(int id){
        return iProyectoRepository.findById(id);
    }
    
    public void save(Proyecto pro){
        iProyectoRepository.save(pro);
    }
    
    public void delete(int id){
        iProyectoRepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return iProyectoRepository.existsById(id);
    }
}
