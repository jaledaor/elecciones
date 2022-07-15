/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.ClsCandidato;
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
    
    public boolean agregarCandidato(ClsCandidato candidato){
        
        //JOptionPane.showMessageDialog(null, candidato.toString());
        boolean respuesta = this.modeloCandidato.agregarCandidato(candidato);
        return true;
    }
    
    public String consultarCandidato(ClsCandidato candidato){
        
        String respuesta = this.modeloCandidato.consultarCandidato(candidato);
        return respuesta;
    }
    
    public LinkedList<ClsCandidato> ObtenerCandidatos(){
        return this.modeloCandidato.ObtenerCandidatos();
    }
    
}
