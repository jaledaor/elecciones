/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jairo.davila
 */
public class ClsCandidatoEleccion {
    
    private String id_candidato;
    private String id_eleccion;

    public ClsCandidatoEleccion(String id_candidato, String id_eleccion) {
        this.id_candidato = id_candidato;
        this.id_eleccion = id_eleccion;
    }

    public String getId_eleccion() {
        return id_eleccion;
    }

    public void setId_eleccion(String id_eleccion) {
        this.id_eleccion = id_eleccion;
    }

    public String getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(String id_candidato) {
        this.id_candidato = id_candidato;
    }
    
    
    
}
