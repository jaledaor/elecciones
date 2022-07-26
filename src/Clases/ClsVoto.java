/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author jairo.davila
 */
public class ClsVoto {
    
    private String idCandidato;
    private String idEleccion;
    private String idVotante;
    private String idVoto;
    private String fechaEleccion;

    public ClsVoto(String idEleccion, String idCandidato) {
        this.idCandidato = idCandidato;
        this.idEleccion = idEleccion;
    }
    
    public ClsVoto(String idEleccion) {
        this.idEleccion = idEleccion;
    }

    public ClsVoto(String idCandidato, String idEleccion, String idVotante) {
        this.idCandidato = idCandidato;
        this.idEleccion = idEleccion;
        this.idVotante = idVotante;
    }

    public ClsVoto(String idCandidato, String idEleccion, String idVotante, String idVoto, String fechaEleccion) {
        this.idCandidato = idCandidato;
        this.idEleccion = idEleccion;
        this.idVotante = idVotante;
        this.idVoto = idVoto;
        this.fechaEleccion = fechaEleccion;
    }

    public String getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(String idEleccion) {
        this.idEleccion = idEleccion;
    }

    public String getIdVotante() {
        return idVotante;
    }

    public void setIdVotante(String idVotante) {
        this.idVotante = idVotante;
    }

    public String getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(String idVoto) {
        this.idVoto = idVoto;
    }

    public String getFechaEleccion() {
        return fechaEleccion;
    }

    public void setFechaEleccion(String fechaEleccion) {
        this.fechaEleccion = fechaEleccion;
    }
    
}