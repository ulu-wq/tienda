
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
@Table(name="chequeo")
public class EntidadChequeo {
    
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistro") 
   private  Integer idregistro;
   private String areatra;
   private Integer idempleado;
   private LocalTime hora_entrada;
   private LocalTime hora_salida;
   private Date fecha; 

    public EntidadChequeo() {
    }

    public EntidadChequeo(Integer idregistro, String areatra, Integer idempleado, LocalTime hora_entrada, LocalTime hora_salida, Date fecha) {
        this.idregistro = idregistro;
        this.areatra = areatra;
        this.idempleado = idempleado;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.fecha = fecha;
    }

    public Integer getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public String getAreatra() {
        return areatra;
    }

    public void setAreatra(String areatra) {
        this.areatra = areatra;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public LocalTime getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(LocalTime hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
   
   
   
   
    
}
