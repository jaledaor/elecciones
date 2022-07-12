/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.List;

/**
 *
 * @author hueck
 */
public class ClsCandidato extends ClsPersona{
    
    private String partidoPolitico;
    private String ciudadOrigen;
    private String descripcion;
    private String mensajeCampania;
    private List propuestas;

    public ClsCandidato() {
    }
    
    

    public ClsCandidato(String numeroDocumento, String tipoDocumento, String nombre,String telefono, String correo,String partidoPolitico, String ciudadOrigen, String descripcion, String mensajeCampania, List propuestas) {
        super(tipoDocumento, numeroDocumento, nombre, telefono, correo);
        this.partidoPolitico = partidoPolitico;
        this.ciudadOrigen = ciudadOrigen;
        this.descripcion = descripcion;
        this.mensajeCampania = mensajeCampania;
        this.propuestas = propuestas;
    }  

    @Override
    public String toString() {
        return "ClsCandidato{" + "partidoPolitico=" + partidoPolitico + ", ciudadOrigen=" + ciudadOrigen + ", descripcion=" + descripcion + ", mensajeCampania=" + mensajeCampania + ", propuestas=" + propuestas + '}';
    }
        
    
    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMensajeCampania() {
        return mensajeCampania;
    }

    public void setMensajeCampania(String mensajeCampania) {
        this.mensajeCampania = mensajeCampania;
    }

    public List getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(List propuestas) {
        this.propuestas = propuestas;
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
