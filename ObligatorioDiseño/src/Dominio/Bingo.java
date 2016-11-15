/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Common.IObjetoFabrica;
import Common.Utilidades.EnumeradosFabrica;
import Common.cException;
import Common.cJuego;
import Common.cUsuario;
import Persistencia.pUsuario;

/**
 *
 * @author cristian castro
 */
public class Bingo {
    
    // <editor-fold defaultstate="collapsed" desc=" Singleton ">
    private static Bingo bin;
    
    public static Bingo getInstancia() {
        if (bin == null) {
            bin = new Bingo();
        }
        return bin;
    }
   //</editor-fold>

    public Bingo() {
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Juego ">  
    public boolean ModificarConfiguracion(cJuego pJuego) throws cException
    {
        dJuego u = new dJuego();
        return u.Modificar(pJuego);
    }
    
    public boolean EliminarConfiguracion(cJuego pJuego) throws cException
    {
        dJuego u = new dJuego();
        return u.Eliminar(pJuego);
    }
    
    public cJuego buscarTodo() throws cException
    {
        dJuego u = new dJuego();
        return u.buscarTodo();
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc=" Usuario ">
    public boolean AgregarUsuario(cUsuario pUsuario) throws cException
    {
        dUsuario u = new dUsuario();
        return u.Agregar(pUsuario);
    }
    
    public boolean ModificarUsuario(cUsuario pUsuario) throws cException
    {
        dUsuario u = new dUsuario();
        return u.Modificar(pUsuario);
    }
    
    public boolean Eliminar(cUsuario pUsuario) throws cException
    {
        dUsuario u = new dUsuario();
        return u.Eliminar(pUsuario);
    }
    
    public cUsuario buscarAdministrador(cUsuario pUsuario) throws cException
    {
        dUsuario u = new dUsuario();
        return u.buscarAdministrador(pUsuario);
    }
    
    public cUsuario buscarUsuario(cUsuario pUsuario) throws cException
    {
        dUsuario u = new dUsuario();
        return u.buscarUsuario(pUsuario);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Fabrica ">
    
    public IObjetoFabrica CrearObjeto (EnumeradosFabrica o)
    {
        switch (o) {
            case Usuario:
                return cUsuario.ObtenerInstancia(); 
            case Juego:
                return cJuego.ObtenerInstancia();
            default:
                return null;
        }
    }
    
    // </editor-fold>
}
