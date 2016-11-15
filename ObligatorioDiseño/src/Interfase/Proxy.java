/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import Common.Utilidades.tipoRet;
import Common.cException;
import Common.cUsuario;
import Dominio.Bingo;
/**
 *
 * @author Martin
 */
public class Proxy {
    
    Bingo b;
      
    

    public tipoRet logear(cUsuario us) throws cException{
        
        vJuego Juego = new vJuego();
        vHomeAdmin Ha = new vHomeAdmin();
        
        b.buscarUsuario(us);
                
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

 