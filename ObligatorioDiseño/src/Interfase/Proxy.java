/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import Common.Utilidades;
import Common.Utilidades.tipoRet;
import Common.cException;
import Common.cUsuario;
import Dominio.Bingo;
import javax.swing.JOptionPane;
/**
 *
 * @author Martin
 */
public class Proxy {
    
    Bingo b = new Bingo();
   
    public tipoRet logear(cUsuario us) throws cException{
        
        
        vJuego Juego = new vJuego();
        vAdmin A = new vAdmin();
        
        b.buscarUsuario(us);
                
                if(us.getTipo() == Utilidades.EnumeradosTipo.Usuario )
                {                       
                    //centra la ventana
                    Juego.setLocationRelativeTo(null);
                    //mostramos la ventana
                    Juego.setVisible(true);
                    return tipoRet.OK;
                }
                else if (us.getTipo() == Utilidades.EnumeradosTipo.Usuario)
                {
                      A.setVisible(true);
                      return tipoRet.OK;
                  }
                
                else
                {
                   //hola
                }
              }
                  
}

 