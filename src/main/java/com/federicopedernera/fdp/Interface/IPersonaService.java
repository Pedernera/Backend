
package com.federicopedernera.fdp.Interface;

import com.federicopedernera.fdp.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Traer una lista de personas
    
    public List<Persona> getPersona();
    
    //Guardar una persona
    
    public void savePersona(Persona persona);
    
    //Eliminar una persona
    
    public void deletePersona(Long id);
    
    //Buscar una persona por id
    
    public Persona findPersona(Long id);
}
