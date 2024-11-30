
package com.example.abarroteria.Servicios;

import com.example.abarroteria.Entidad.EntidadChequeo;
import com.example.abarroteria.Repositorio.RepositorioChequeo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioChequeo {
    
    @Autowired
    RepositorioChequeo rchequeo;
    
    
    public List<EntidadChequeo> obtenerchequeo(){
        return rchequeo.findAll();
    }
    
    public boolean guardarchequeo(EntidadChequeo c){
        boolean respuesta=false;
        try{
            rchequeo.save(c);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean editarchequeo(EntidadChequeo c){
        boolean respuesta=false;
        try{
            rchequeo.save(c);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public boolean eliminarchequeo(EntidadChequeo c){
        boolean respuesta=false;
        try{
            rchequeo.delete(c);
            respuesta=true;
        }catch(Exception error){
            System.out.println("El error es"+error);
            respuesta=false;
        }
        return respuesta;
    }
    
    public EntidadChequeo obtenerchequeoPorId(Integer idregistro) {
    return rchequeo.findById(idregistro).orElse(null);
}
    
}
