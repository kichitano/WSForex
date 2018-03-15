/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgNegocios;

import PkgConexion.ClsConexion;
import PkgEntidad.ClsEntidadPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Corei7
 */
public class ClsNegocioPersona {
    
    ClsEntidadPersona entidadUsuario;
    ClsConexion conexion;
    
    public ClsEntidadPersona IniciarSesion(String usuario,String password ) throws SQLException, ClassNotFoundException{
        
        conexion = new ClsConexion();
        Connection connection = conexion.getConnection();
        entidadUsuario = new ClsEntidadPersona();
        
        try{
            PreparedStatement consulta;
            consulta = connection.prepareStatement("Select TipoDocumento_IdTipoDocumento,NumeroDocumentoPersona,ApellidoPrimeroPersona,\n" +
                "ApellidoSegundoPersona,NombresPersona,Pais_idPais,Ocupacion_IdOcupacion \n" +
                "from persona inner join usuario on NumeroDocumentoPersona = Persona_NumeroDocumentoPersona\n" +
                "where NombreUsuario = ? AND PasswordUsuario= ? AND EstadoUsuario = 1");
            consulta.setString(1, usuario);
            consulta.setString(2, password);
            ResultSet resultado = consulta.executeQuery();
            
            while(resultado.next()){
                entidadUsuario.setIdTipoDocumento(resultado.getString("TipoDocumento_IdTipoDocumento"));
                entidadUsuario.setNumeroDocumentoPersona(resultado.getString("NumeroDocumentoPersona"));
                entidadUsuario.setApellidoPrimeroPersona(resultado.getString("ApellidoPrimeroPersona"));
                entidadUsuario.setApellidoSegundoPersona(resultado.getString("ApellidoSegundoPersona"));
                entidadUsuario.setNombresPersona(resultado.getString("NombresPersona"));
                entidadUsuario.setIdPais(resultado.getString("Pais_idPais"));
                entidadUsuario.setIdOcupacion(resultado.getString("Ocupacion_IdOcupacion"));
                return entidadUsuario;
            }
            connection.close();
        }catch(SQLException e){}               
    
        return entidadUsuario;
    }    
}
