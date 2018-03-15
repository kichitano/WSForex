/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgNegocios;

import PkgConexion.ClsConexion;
import PkgEntidad.ClsEntidadCasaCambio;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author adminsa16
 */
public class ClsNegocioCasaCambio {

    ClsConexion con;
    public void guardarCasaCambio(ClsEntidadCasaCambio clsEntidadCasaCambio) {
        con = new ClsConexion();
        Connection connection = con.getConnection();
        String cadenaSql = "insert into casacambio values (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(cadenaSql);
                preparedStatement.setString(1,clsEntidadCasaCambio.getTipoOficina_IdTipoOficina());
                preparedStatement.setString(2,clsEntidadCasaCambio.getDireccionCasaCambio());
                preparedStatement.setString(3,clsEntidadCasaCambio.getDistrito_IdDistrito());
                preparedStatement.setString(4,clsEntidadCasaCambio.getCasaCambioTelefono());
                preparedStatement.setString(5,clsEntidadCasaCambio.getCasaCambioCelular());
                preparedStatement.setString(6,clsEntidadCasaCambio.getEstado());
                preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
        }
    }
}
