
package com.example.abarroteria.Entidad;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="registro")
public class EntidadRegistro {
  
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(name = "idempleado") 
private  Integer idempleado;     
private Integer numeroid;
private String nombre;
private Integer edad;
private String apellido;
private String direccion;
@Column(name = "fecha", columnDefinition = "TIMESTAMP(6)")
private Date fecha;

    public EntidadRegistro() {
    }

    public EntidadRegistro(Integer idempleado, Integer numeroid, String nombre, Integer edad, String apellido, String direccion, Date fecha) {
        this.idempleado = idempleado;
        this.numeroid = numeroid;
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fecha = fecha;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Integer getNumeroid() {
        return numeroid;
    }

    public void setNumeroid(Integer numeroid) {
        this.numeroid = numeroid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   


    
}
