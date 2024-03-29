/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.ClsMensajes;
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

    public ClsMensajes agregarVotante(ClsVotante votante) {

        ClsMensajes mensaje = this.modeloVotante.agregarVotante(votante);
        return mensaje;
    }

    public LinkedList<ClsVotante> ObtenerVotantes() {
        return this.modeloVotante.ObtenerVotantes();
    }

    public ClsMensajes eliminarVotante(String id) {
        ClsMensajes mensaje = this.modeloVotante.eliminarVotante(id);
        return mensaje;
    }

    public ClsMensajes actualizarVotante(ClsVotante votante) {
        ClsMensajes mensaje = this.modeloVotante.actualizarVotante(votante);
        return mensaje;
    }

}
