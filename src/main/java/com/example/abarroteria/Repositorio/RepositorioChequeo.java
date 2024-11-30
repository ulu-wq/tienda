
package com.example.abarroteria.Repositorio;

import com.example.abarroteria.Entidad.EntidadChequeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioChequeo extends JpaRepository<EntidadChequeo, Integer> {
    
}
