/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsVoto;
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
public class MdlEleccion extends Conexion {

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
            int resultado = ps.executeUpdate();
            if (resultado >= 1) {
                mensaje = new ClsMensajes(ClsMensajes.OK, "Se ha Adicionado una eleccion Correctamente");
                return mensaje;
            }
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Insertar una elección");
            return mensaje;
        } catch (Exception e) {
            System.err.println(e);
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Insertar una elección " + e);
            return mensaje;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public LinkedList<ClsEleccion> ObtenerElecciones() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion();
        String sql = "select * from bd_elecciones.tbl_elecciones";
        LinkedList<ClsEleccion> Lista = new LinkedList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idEleccion = rs.getString("id_eleccion");
                String descripcion = rs.getString("descripcion");
                String categoria = rs.getString("categoria");
                String estado = rs.getString("estado");
                String fechaInicio = rs.getString("fecha_inicio");
                String fechaFin = rs.getString("fecha_fin");
                String ganador = "";
                ClsEleccion eleccion = new ClsEleccion(idEleccion, descripcion, categoria, estado, ganador, fechaInicio, fechaFin);
                Lista.add(eleccion);

            }
            return Lista;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }

    }

    public LinkedList<ClsVoto> ObtenerCandidatosElecciones(String id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion();
        String sql = "select * from bd_elecciones.tbl_candidato_por_eleccion where id_eleccion=?";
        LinkedList<ClsVoto> Lista = new LinkedList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idEleccion = rs.getString("id_eleccion");
                String idCandidato = rs.getString("id_candidato");
                ClsVoto candidatoEleccion = new ClsVoto(idEleccion, idCandidato);
                Lista.add(candidatoEleccion);

            }
            return Lista;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }

    }

    public ClsMensajes actualizarEleccion(ClsEleccion eleccion) {

        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "Insert into bd_elecciones.tbl_candidato_por_eleccion (id_eleccion, descripcion, categoria, estado, fecha_inicio, fecha_fin, fecha_insert) values (?,?,?,?,?,?,NOW())";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, eleccion.getDescripcion());
            ps.setString(2, eleccion.getCategoria());
            ps.setString(3, eleccion.getEstado());
            ps.setString(4, eleccion.getFechaInicio());
            ps.setString(5, eleccion.getFechaFin());
            int resultado = ps.executeUpdate();
            if (resultado >= 1) {
                mensaje = new ClsMensajes(ClsMensajes.OK, "Has actualizado la elección con id " + eleccion.getIdEleccion() + " correctamente");
                return mensaje;
            }
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Actualizar la elección seleccionada");
            return mensaje;
        } catch (Exception e) {
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Actualizar la elección seleccionada " + e);
            return mensaje;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public ClsMensajes eliminarEleccion(String id) {

        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "delete from bd_elecciones.tbl_elecciones where id_eleccion=?";

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

    public ClsMensajes eliminarCandidatoEleccion(String idCandidato, String idEleccion) {

        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "delete from bd_elecciones.tbl_candidato_por_eleccion where id_candidato=? and id_eleccion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, idCandidato);
            ps.setString(2, idEleccion);
            int resultado = ps.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensajes(ClsMensajes.OK, "has Eliminado la asociación correctamente");
                return mensaje;
            } else {

                mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Eliminar la Asociacion seleccionada");
                return mensaje;
            }
        } catch (Exception e) {
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Eliminar la Asociacion seleccionada " + e);
            return mensaje;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public ClsMensajes asociarCandidatoEleccion(String id_eleccion, String id_candidato) {

        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "Insert into bd_elecciones.tbl_candidato_por_eleccion (id_eleccion, id_candidato) values (?,?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, id_eleccion);
            ps.setString(2, id_candidato);
            int resultado = ps.executeUpdate();
            if (resultado >= 1) {
                mensaje = new ClsMensajes(ClsMensajes.OK, "Has asociado el id de eleccion: " + id_eleccion + " a el candidato con id " + id_candidato + " correctamente");
                return mensaje;
            }
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar asociar el id de eleccion: " + id_eleccion + " a el candidato con id " + id_candidato);
            return mensaje;
        } catch (Exception e) {
            mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar Actualizar la elección seleccionada " + e);
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
