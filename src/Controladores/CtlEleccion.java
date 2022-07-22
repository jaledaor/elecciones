/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Clases.ClsEleccion;
import Clases.ClsMensajes;
import Modelos.MdlEleccion;
/**
 *
 * @author hueck
 */
public class CtlEleccion {
    MdlEleccion modeloEleccion = new MdlEleccion();
    public CtlEleccion() {
        this.modeloEleccion= modeloEleccion;
    }

public ClsMensajes agregarEleccion(ClsEleccion eleccion){    
        
        ClsMensajes mensaje = this.modeloEleccion.agregarEleccion(eleccion);
        return mensaje;
    }    
    
}
