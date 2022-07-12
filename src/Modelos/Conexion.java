/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.*;

/**
 *
 * @author hueck
 */
public class Conexion {
    private final String base ="bd_elecciones";
    private final String user="root";
    private final String passwd="1234567890";
    private final String url="jdbc:mysql://localhost:3306/"+base+"?useUnicode=true&useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private Connection con=null;
 
    public Connection Conexion(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(this.url,this.user, this.passwd);
            if(con!=null){
                System.out.println("Conexión Exitosa a la BD: "+base);
                
            }else {System.out.println("no hay conexion a la bd: "+base);}
        }
        catch(ClassNotFoundException e){
            System.out.println("Ocurrió un error ClassNotFoundException: "+e.getMessage());
        }
        catch(SQLException e){
            System.out.println("Ocurrió un SQLException: "+e.getMessage());
        }
        return con;
    }
    
}
