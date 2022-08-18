package com.federicopedernera.fdp.Controller;

import com.federicopedernera.fdp.Dto.DtoEducacion;
import com.federicopedernera.fdp.Entity.Educacion;
import com.federicopedernera.fdp.Security.Controller.Mensaje;
import com.federicopedernera.fdp.Service.ImpEducacionService;
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
@RequestMapping("edu")
@CrossOrigin("http://localhost:4200")
public class EducacionController {
    
    @Autowired
    ImpEducacionService impEducacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>>list(){
        List<Educacion> list = impEducacionService.list();
        return new  ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public  ResponseEntity<?> create(@RequestBody DtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getTituloEdu())){
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoEdu.getNomInstituto())){
            return new ResponseEntity(new Mensaje("El nombre del instituto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
         
    
        if(impEducacionService.existByTituloEdu(dtoEdu.getTituloEdu())){
            return new ResponseEntity(new Mensaje("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
         if(dtoEdu.getFechaInicioEdu() == null){
            return new ResponseEntity(new Mensaje("La fecha inicial es obligatoria"), HttpStatus.BAD_REQUEST);
        } 
       
        Educacion edu = new Educacion(dtoEdu.getTituloEdu(), dtoEdu.getNomInstituto(), dtoEdu.getFechaInicioEdu(), dtoEdu.getFechaFinalEdu());
        impEducacionService.save(edu);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEdu){
        if(!impEducacionService.existsById(id)){
             return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(impEducacionService.existByTituloEdu(dtoEdu.getTituloEdu()) && impEducacionService.getByTituloEdu(dtoEdu.getTituloEdu()).get().getId() != id){
            return new ResponseEntity(new Mensaje("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
       
       if(StringUtils.isBlank(dtoEdu.getTituloEdu())){
           return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
       }
       
       if(StringUtils.isBlank(dtoEdu.getNomInstituto())){
           return new ResponseEntity(new Mensaje("El nombre del instituto es obligatorio"), HttpStatus.BAD_REQUEST);
       }
       
       Educacion edu = impEducacionService.getOne(id).get();
       edu.setTituloEdu(dtoEdu.getTituloEdu());
       edu.setNomInstituto(dtoEdu.getNomInstituto());
       edu.setFechaInicioEdu(dtoEdu.getFechaInicioEdu());
       edu.setFechaFinalEdu(dtoEdu.getFechaFinalEdu());
       impEducacionService.save(edu);
       return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
       
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") int id){
        if(!impEducacionService.existsById(id)){
             return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        impEducacionService.delete(id);
         return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
}



