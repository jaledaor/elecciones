/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author hueck
 */
public class ClsVotante extends ClsPersona{

    public ClsVotante(String tipoDocumento, String numeroDocumento, String nombre, String telefono, String correo) {
        super(tipoDocumento, numeroDocumento, nombre, telefono, correo);
    }

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCorreo() {
        return super.getCorreo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTelefono(String telefono) {
        super.setTelefono(telefono); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTelefono() {
        return super.getTelefono(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTipoDocumento(String tipoDocumento) {
        super.setTipoDocumento(tipoDocumento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTipoDocumento() {
        return super.getTipoDocumento(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumeroDocumento(String numeroDocumento) {
        super.setNumeroDocumento(numeroDocumento); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNumeroDocumento() {
        return super.getNumeroDocumento(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
