
package com.federicopedernera.fdp.Service;

import com.federicopedernera.fdp.Entity.Experiencia;
import com.federicopedernera.fdp.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService {
    @Autowired
    IExperienciaRepository iExperienciaRepository;
    
    public List<Experiencia> list(){
        return iExperienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return iExperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return iExperienciaRepository.findByNombreExp(nombreExp);
    }
    
    public  void save(Experiencia exp){
        iExperienciaRepository.save(exp);
    }
    
    public void delete(int id){
        iExperienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iExperienciaRepository.existsById(id);
    }
    
    public boolean existByNombreExp(String nombreExp){
        return iExperienciaRepository.existsByNombreExp(nombreExp);
    }
    
    
}
