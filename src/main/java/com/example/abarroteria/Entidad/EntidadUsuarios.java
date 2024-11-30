
package com.example.abarroteria.Entidad;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class EntidadUsuarios {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(name = "idusuario") 
private  Integer idusuario;  
private String rol;
private String nombrec;
private String contra;

    public EntidadUsuarios() {
    }

    public EntidadUsuarios(Integer idusuario, String rol, String nombrec, String contra) {
        this.idusuario = idusuario;
        this.rol = rol;
        this.nombrec = nombrec;
        this.contra = contra;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }



    
    
}
