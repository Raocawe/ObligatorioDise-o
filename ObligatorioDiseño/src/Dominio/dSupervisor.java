/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Common.cException;
import Common.cJuego;
import Interfase.PatronObserver;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian castro
 */
public class dSupervisor implements Runnable{

    private Thread[] hilos;
    private PatronObserver OPatron;
    private cJuego j;
    
    public dSupervisor(Thread[] philo, PatronObserver pOPatron)
    {
        OPatron = pOPatron;
        hilos = philo;
    }
        
    @Override
    public void run() {
        
        for(Thread x : hilos)
        {
            while(x.isAlive())
            {
                //Esperado A Que Loguee
            }
        }
        
        Bingo b = new Bingo();
        try {
            j = b.buscarTodo();
        } catch (cException ex) {
            Logger.getLogger(dSupervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        int Pozo = OPatron.getCartonesEnJuego() * j.getValorCarton();
        OPatron.setPozo(Pozo);
        try {
            b.ComenzarPartida(OPatron,b);
        } catch (InterruptedException ex) {
            Logger.getLogger(dSupervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}