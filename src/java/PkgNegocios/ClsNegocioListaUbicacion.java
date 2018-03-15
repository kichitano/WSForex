/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgNegocios;
import PkgConexion.ClsConexion;
import PkgEntidad.ClsEntidadListaUbicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author adminsa16
 */
public class ClsNegocioListaUbicacion {
    ClsEntidadListaUbicacion listaUbicacion;
    ArrayList<ClsEntidadListaUbicacion> DatosListaUbicacion = new ArrayList<>();
    ClsConexion conexion;
    
     public ArrayList<ClsEntidadListaUbicacion> ObtenerDatosListaUbicacion(){
        
        conexion = new ClsConexion();
        Connection connection = conexion.getConnection();
        
        try{
            PreparedStatement consulta;
            consulta = connection.prepareStatement("select d.IdDepartamento, d.NombreDepartamento, p.idProvincia, \n" +
            "p.NombreProvincia, di.IdDistrito, di.NombreDistrito\n" +
            "from Departamento as d \n" +
            "inner join Provincia as p\n" +
            "on d.IdDepartamento = p.Departamento_IdDepartamento\n" +
            "inner join Distrito as di\n" +
            "on p.idProvincia = di.Provincia_idProvincia");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                listaUbicacion = new ClsEntidadListaUbicacion();
                listaUbicacion.setIdDepartamento(resultado.getString("IdDepartamento"));
                listaUbicacion.setNombreDepartamento(resultado.getString("NombreDepartamento"));
                listaUbicacion.setIdProvincia(resultado.getString("idProvincia"));
                listaUbicacion.setNombreProvincia(resultado.getString("NombreProvincia"));
                listaUbicacion.setIdDistrito(resultado.getString("IdDistrito"));
                listaUbicacion.setNombreDistrito(resultado.getString("NombreDistrito"));
                DatosListaUbicacion.add(listaUbicacion);
            }
        }catch(SQLException e){}
        
        try {
            connection.close();
        } catch (SQLException ex) {}
        
        return DatosListaUbicacion;
    }
    
}
