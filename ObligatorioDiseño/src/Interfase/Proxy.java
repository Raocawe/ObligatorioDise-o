/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import Common.Utilidades.tipoRet;
import Common.cUsuario;
/**
 *
 * @author Martin
 */
public class Proxy {
    
    Bingo.
    
    
    
    
    
 
    public tipoRet logear(cUsuario us){
        
        vJuego Juego = new vJuego();
        vHomeAdmin Ha = new vHomeAdmin();
        
        BuscarUsuEspe(us)
                if(us != null)
                {                       
                    //centra la ventana
                    Juego.setLocationRelativeTo(null);
                    //mostramos la ventana
                    Juego.setVisible(true);
                    return tipoRet.OK;
                }
                  else
                {
                      Ha.setVisible(true);
                      return tipoRet.OK;
                  }
              }
            
        
}

 