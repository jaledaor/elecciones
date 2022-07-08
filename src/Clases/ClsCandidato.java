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

    public ClsCandidato(String numeroDocumento, String nombre, String tipoDocumento, String telefono, String correo,String partidoPolitico, String ciudadOrigen, String descripcion, String mensajeCampania, List propuestas) {
        super(numeroDocumento, nombre, tipoDocumento, telefono, correo);
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

    

    
    
    
    
    
}
