/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Clases.ClsCandidato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hueck
 */
public class MdlCandidato extends Conexion{
    
    public MdlCandidato() {
        Connection con = Conexion();
    }
    
    
    
   public boolean agregarCandidato(ClsCandidato candidato){
       
       PreparedStatement ps = null;
        Connection con = Conexion();
        
        String sql = "Insert into bd_elecciones.tbl_candidatos (id_candidato, tipo_documento, nombre, telefono, correo, partido_politico,ciudad_origen,descripcion,mensaje_campania,propuestas) values (?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, candidato.getNumeroDocumento());
            ps.setString(2, candidato.getTipoDocumento());
            ps.setString(3, candidato.getNombre());
            ps.setString(4, candidato.getTelefono());
            ps.setString(5, candidato.getCorreo());
            ps.setString(6, candidato.getPartidoPolitico());
            ps.setString(7, candidato.getCiudadOrigen());
            ps.setString(8, candidato.getDescripcion());
            ps.setString(9, candidato.getMensajeCampania());
            ps.setString(10, candidato.getPropuestas().toString());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Entre al catch:" + e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Entre al catch2:" + e);
            }
        }

   }
   
   public String consultarCandidato(ClsCandidato candidato) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion();
        String listado="";
        
        String sql = "select * from bd_elecciones.tbl_candidatos";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                /*votante.setTipoDocumento(rs.getString("tipo_documento"));
                votante.setNumeroDocumento(rs.getString("id_votante"));
                votante.setNombre(rs.getString("nombre"));
                votante.setTelefono(rs.getString("telefono"));
                votante.setCorreo(rs.getString("correo"));*/
                listado+="Tipo Documento: ";
                listado+=rs.getString("tipo_documento");
                listado+=" Id Candidato: ";
                listado+=rs.getString("id_candidato");
                listado+=" Nombre: ";
                listado+=rs.getString("nombre");
                listado+=" Telefono: ";
                listado+=rs.getString("telefono");
                listado+=" Email: ";
                listado+=rs.getString("correo");
                listado+=" Partido Politico: ";
                listado+=rs.getString("partido_politico");
                listado+=" Ciudad Origen: ";
                listado+=rs.getString("ciudad_origen");
                listado+=" Ciudad Origen: ";
                listado+=rs.getString("ciudad_origen");
                listado+=" Descripción: ";
                listado+=rs.getString("descripcion");
                listado+=" mensaje Campaña: ";
                listado+=rs.getString("mensaje_campania");
                listado+=" Propuestas: ";
                listado+=rs.getString("propuestas");
                listado+="\n";
            }
            return listado;
            
        } catch (SQLException e) {
            System.err.println(e);
            return listado;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
}
