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

<<<<<<< HEAD
    
    //dasfasdfasdfa
  
    
=======
>>>>>>> f6b7e3aa9d96eb3f3a362f4ae548e7d72cca662b
    public tipoRet logear(cUsuario us) throws cException{
        
        
        vJuego Juego = new vJuego();
        vAdmin Ha = new vAdmin();
        
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

 