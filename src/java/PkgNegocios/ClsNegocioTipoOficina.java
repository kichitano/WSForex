/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgNegocios;

import PkgConexion.ClsConexion;
import PkgEntidad.ClsEntidadTipoOficina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Corei7
 */
public class ClsNegocioTipoOficina {
    
    ClsEntidadTipoOficina tipoOficina;
    ArrayList<ClsEntidadTipoOficina> DatosTipoOficina = new ArrayList<>();
    ClsConexion conexion;
    
    
    public ArrayList<ClsEntidadTipoOficina> ObtenerDatosTipoOficina(){
        
        conexion = new ClsConexion();
        Connection connection = conexion.getConnection();
        
        try{
            PreparedStatement consulta;
            consulta = connection.prepareStatement("Select * from vista_tipooficina");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                tipoOficina = new ClsEntidadTipoOficina();
                tipoOficina.setIdTIpoOficina(resultado.getInt("IdTipoOficina"));
                tipoOficina.setDescripcionTipoOficina(resultado.getString("DescripcionTipoOficina"));
                DatosTipoOficina.add(tipoOficina);
            }
        }catch(SQLException e){}
        
        try {
            connection.close();
        } catch (SQLException ex) {}
        
        return DatosTipoOficina;
    }
    
}
