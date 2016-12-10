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
import Interfase.PatronObserver;
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
    public void ModificarConfiguracion(cJuego pJuego) throws cException
    {
        dJuego u = new dJuego();
        u.Modificar(pJuego);
    }
        
    public cJuego buscarTodo() throws cException
    {
        dJuego u = new dJuego();
        return u.buscarTodo();
    }
    
    public void ComenzarPartida(PatronObserver PObserver)
    {
        dJuego u = new dJuego();
        u.ComenzarPartida(PObserver);
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Usuario ">
    public void AgregarUsuario(cUsuario pUsuario) throws cException
    {
        dUsuario u = new dUsuario();
        u.Agregar(pUsuario);
    }
    
    public void ModificarUsuario(cUsuario pUsuario) throws cException
    {
        dUsuario u = new dUsuario();
        u.Modificar(pUsuario);
    }
    
    public void Eliminar(cUsuario pUsuario) throws cException
    {
        dUsuario u = new dUsuario();
        u.Eliminar(pUsuario);
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
    
    public boolean CompraDeCarton(int pCartones, cUsuario pUsu) throws cException
    {
        dUsuario u = new dUsuario();
        return u.CompraDeCarton(pCartones,pUsu);
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
