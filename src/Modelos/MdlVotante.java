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
       
    public boolean agregarVotante(ClsVotante votante) {
        
        JOptionPane.showMessageDialog(null, "Entre al metodo");
        /*JOptionPane.showMessageDialog(null, "Entre al metodo");
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "Insert into elecciones.votantes (tipo_documento, numero_documento, nombre, telefono, correo) values (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, votante.getTipoDocumento());
            ps.setString(2, votante.getNumeroDocumento());
            ps.setString(3, votante.getNombre());
            ps.setString(4, votante.getTelefono());
            ps.setString(5, votante.getCorreo());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }*/
        return true;
    }

    public boolean consultarVotante(ClsVotante votante) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion();
        
        String sql = "select * from elecciones.votantes";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                votante.setTipoDocumento(rs.getString("tipo_documento"));
                votante.setNumeroDocumento(rs.getString("numero_documento"));
                votante.setNombre(rs.getString("nombre"));
                votante.setTelefono(rs.getString("telefono"));
                votante.setCorreo(rs.getString("correo"));
                return true;
            }
            return false;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
}
