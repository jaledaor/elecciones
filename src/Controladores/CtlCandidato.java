/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.ClsCandidato;
import Clases.ClsMensajes;
import Modelos.MdlCandidato;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author hueck
 */
public class CtlCandidato {
    
    MdlCandidato modeloCandidato= new MdlCandidato();
    boolean respuesta;

    public CtlCandidato() {
        this.modeloCandidato = modeloCandidato;   
    }
    
    public ClsMensajes agregarCandidato(ClsCandidato candidato){
        
        //JOptionPane.showMessageDialog(null, candidato.toString());
        ClsMensajes mensaje = this.modeloCandidato.agregarCandidato(candidato);
        return mensaje;
    }
    
    public String consultarCandidato(ClsCandidato candidato){
        
        String respuesta = this.modeloCandidato.consultarCandidato(candidato);
        return respuesta;
    }
    
    public LinkedList<ClsCandidato> ObtenerCandidatos(){
        return this.modeloCandidato.ObtenerCandidatos();
    }
    
    public ClsMensajes eliminarCandidato(String id){
        ClsMensajes mensaje =this.modeloCandidato.eliminarCandidato(id);
        return mensaje;        
    }
    
     public ClsMensajes actualizarCandidato(ClsCandidato candidato){
        
        //JOptionPane.showMessageDialog(null, candidato.toString());
        ClsMensajes mensaje = this.modeloCandidato.actualizarCandidato(candidato);
        return mensaje; 
    }
    
}
