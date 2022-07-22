/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author hueck
 */
public class ClsEleccion {
    
    private String idEleccion;
    private String descripcion;
    private String categoria;
    private String estado;
    private String ganador;
    private String fechaInicio;
    private String fechaFin;

    public ClsEleccion(String idEleccion, String descripcion, String categoria, String estado, String ganador, String fechaInicio, String fechaFin) {
        this.idEleccion = idEleccion;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.ganador = ganador;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    public String getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(String idEleccion) {
        this.idEleccion = idEleccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    

}
