/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

<<<<<<< HEAD
/**
 *
 * @author Martin
 */
public class dUsuario {
    
=======
import Common.cException;
import Common.cUsuario;
import Persistencia.pUsuario;

/**
 *
 * @author cristian castro
 */
public class dUsuario {
    
    public boolean Agregar(cUsuario pUsuario) throws cException
    {
        pUsuario u = new pUsuario();
        return u.agregar(pUsuario);
    }
    
    public boolean Modificar(cUsuario pUsuario) throws cException
    {
        pUsuario u = new pUsuario();
        return u.modificar(pUsuario);
    }
    
    public boolean Eliminar(cUsuario pUsuario) throws cException
    {
        pUsuario u = new pUsuario();
        return u.eliminar(pUsuario);
    }
    
    public cUsuario buscarAdministrador(cUsuario pUsuario) throws cException
    {
        pUsuario u = new pUsuario();
        return u.buscarAdministrador(pUsuario);
    }
    
    public cUsuario buscarUsuario(cUsuario pUsuario) throws cException
    {
        pUsuario u = new pUsuario();
        return u.buscarUsuario(pUsuario);
    }
    
>>>>>>> 1fcfb3e769d5dfcbe8acacfed7521e979b7a9bc3
}
