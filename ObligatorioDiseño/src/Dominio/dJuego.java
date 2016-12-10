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
    Bingo b;
    
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
    
    public void ComenzarPartida()
    {
    }
    
    public void ComenzarPartida(PatronObserver pPObserver,Bingo pB)
    {
        b = pB;
        PObserver = pPObserver;
        vJuego Vistaj = new vJuego(PObserver);
        PObserver.addObserver(Vistaj);
        
    }
    
    private void TerminarJuego()
    {
        
    }
    
}
