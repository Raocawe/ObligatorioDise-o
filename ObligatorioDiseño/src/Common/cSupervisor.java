/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Dominio.Bingo;
import Dominio.dJuego;
import Interfase.PatronObserver;
import Interfase.vJuego;

/**
 *
 * @author cristian castro
 */
public class cSupervisor implements Runnable{

    private Thread[] hilos;
    private long Espera;
    private PatronObserver OPatron;
    
    public cSupervisor(Thread[] philo, long pEspera, PatronObserver pOPatron)
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
        vJuego juego = new vJuego(OPatron);
        b.ComenzarPartida();
    }
    
}
