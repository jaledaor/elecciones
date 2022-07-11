/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.ClsVotante;
import Modelos.MdlVotante;
import javax.swing.JOptionPane;

/**
 *
 * @author hueck
 */
public class CtlVotante {
    
    MdlVotante modeloVotante;

    public CtlVotante() {
        this.modeloVotante = modeloVotante;
    }
    
    
    
public boolean agregarCandidato(ClsVotante votante){
        
        JOptionPane.showMessageDialog(null, votante.toString());
        boolean respuesta = this.modeloVotante.agregarCandidato(votante);
        
        return true;
    }
    
}
