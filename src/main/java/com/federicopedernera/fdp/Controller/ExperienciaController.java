
package com.federicopedernera.fdp.Controller;

import com.federicopedernera.fdp.Dto.DtoExperiencia;
import com.federicopedernera.fdp.Entity.Experiencia;
import com.federicopedernera.fdp.Security.Controller.Mensaje;
import com.federicopedernera.fdp.Service.ImpExperienciaService;
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
@RequestMapping("explab")
@CrossOrigin("http://localhost:4200")
public class ExperienciaController {
    @Autowired
    ImpExperienciaService impExperienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>>list(){
        List<Experiencia> list = impExperienciaService.list();
        return new  ResponseEntity(list, HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = impExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public  ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreExp())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
         if(StringUtils.isBlank(dtoExp.getDescripcionExp())){
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(impExperienciaService.existByNombreExp(dtoExp.getNombreExp())){
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(dtoExp.getNombreExp(), dtoExp.getDescripcionExp());
        impExperienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExp){
        if(!impExperienciaService.existsById(id)){
             return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(impExperienciaService.existByNombreExp(dtoExp.getNombreExp()) && impExperienciaService.getByNombreExp(dtoExp.getNombreExp()).get().getId() != id){
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
       
       if(StringUtils.isBlank(dtoExp.getNombreExp())){
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       }
       
       if(StringUtils.isBlank(dtoExp.getDescripcionExp())){
           return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);
       }
       Experiencia exp = impExperienciaService.getOne(id).get();
       exp.setNombreExp(dtoExp.getNombreExp());
       exp.setDescripcionExp(dtoExp.getDescripcionExp());
       impExperienciaService.save(exp);
       return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
       
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") int id){
        if(!impExperienciaService.existsById(id)){
             return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        impExperienciaService.delete(id);
         return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
