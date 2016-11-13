/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Common.IObjetoFabrica;
import Common.Utilidades.EnumeradosFabrica;
import Common.cCarton;
import Common.cUsuario;

/**
 *
 * @author cristian castro
 */
public class Bingo {
    
    // <editor-fold defaultstate="collapsed" desc=" Carton ">
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Usuario ">
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Fabrica ">
    
    public IObjetoFabrica CrearObjeto (EnumeradosFabrica o)
    {
        switch (o) {
            case Usuario:
                return cUsuario.ObtenerInstancia(); 
            case Carton:
                return cCarton.ObtenerInstancia();
            default:
                return null;
        }
    }
    
    // </editor-fold>
}
