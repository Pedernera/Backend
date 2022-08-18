package com.federicopedernera.fdp.Controller;

import com.federicopedernera.fdp.Dto.DtoSkill;
import com.federicopedernera.fdp.Entity.Skill;
import com.federicopedernera.fdp.Security.Controller.Mensaje;
import com.federicopedernera.fdp.Service.ImpSkillService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skill")
@CrossOrigin("http://localhost:4200")
public class SkillController {
    @Autowired
    ImpSkillService impSkillService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>>list(){
        List<Skill> list = impSkillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoSkill dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getNomSkill())){
            return new ResponseEntity(new Mensaje("El nombre del skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoSkill.getNivel())){
            return new ResponseEntity(new Mensaje("El nivel del skill es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        
        Skill newSkill = new Skill (dtoSkill.getNomSkill(),dtoSkill.getPorcentaje(),dtoSkill.getNivel(), dtoSkill.getCategoria(), dtoSkill.getColor());
        impSkillService.save(newSkill);
        return new ResponseEntity(new Mensaje("Skill creado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody DtoSkill dtoSkill){
        if(!impSkillService.existById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkill.getNomSkill())){
            return new ResponseEntity(new Mensaje("El nombre del Skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoSkill.getNivel())){
            return new ResponseEntity(new Mensaje("El nivel del skill es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        Skill editSkill = impSkillService.getOne(id).get();
        editSkill.setNomSkill(dtoSkill.getNomSkill());
        editSkill.setNivel(dtoSkill.getNivel());
        editSkill.setPorcentaje(dtoSkill.getPorcentaje());
        editSkill.setCategoria(dtoSkill.getCategoria());
        editSkill.setColor(dtoSkill.getColor());
        impSkillService.save(editSkill);
        return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") int id){
        if(!impSkillService.existById(id)){
             return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        impSkillService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
}
