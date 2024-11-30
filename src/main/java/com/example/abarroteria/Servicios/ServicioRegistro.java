
package com.example.abarroteria.Servicios;

import com.example.abarroteria.Entidad.EntidadRegistro;
import com.example.abarroteria.Repositorio.RepositorioRegistro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioRegistro {
    
    @Autowired 
    RepositorioRegistro rregistro;
    
    public List<EntidadRegistro> obtenerRegistro(){
        return rregistro.findAll();
    }
    
    public boolean guardarregistro(EntidadRegistro r){
        boolean respuesta=false;
        try{
            rregistro.save(r);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean editarchequeo(EntidadRegistro r){
        boolean respuesta=false;
        try{
            rregistro.save(r);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean eliminarregistro(EntidadRegistro r){
        boolean respuesta=false;
        try{
            rregistro.delete(r);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
}
