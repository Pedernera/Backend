package com.federicopedernera.fdp.Repository;

import com.federicopedernera.fdp.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Integer>{
    
}
