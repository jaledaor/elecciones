/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.ClsEleccion;
import Clases.ClsMensajes;
import Modelos.MdlEleccion;
import java.util.LinkedList;

/**
 *
 * @author hueck
 */
public class CtlEleccion {

    MdlEleccion modeloEleccion = new MdlEleccion();

    public CtlEleccion() {
        this.modeloEleccion = modeloEleccion;
    }

    public ClsMensajes agregarEleccion(ClsEleccion eleccion) {

        ClsMensajes mensaje = this.modeloEleccion.agregarEleccion(eleccion);
        return mensaje;
    }

    public LinkedList<ClsEleccion> ObtenerElecciones() {
        return this.modeloEleccion.ObtenerElecciones();
    }

    public ClsMensajes eliminarEleccion(String id) {
        ClsMensajes mensaje = this.modeloEleccion.eliminarEleccion(id);
        return mensaje;
    }

    public ClsMensajes actualizarEleccion(ClsEleccion eleccion) {
        //JOptionPane.showMessageDialog(null, candidato.toString());
        ClsMensajes mensaje = this.modeloEleccion.actualizarEleccion(eleccion);
        return mensaje;
    }

}
