/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Interfase.vLogin;

/**
 *
 * @author cristian castro
 */
public class cHilo implements Runnable{

    private vLogin pantalla;
    
    public cHilo(vLogin p)
    {
        pantalla = p;
    }
    
    @Override
    public void run() {
        
        while(pantalla.isEstado() == false)
        {
            //Esperado A Que Se Logee
        }
    }
    
}
