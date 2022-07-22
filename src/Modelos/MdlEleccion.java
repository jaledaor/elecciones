/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Clases.ClsEleccion;
import Clases.ClsMensajes;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import Clases.ClsVotante;
import java.util.LinkedList;
import javax.swing.JOptionPane;
/**
 *
 * @author hueck
 */
public class MdlEleccion extends Conexion{
    ClsMensajes mensaje;
    
    public MdlEleccion() {
        Connection con = Conexion();
    }
 
    public ClsMensajes agregarEleccion(ClsEleccion eleccion) {
        
        
        PreparedStatement ps = null;
        Connection con = Conexion();
        
        String sql = "Insert into bd_elecciones.tbl_elecciones (id_eleccion, descripcion, categoria, estado, fecha_inicio, fecha_fin, fecha_insert) values (?,?,?,?,?,?,NOW())";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, eleccion.getIdEleccion());
            ps.setString(2, eleccion.getDescripcion());
            ps.setString(3, eleccion.getCategoria());
            ps.setString(4, "Abierta");
            ps.setString(5, eleccion.getFechaInicio());
            ps.setString(6, eleccion.getFechaFin());
            int resultado =ps.executeUpdate();
            if (resultado>=1){
            mensaje = new ClsMensajes(ClsMensajes.OK,"Se ha Adicionado una eleccion Correctamente");
            return mensaje;
            }
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Insertar una elección");
            return mensaje;
        } catch (Exception e) {
            System.err.println(e);
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Insertar una elección "+e);
            return mensaje;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Entre al catch2:" + e);
            }
        }
        
    }
    
    public LinkedList<ClsVotante> ObtenerVotantes() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion();
        String sql = "select * from bd_elecciones.tbl_votantes";
        LinkedList<ClsVotante> Lista = new LinkedList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tipo_documento = rs.getString("tipo_documento");
                String id_votante = rs.getString("id_votante");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                ClsVotante votante = new ClsVotante(tipo_documento,id_votante,nombre, telefono, correo);
                Lista.add(votante);

            }
            return Lista;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }

    }
    
    public ClsMensajes actualizarVotante(ClsVotante votante) {

        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "update bd_elecciones.tbl_votantes set tipo_documento=?, nombre=?, telefono=?, correo=? where id_votante=?";

        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, votante.getTipoDocumento());
            ps.setString(2, votante.getNombre());
            ps.setString(3, votante.getTelefono());
            ps.setString(4, votante.getCorreo());
            ps.setString(5, votante.getNumeroDocumento());
            int resultado =ps.executeUpdate();
            if (resultado>=1){
            mensaje = new ClsMensajes(ClsMensajes.OK,"Has actualizado el votante "+votante.getNumeroDocumento() +" correctamente");
            return mensaje;
            }
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Actualizar el votante seleccionado");
            return mensaje;
        } catch (Exception e) {
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Actualizar el votante seleccionado "+e);
            return mensaje;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    public ClsMensajes eliminarVotante(String id) {
        
        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "delete from bd_elecciones.tbl_votantes where id_votante=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            int resultado =ps.executeUpdate();
            
            if (resultado>=1){
            mensaje = new ClsMensajes(ClsMensajes.OK,"has Eliminado un votante correctamente");
            return mensaje;
            }
            
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Eliminar el votante seleccionado");
            return mensaje;
        } catch (Exception e) {
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Eliminar el votante seleccionado "+e);
            return mensaje;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
}
