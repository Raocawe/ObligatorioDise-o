/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Common.cException;
import Common.cJuego;
import Interfase.PatronObserver;
import Interfase.vJuego;
import Persistencia.pJuego;

/**
 *
 * @author cristian castro
 */
public class dJuego {
    
    PatronObserver PObserver;
    
    public void Modificar(cJuego pJuego) throws cException
    {
        pJuego u = new pJuego();
        u.modificar(pJuego);
    }
    
    public cJuego buscarTodo() throws cException
    {
        pJuego u = new pJuego();
        return u.buscarTodo();
    }
    
    public void ComenzarPartida(PatronObserver pPObserver)
    {
        PObserver = pPObserver;
        vJuego Vistaj = new vJuego(PObserver);
    }
    
    private void TerminarJuego()
    {
        
    }
    
}
