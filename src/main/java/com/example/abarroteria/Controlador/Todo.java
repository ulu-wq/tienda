
package com.example.abarroteria.Controlador;

import com.example.abarroteria.Entidad.EntidadChequeo;
import com.example.abarroteria.Entidad.EntidadRegistro;
import com.example.abarroteria.Entidad.EntidadUsuarios;
import com.example.abarroteria.Repositorio.RepositorioUsuarios;
import com.example.abarroteria.Servicios.ServicioChequeo;
import com.example.abarroteria.Servicios.ServicioRegistro;
import com.example.abarroteria.Servicios.ServicioUsuarios;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abarrotes")
public class Todo {
   
    @Autowired
    ServicioChequeo schequeo;
    
    @Autowired
    ServicioRegistro sregistro;
    
    @Autowired
    ServicioUsuarios susuarios;
    
    
    @Autowired
    RepositorioUsuarios rusuarios;
    
    
    @GetMapping("/abarroteslista")
    public List<EntidadUsuarios> mostrarusuarios(){
        return susuarios.obtenerusuarios();
        
    }
    
    
      // endpoint iniciar sesion 
    
 @PostMapping("/iniciosesion")
public ResponseEntity<Map<String, String>> login(@RequestBody EntidadUsuarios loginRequest){
    EntidadUsuarios usuario = rusuarios.findByNombrecAndContra(loginRequest.getNombrec(), loginRequest.getContra());
    if (usuario != null) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Inicio de sesión correcta");
        response.put("usuario", usuario.getNombrec());
        return ResponseEntity.ok(response);
    } else {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Usuario y/o contraseña incorrectos");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
    
@PostMapping("/guardarusuarios")
public List<EntidadUsuarios> guardarusuario(@RequestParam(required = false) Integer idusuario, 
                                             @RequestParam String rol, 
                                             @RequestParam String nombrec, 
                                             @RequestParam String contra) {
    EntidadUsuarios u = new EntidadUsuarios();
    
    // Verificar si idusuario no es nulo antes de asignarlo
    if (idusuario != null) {
        u.setIdusuario(idusuario);
    }

    u.setRol(rol);
    u.setNombrec(nombrec);
    u.setContra(contra);
    
    if (susuarios.guardarusuarios(u)) {
        return susuarios.obtenerusuarios();
    }
    return null;
}

    
    @PutMapping("/editarusuarios")
public ResponseEntity<?> editarUsuario(@RequestBody EntidadUsuarios usuario) {
    try {
        // Intenta editar el usuario
        boolean exito = susuarios.editarusuarios(usuario);
        if (exito) {
            // Si la edición es exitosa, devuelve la lista actualizada de usuarios
            List<EntidadUsuarios> usuariosActualizados = susuarios.obtenerusuarios();
            return ResponseEntity.ok(usuariosActualizados);
        } else {
            // Si la edición falla, devuelve un mensaje de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo editar el usuario.");
        }
    } catch (Exception e) {
        // Maneja otros errores
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocurrió un error al editar el usuario.");
    }
}
    
@DeleteMapping("/eliminarusuarios")
    public List<EntidadUsuarios> eliminarusuario(int idusuario){
       EntidadUsuarios u = new EntidadUsuarios();
        u.setIdusuario(idusuario);
        
        
        if(susuarios.eliminarusuarios(u)){
            return susuarios.obtenerusuarios();
        }
        return null;
    }

    //va entidad registro
    @GetMapping("/empleado")
    public List<EntidadRegistro> mostrarEmpleado(){
        return sregistro.obtenerRegistro();
    }
    
     @PostMapping("/guardarempleado")
    public List<EntidadRegistro> guardaralumnos(Integer idempleado, int numeroid, String nombre, int edad, String apellido, String direccion,  String fecha) {
    EntidadRegistro r = new EntidadRegistro();
    r.setIdempleado(idempleado);
    r.setNumeroid(numeroid);
    r.setNombre(nombre);
    r.setEdad(edad);
    r.setApellido(apellido);
    r.setDireccion(direccion);
    
    
   

    SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyy-MM-dd");
    try {
        r.setFecha(formatoOriginal.parse(fecha)); // Convertir la fecha de String a Date
    } catch (ParseException e) {
        e.printStackTrace();
        return null; // Manejar el error según tu lógica
    }

    if (sregistro.guardarregistro(r)) {
        return sregistro.obtenerRegistro();
    }
    return null;
}
    
  @PutMapping("/editarempleado")
public List<EntidadRegistro> editarralumnos(@RequestBody EntidadRegistro resgistro) {
    try {
        // Aquí puedes validar y procesar el objeto 'alumno' recibido desde el frontend
        if(sregistro.editarchequeo(resgistro)) {
            return sregistro.obtenerRegistro();
        }
    } catch (Exception error) {
        System.out.println("Error al editar el alumno: " + error.getMessage());
    }
    return null;
}   
    
   
 @DeleteMapping("/eliminarempleado")
    public List<EntidadRegistro> eliminaralumnos(Integer idempleado){
        EntidadRegistro r = new EntidadRegistro();
       r.setIdempleado(idempleado);
      
        if(sregistro.eliminarregistro(r)){
            return sregistro.obtenerRegistro();
        }
        return null;
    }
    
    // horas de trabajo
    @GetMapping("/mostrarregistroslista")
    public List<EntidadChequeo> mostrarRegistros(){
        return schequeo.obtenerchequeo();
    }

    
     @PostMapping("/entrada")
    public ResponseEntity<String> guardarChequeo(@RequestBody EntidadChequeo nuevoChequeo) {
        boolean guardado = schequeo.guardarchequeo(nuevoChequeo);
        if (guardado) {
            return ResponseEntity.ok("Chequeo guardado exitosamente.");
        } else {
            return ResponseEntity.badRequest().body("Error al guardar el chequeo.");
        }
    }
    
    @PutMapping("/{idregistro}")
    public ResponseEntity<String> editarChequeo(
            @PathVariable Integer idregistro,
            @RequestBody EntidadChequeo chequeoActualizado) {

        EntidadChequeo chequeoExistente = schequeo.obtenerchequeoPorId(idregistro);
        if (chequeoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        chequeoExistente.setAreatra(chequeoActualizado.getAreatra());
        chequeoExistente.setIdempleado(chequeoActualizado.getIdempleado());
        chequeoExistente.setHora_entrada(chequeoActualizado.getHora_entrada());
        chequeoExistente.setHora_salida(chequeoActualizado.getHora_salida());
        chequeoExistente.setFecha(chequeoActualizado.getFecha());

        boolean actualizado = schequeo.editarchequeo(chequeoExistente);
        if (actualizado) {
            return ResponseEntity.ok("Chequeo actualizado exitosamente.");
        } else {
            return ResponseEntity.badRequest().body("Error al actualizar el chequeo.");
        }
    }
    
    @DeleteMapping("/eliminarregistro")
    public List<EntidadRegistro> eliminarchequeo(Integer idempleado){
        EntidadRegistro r = new EntidadRegistro();
       r.setIdempleado(idempleado);
      
        if(sregistro.eliminarregistro(r)){
            return sregistro.obtenerRegistro();
        }
        return null;
    }
    
}
