
package com.example.abarroteria.Repositorio;

import com.example.abarroteria.Entidad.EntidadRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRegistro extends JpaRepository<EntidadRegistro, Integer> {
    
}
