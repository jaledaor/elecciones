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
    boolean respuesta;

    public CtlVotante() {
        this.modeloVotante = modeloVotante;
    }
    
    
    
public boolean agregarVotante(ClsVotante votante){
        
        JOptionPane.showMessageDialog(null,"modelo: "+ modeloVotante+ " Clase: "+ votante);
        
        
        respuesta = this.modeloVotante.agregarVotante(votante);
        
        JOptionPane.showMessageDialog(null, respuesta);
        
        return respuesta;
    }

public boolean consultarVotante(ClsVotante votante){
        
        //JOptionPane.showMessageDialog(null, votante.toString());
        boolean respuesta = this.modeloVotante.consultarVotante(votante);
        
        return respuesta;
    }
    
}
