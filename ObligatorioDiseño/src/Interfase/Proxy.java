/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import Common.Utilidades;
import Common.Utilidades.EnumeradoEstadoJuego;
import Common.Utilidades.EnumeradoResultadoFuncion;
import static Common.Utilidades.VentanasAbiertas;
import Common.Utilidades.tipoRet;
import Common.cException;
import Common.cJuego;
import Common.cUsuario;
import Dominio.Bingo;
import javax.swing.*;
/**
 *
 * @author Martin
 */
public class Proxy {
    
    Bingo b = new Bingo();
    private PatronObserver OPatron;
    
    public Proxy(PatronObserver pOPatron)
    {
        OPatron=pOPatron;
    }
   
<<<<<<< HEAD
    public boolean logear(cUsuario us,vLogin l,PatronObserver pO) throws cException
=======
    public EnumeradoResultadoFuncion logear(cUsuario us) throws cException
>>>>>>> 7068f64033b64c3e38bc27daa71b43393257e377
    {       
        us = b.buscarUsuario(us);
            if(us != null){     
                if(us.getTipo() == Utilidades.EnumeradosTipo.Usuario )
                {
<<<<<<< HEAD
                    l.setVisible(false);
                    vJugador Juego = new vJugador(VentanasAbiertas,us,pO);
                    Juego.setVisible(true);
                    l.setEstado(true);
                    return true;
=======
                    if(Utilidades.EstadoJuego != EnumeradoEstadoJuego.Activado){
                        
                        for(int i=0; i<OPatron.getVentanasJugando().size();i++)//Busca si ese usuario ya esta logueado
                        {
                            if(OPatron.getVentanasJugando().get(i).usu.getIdUsuario() == us.getIdUsuario())
                            {
                                return EnumeradoResultadoFuncion.UsuarioLogeado;
                            }
                        }
                        
                        vJugador Juego = new vJugador(us,OPatron);
                        OPatron.addObserver(Juego);
                        Juego.setVisible(true);
                        return EnumeradoResultadoFuncion.OK; 
                    }    
                    else
                    {
                        return EnumeradoResultadoFuncion.ElJuegoYaComenzo;
                    }
>>>>>>> 7068f64033b64c3e38bc27daa71b43393257e377
                }
                else
                {
                    if(!Utilidades.AdministradorLogueado){
                    vAdmin A = new vAdmin(this);
                    A.setLocationRelativeTo(null);
                    A.setVisible(true);
                    Utilidades.AdministradorLogueado = true;
                    return EnumeradoResultadoFuncion.OK;
                    }
                    else
                        return EnumeradoResultadoFuncion.UsuarioLogeado;
                }
            }
            else 
                return EnumeradoResultadoFuncion.NoExiste;
    }

    public PatronObserver getOPatron() {
        return OPatron;
    }
                  
}

 