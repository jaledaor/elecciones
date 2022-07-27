/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsMensajes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;


/**
 *
 * @author hueck
 */
public class MdlCandidato extends Conexion {
    ClsMensajes mensaje;
    public MdlCandidato() {
        Connection con = Conexion();
    }
    
    
    public ClsMensajes agregarCandidato(ClsCandidato candidato) {

        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "Insert into bd_elecciones.tbl_candidatos (id_candidato, tipo_documento, nombre, telefono, correo, partido_politico,ciudad_origen,descripcion,mensaje_campania) values (?,?,?,?,?,?,?,?,?)";

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
            int resultado =ps.executeUpdate();
            if (resultado>=1){
            mensaje = new ClsMensajes(ClsMensajes.OK,"Se ha Adicionado un Candidato Correctamente");
            return mensaje;
            }
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Insertar un candidato");
            return mensaje;
        } catch (Exception e) {
            System.err.println(e);
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Insertar un candidato "+e);
            return mensaje;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public LinkedList<ClsCandidato> ObtenerCandidatos() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion();
        String sql = "select * from bd_elecciones.tbl_candidatos";
        LinkedList<ClsCandidato> Lista = new LinkedList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tipo_documento = rs.getString("tipo_documento");
                String id_candidato = rs.getString("id_candidato");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String partido_politico = rs.getString("partido_politico");
                String ciudad_origen = rs.getString("ciudad_origen");
                String descripcion = rs.getString("descripcion");
                String mensaje_campania = rs.getString("mensaje_campania");
                ClsCandidato candidato = new ClsCandidato(id_candidato, tipo_documento, nombre, telefono, correo, partido_politico, ciudad_origen, descripcion, mensaje_campania);
                Lista.add(candidato);

            }
            return Lista;
            
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }

    }
    
    public ClsMensajes eliminarCandidato(String id) {
        
        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "delete from bd_elecciones.tbl_candidatos where id_candidato=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            int resultado =ps.executeUpdate();
            
            if (resultado>=1){
            mensaje = new ClsMensajes(ClsMensajes.OK,"has Eliminado un candidato correctamente");
            return mensaje;
            }
            
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Eliminar el candidato seleccionado");
            return mensaje;
        } catch (Exception e) {
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Eliminar el candidato seleccionado "+e);
            return mensaje;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
    
    public ClsMensajes actualizarCandidato(ClsCandidato candidato) {

        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "update bd_elecciones.tbl_candidatos set tipo_documento=?, nombre=?, telefono=?, correo=?, partido_politico=?,ciudad_origen=?,descripcion=?,mensaje_campania=? where id_candidato=?";

        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, candidato.getTipoDocumento());
            ps.setString(2, candidato.getNombre());
            ps.setString(3, candidato.getTelefono());
            ps.setString(4, candidato.getCorreo());
            ps.setString(5, candidato.getPartidoPolitico());
            ps.setString(6, candidato.getCiudadOrigen());
            ps.setString(7, candidato.getDescripcion());
            ps.setString(8, candidato.getMensajeCampania());
            ps.setString(9, candidato.getNumeroDocumento());
            int resultado =ps.executeUpdate();
            if (resultado>=1){
            mensaje = new ClsMensajes(ClsMensajes.OK,"Has actualizado el candidato "+candidato.getNumeroDocumento() +" correctamente");
            return mensaje;
            }
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Actualizar el candidato seleccionado");
            return mensaje;
        } catch (Exception e) {
            mensaje = new ClsMensajes(ClsMensajes.ERROR,"Ha ocurrido un error al intentar Actualizar el candidato seleccionado "+e);
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
