
package com.example.abarroteria.Servicios;

import com.example.abarroteria.Entidad.EntidadUsuarios;
import com.example.abarroteria.Repositorio.RepositorioUsuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuarios {
    
    @Autowired
    RepositorioUsuarios rusuarios;
    
    public List<EntidadUsuarios> obtenerusuarios(){
        return rusuarios.findAll();
    }
    
    public boolean guardarusuarios(EntidadUsuarios u){
        boolean respuesta=false;
        try{
            rusuarios.save(u);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean editarusuarios(EntidadUsuarios u){
        boolean respuesta=false;
        try{
            rusuarios.save(u);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean eliminarusuarios(EntidadUsuarios u){
        boolean respuesta=false;
        try{
            rusuarios.delete(u);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    
}
