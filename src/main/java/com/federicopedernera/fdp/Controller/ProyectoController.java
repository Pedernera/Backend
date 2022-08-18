package com.federicopedernera.fdp.Controller;

import com.federicopedernera.fdp.Dto.DtoProyecto;
import com.federicopedernera.fdp.Entity.Proyecto;
import com.federicopedernera.fdp.Security.Controller.Mensaje;
import com.federicopedernera.fdp.Service.ImpProyectoService;
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
@RequestMapping("proyectos")
@CrossOrigin("http://localhost:4200")
public class ProyectoController {
    @Autowired
    ImpProyectoService impProyectoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>>list(){
        List<Proyecto> list = impProyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoProyecto dtoPro){
        if(StringUtils.isBlank(dtoPro.getNomProyecto())){
            return new ResponseEntity(new Mensaje("El nombre del Proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPro.getDescripcionPro())){
            return new ResponseEntity(new Mensaje("La descripcion del Proyecto es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPro.getImgProyecto())){
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPro.getLinkGithub())){
            return new ResponseEntity(new Mensaje("El proyecto debe tener un link de github"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto pro = new Proyecto(dtoPro.getNomProyecto(), dtoPro.getDescripcionPro(), dtoPro.getImgProyecto(),dtoPro.getUrlImg() ,dtoPro.getLinkGithub(),dtoPro.getLinkLive());
        impProyectoService.save(pro);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoPro){
        if(!impProyectoService.existById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPro.getNomProyecto())){
            return new ResponseEntity(new Mensaje("El nombre del Proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPro.getDescripcionPro())){
            return new ResponseEntity(new Mensaje("La descripcion del Proyecto es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPro.getImgProyecto())){
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoPro.getLinkGithub())){
            return new ResponseEntity(new Mensaje("El proyecto debe tener un link de github"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto pro = impProyectoService.getOne(id).get();
        pro.setNomProyecto(dtoPro.getNomProyecto());
        pro.setDescripcionPro(dtoPro.getDescripcionPro());
        pro.setImgProyecto(dtoPro.getImgProyecto());
        pro.setUrlImg(dtoPro.getUrlImg());
        pro.setLinkLive(dtoPro.getLinkLive());
        pro.setLinkGithub(dtoPro.getLinkGithub());
        impProyectoService.save(pro);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") int id){
        if(!impProyectoService.existById(id)){
             return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        
        impProyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
    }
}
