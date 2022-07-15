/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.ClsVotante;
import Modelos.MdlVotante;
import java.util.LinkedList;

/**
 *
 * @author hueck
 */
public class CtlVotante {
    
    MdlVotante modeloVotante = new MdlVotante();
    boolean respuesta;

    public CtlVotante() {
        this.modeloVotante = modeloVotante;
    }
    
    
    
public boolean agregarVotante(ClsVotante votante){    
        
        respuesta = this.modeloVotante.agregarVotante(votante);
        return respuesta;
    }

public String consultarVotante(ClsVotante votante){
        
        String respuestaString = this.modeloVotante.consultarVotante(votante);
        return respuestaString;
    }

public LinkedList<ClsVotante> Obtenervotantes(){
        return this.modeloVotante.ObtenerVotantes();
    }

    
}
