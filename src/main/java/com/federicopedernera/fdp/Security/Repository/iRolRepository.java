
package com.federicopedernera.fdp.Security.Repository;

import com.federicopedernera.fdp.Security.Entity.Rol;
import com.federicopedernera.fdp.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol,Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
