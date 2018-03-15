/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgConexion;

import java.sql.*;

/**
 *
 * @author Corei7
 */
public class ClsConexion {
    public ClsConexion(){}
    
    public Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/dbcasacambioforex","root","1234");
        }catch(SQLException | ClassNotFoundException ex){}
        return con;
    }
}