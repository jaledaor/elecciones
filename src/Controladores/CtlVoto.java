/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.ClsMensajes;
import Clases.ClsVotante;
import Clases.ClsVoto;
import Modelos.MdlVoto;
import java.util.LinkedList;

/**
 *
 * @author hueck
 */
public class CtlVoto {
    MdlVoto modeloVotacion = new MdlVoto();
    
    public CtlVoto() {
        this.modeloVotacion = modeloVotacion;
    }
    
    public ClsMensajes agregarVoto(ClsVoto voto) {
        ClsMensajes mensaje = this.modeloVotacion.agregarVoto(voto);
        return mensaje;
    }
    
    public LinkedList<ClsVoto> obtenerElecciones() {
        return this.modeloVotacion.obtenerElecciones();
    }
    
    public LinkedList<ClsVoto> obtenerCandidatos(String id) {
        return this.modeloVotacion.obtenerCandidatos(id);
    }
    
    public LinkedList<ClsVotante> obtenerVotantes() {
        return this.modeloVotacion.obtenerVotantes();
    }
    
     public LinkedList<ClsVoto> obtenerVotos(String id) {
        return this.modeloVotacion.obtenerVotos(id);
    }
    
    
    public ClsMensajes eliminarVoto(String id) {
        ClsMensajes mensaje = this.modeloVotacion.eliminarVoto(id);
        return mensaje;
    }
}
