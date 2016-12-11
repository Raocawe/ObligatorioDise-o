/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Interfase.vLogin;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian castro
 */
public class dHilo implements Runnable{

    private vLogin pantalla;
    private boolean Estado;
    
    public dHilo(vLogin pPantalla)
    {
        pantalla = pPantalla;
    }
    
    @Override
    public void run() {
        
        while(pantalla.Estado == true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(dHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
