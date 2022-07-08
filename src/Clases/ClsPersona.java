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
public class ClsPersona {
    private String numeroDocumento;
    private String nombre;
    private String tipoDocumento;
    private String telefono;
    private String correo;

    public ClsPersona(String numeroDocumento, String nombre, String tipoDocumento, String telefono, String correo) {
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "ClsPersona{" + "numeroDocumento=" + numeroDocumento + ", nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", telefono=" + telefono + ", correo=" + correo + '}';
    }
    
    
}
