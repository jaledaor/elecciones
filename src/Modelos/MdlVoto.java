/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Clases.ClsMensajes;
import Clases.ClsVotante;
import Clases.ClsVoto;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;
/**
 *
 * @author hueck
 */
public class MdlVoto extends Conexion{
    ClsMensajes mensaje;
    
    public MdlVoto() {
        Connection con = Conexion();
    }
    
    public ClsMensajes agregarVoto(ClsVoto voto) {
        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "Insert into bd_elecciones.tbl_votos (id_eleccion, id_candidato, id_votante, fecha_voto) values (?,?,?,NOW())";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, voto.getIdEleccion());
            ps.setString(2, voto.getIdCandidato());
            ps.setString(3, voto.getIdVotante());
            int resultado = ps.executeUpdate();
            if (resultado >= 1) {
                mensaje = new ClsMensajes(ClsMensajes.OK, "Se ha Adicionado un voto Correctamente");
                return mensaje;
            }
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Insertar un voto");
            return mensaje;
        } catch (Exception e) {
            System.err.println(e);
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Insertar un voto " + e);
            return mensaje;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public ClsMensajes actualizarVoto(ClsVoto voto) {
        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "update bd_elecciones.tbl_votos set id_candidato=?, id_votante=?, fecha_voto=now() where id_voto=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, voto.getIdCandidato());
            ps.setString(2, voto.getIdVotante());
            ps.setString(3, voto.getIdVoto());
            int resultado = ps.executeUpdate();
            if (resultado >= 1) {
                mensaje = new ClsMensajes(ClsMensajes.OK, "Se ha actualizado el voto Correctamente");
                return mensaje;
            }
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar actualizar el voto");
            return mensaje;
        } catch (Exception e) {
            System.err.println(e);
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar actualizar el voto " + e);
            return mensaje;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public LinkedList<ClsVoto> obtenerElecciones() {
    PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion();
        String sql = "select DISTINCT id_eleccion from bd_elecciones.tbl_candidato_por_eleccion";
        LinkedList<ClsVoto> Lista = new LinkedList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idEleccion = rs.getString("id_eleccion");
                ClsVoto eleccion = new ClsVoto(idEleccion);
                Lista.add(eleccion);

            }
            return Lista;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
    
    public LinkedList<ClsVoto> obtenerCandidatos(String id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion();
        String sql = "select id_candidato from bd_elecciones.tbl_candidato_por_eleccion where id_eleccion=?";
        LinkedList<ClsVoto> Lista = new LinkedList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idCandidato = rs.getString("id_candidato");
                ClsVoto eleccion = new ClsVoto(id,idCandidato);
                Lista.add(eleccion);

            }
            return Lista;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
    
    public LinkedList<ClsVotante> obtenerVotantes() {
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
    
    public LinkedList<ClsVoto> obtenerVotos(String id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion();
        String sql = "select * from bd_elecciones.tbl_votos where id_eleccion=?";
        LinkedList<ClsVoto> Lista = new LinkedList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idVoto = rs.getString("id_voto");
                String idEleccion = rs.getString("id_eleccion");
                String idCandidato = rs.getString("id_candidato");
                String idVotante = rs.getString("id_votante");
                String fechaVoto = rs.getString("fecha_voto");
                ClsVoto votacion = new ClsVoto(idCandidato,idEleccion, idVotante, idVoto,fechaVoto);
                Lista.add(votacion);

            }
            return Lista;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }

    }
    
    public ClsMensajes eliminarVoto(String id) {
        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "delete from bd_elecciones.tbl_votos where id_voto=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            int resultado = ps.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensajes(ClsMensajes.OK, "has Eliminado una elección correctamente");
                return mensaje;
            } else {
                mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Eliminar la elección seleccionada");
                return mensaje;
            }
        } catch (Exception e) {
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Eliminar la elección seleccionada " + e);
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
