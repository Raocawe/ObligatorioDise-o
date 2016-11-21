/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Dominio.Bingo;
import Dominio.dJuego;

/**
 *
 * @author cristian castro
 */
public class cSupervisor implements Runnable{

    private Thread[] hilos = new Thread[10];
    private long Espera;
    private Thread[] hilosEnJuego;
    
    public cSupervisor(Thread[] philo, long pEspera)
    {
        hilos = philo;
        verHilosEnJuego();
    }
    
    public void verHilosEnJuego()
    {
        int count = 0;
        for(Thread z : hilos)
        {
            if(z ==null)
            {
                count++;
            }
        }
        hilosEnJuego = new Thread[10-count];
        for(int i = 0; i<hilosEnJuego.length;i++)
        {
            hilosEnJuego[i] = hilos[i]; 
        }
    }
    
    @Override
    public void run() {
        
        for(Thread x : hilosEnJuego)
        {
            while(x.isAlive())
            {
                //Esperado A Que Loguee
            }
        }
        
        Bingo b = new Bingo();
        b.ComenzarPartida();
    }
    
}
