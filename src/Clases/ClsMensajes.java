/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author hueck
 */
public class ClsMensajes {

    public final static String OK = "OK";
    public final static String ERROR = "ERROR";
    public final static String ADVERTENCIA = "ADVERTENCIA";

    private String tipo;
    private String texto;

    public ClsMensajes(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void mostrarMensajeOk() {
        JOptionPane.showMessageDialog(null, this.getTexto(),"Correcto",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarMensajeError() {
        JOptionPane.showMessageDialog(null, this.getTexto(),"Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void mostrarMensajeAdvertencia() {
        JOptionPane.showMessageDialog(null, this.getTexto(),"Warning",JOptionPane.WARNING_MESSAGE);
    }
}
