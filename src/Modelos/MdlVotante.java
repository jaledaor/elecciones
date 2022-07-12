/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.*;
import java.sql.ResultSet;
import Clases.ClsVotante;
import javax.swing.JOptionPane;

/**
 *
 * @author hueck
 */
public class MdlVotante extends Conexion {   
    
    public MdlVotante() {
        Connection con = Conexion();
    }
    
    
       
    public boolean agregarVotante(ClsVotante votante) {
        
        
        PreparedStatement ps = null;
        Connection con = Conexion();
        
        String sql = "Insert into bd_elecciones.tbl_votantes (id_votante, tipo_documento, nombre, telefono, correo) values (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, votante.getNumeroDocumento());
            ps.setString(2, votante.getTipoDocumento());
            ps.setString(3, votante.getNombre());
            ps.setString(4, votante.getTelefono());
            ps.setString(5, votante.getCorreo());
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

    public String consultarVotante(ClsVotante votante) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion();
        String listado="";
        
        String sql = "select * from bd_elecciones.tbl_votantes";

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
                listado+=" Id Votante: ";
                listado+=rs.getString("id_votante");
                listado+=" Nombre: ";
                listado+=rs.getString("nombre");
                listado+=" Telefono: ";
                listado+=rs.getString("telefono");
                listado+=" Email: ";
                listado+=rs.getString("correo");
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
