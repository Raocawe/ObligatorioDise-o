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
    private boolean Estado = true;
    
    public cHilo()
    {}
    
    @Override
    public void run() {
        
        while(Estado == true)
        {
            //Esperado A Que Se Logee
        }
    }
    
}
