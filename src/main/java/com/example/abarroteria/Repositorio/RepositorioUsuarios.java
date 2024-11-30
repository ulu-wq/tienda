
package com.example.abarroteria.Repositorio;

import com.example.abarroteria.Entidad.EntidadUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarios extends JpaRepository <EntidadUsuarios, Integer> {

EntidadUsuarios findByNombrecAndContra(String nombrec, String contra);
   
}
