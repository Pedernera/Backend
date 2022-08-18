package com.federicopedernera.fdp.Service;

import com.federicopedernera.fdp.Entity.Skill;
import com.federicopedernera.fdp.Repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpSkillService {
    @Autowired
    ISkillRepository iSkillRepository;
      public List<Skill> list(){
        return iSkillRepository.findAll();
    }
    
    public Optional<Skill>getOne(int id){
        return iSkillRepository.findById(id);
    }
    
    public void save(Skill skill){
        iSkillRepository.save(skill);
    }
    
    public void delete(int id){
        iSkillRepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return iSkillRepository.existsById(id);
    }
}
