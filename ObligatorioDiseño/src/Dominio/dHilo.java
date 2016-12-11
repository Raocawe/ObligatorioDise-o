/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Interfase.vLogin;

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
            
        }
    }
    
}
