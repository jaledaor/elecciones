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
        String sql = "update bd_elecciones.tbl_elecciones set estado=?, fecha_inicio=?, fecha_fin=?, fecha_insert=now() where id_eleccion =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, eleccion.getEstado());
            ps.setString(2, eleccion.getFechaInicio());
            ps.setString(3, eleccion.getFechaFin());
            ps.setString(4, eleccion.getIdEleccion());
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
        int resultado;
        PreparedStatement ps = null;
        Connection con = Conexion();
        String sql1 = "select id_eleccion from bd_elecciones.tbl_elecciones where id_eleccion=? and id_eleccion in (select id_eleccion from bd_elecciones.tbl_candidato_por_eleccion where id_eleccion=?)";
        ResultSet rs = null;
        String sql = "delete from bd_elecciones.tbl_elecciones where id_eleccion=?";
        LinkedList<ClsVoto> Lista = new LinkedList<>();
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1, id);
            ps.setString(2, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String idEleccion = rs.getString("id_eleccion");
                ClsVoto candidatoEleccion = new ClsVoto(idEleccion);
                Lista.add(candidatoEleccion);
            }
            if (Lista.size() >= 1) {
                mensaje = new ClsMensajes(ClsMensajes.ERROR, "No se puede Eliminar la elección seleccionada tiene asociado un candidato");
                return mensaje;
            } else {
                try {
                    ps = con.prepareStatement(sql);
                    ps.setString(1, id);
                    resultado = ps.executeUpdate();
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

        /**/
    }

    public ClsMensajes eliminarCandidatoEleccion(String idE, String idC) {
        PreparedStatement ps = null;
        Connection con = Conexion();

        String sql = "delete from bd_elecciones.tbl_candidato_por_eleccion where id_eleccion=? and id_candidato=?";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, idE);
            ps.setString(2, idC);
            int resultado = ps.executeUpdate();
            if (resultado >= 1) {
                mensaje = new ClsMensajes(ClsMensajes.OK, "Se Ha Eliminado la asociacion de la Elección " + idE + " y el candidato " + idC + ", correctamente");
                return mensaje;
            } else {
                mensaje = new ClsMensajes(ClsMensajes.ERROR, "Ha ocurrido un error al intentar eliminar la asociacion de la Elección " + idE + " y el candidato " + idC);
                return mensaje;
            }

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
