/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgWsCambio;

import PkgEntidad.ClsEntidadCasaCambio;
import PkgEntidad.ClsEntidadListaUbicacion;
import PkgNegocios.ClsNegocioPersona;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import PkgEntidad.ClsEntidadPersona;
import PkgEntidad.ClsEntidadTipoOficina;
import PkgNegocios.ClsNegocioCasaCambio;
import PkgNegocios.ClsNegocioListaUbicacion;
import PkgNegocios.ClsNegocioTipoOficina;
import java.util.ArrayList;

/**
 *
 * @author Corei7
 */
@WebService(serviceName = "WSCambio")
public class WSCambio {

    /**
     * Web service operation
     * @param usuario
     * @param password
     * @return 
     */
    @WebMethod(operationName = "IniciarSesion")
    public ClsEntidadPersona IniciarSesion(@WebParam(name = "usuario") String usuario, @WebParam(name = "password") String password) {
        ClsNegocioPersona negocioPersona = new ClsNegocioPersona();
        ClsEntidadPersona entidadPersona = new ClsEntidadPersona();
        
        try {
            entidadPersona = negocioPersona.IniciarSesion(usuario, password);
        } catch (SQLException | ClassNotFoundException ex) {}
      
        return entidadPersona;
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "CargarTipoOficina")
    public ArrayList<ClsEntidadTipoOficina> CargarTipoOficina() {
        ClsNegocioTipoOficina negocioTipoOficina = new ClsNegocioTipoOficina();
        ArrayList<ClsEntidadTipoOficina> DatosTipoOficina = negocioTipoOficina.ObtenerDatosTipoOficina();
        return DatosTipoOficina;
        
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "CargarListaUbicacion")
    public ArrayList <ClsEntidadListaUbicacion> CargarListaUbicacion() {
        ClsNegocioListaUbicacion negocioListaUbicacion = new ClsNegocioListaUbicacion();
        ArrayList<ClsEntidadListaUbicacion> DatosListaUbicacion = negocioListaUbicacion.ObtenerDatosListaUbicacion();
        return DatosListaUbicacion;
       
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertarCasaCambio")
    public ClsEntidadCasaCambio InsertarCasaCambio(@WebParam(name = "TipoOficina_IdTipoOficina") int TipoOficina_IdTipoOficina, @WebParam(name = "DireccionCasaCambio") String DireccionCasaCambio, @WebParam(name = "Distrito_IdDistrito") int Distrito_IdDistrito, @WebParam(name = "CasaCambioTelefono") String CasaCambioTelefono, @WebParam(name = "CasaCambioCelular") String CasaCambioCelular, @WebParam(name = "Estado") int Estado) {
        ClsNegocioCasaCambio negocioCasaCambio = new ClsNegocioCasaCambio();
        ClsEntidadCasaCambio entidadCasaCambio = new ClsEntidadCasaCambio();
        
        entidadCasaCambio.setTipoOficina_IdTipoOficina(String.valueOf(TipoOficina_IdTipoOficina));
        entidadCasaCambio.setDireccionCasaCambio(DireccionCasaCambio);
        entidadCasaCambio.setDistrito_IdDistrito(String.valueOf(Distrito_IdDistrito));
        entidadCasaCambio.setCasaCambioTelefono(CasaCambioTelefono);
        entidadCasaCambio.setCasaCambioCelular(CasaCambioCelular);
        entidadCasaCambio.setEstado(String.valueOf(Estado));
        
        negocioCasaCambio.guardarCasaCambio(entidadCasaCambio);
      
        return entidadCasaCambio;
    }

}
