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
    vLogin vl = new vLogin();
   
    public boolean logear(cUsuario us) throws cException
    {       
        us = b.buscarUsuario(us);
            if(us != null){     
                if(us.getTipo() == Utilidades.EnumeradosTipo.Usuario )
                {
                    vl.setVisible(false);
                    vJugador Juego = new vJugador();
                    Juego.setLocationRelativeTo(null);
                    Juego.setVisible(true);
                    return true;
                }
                else
                {
                    vl.setVisible(false);
                    vAdmin A = new vAdmin();
                    A.setLocationRelativeTo(null);
                    A.setVisible(true);
                    return true;
                }
            }
            else 
                return false;
    }
                  
}

 