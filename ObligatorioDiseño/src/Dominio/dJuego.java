/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Common.Utilidades;
import Common.cException;
import Common.cJuego;
import Common.cUsuario;
import Interfase.PatronObserver;
import Interfase.vJuego;
import Interfase.vJugador;
import Persistencia.pJuego;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian castro
 */
public class dJuego {
    
    PatronObserver PObserver;
    Bingo b;
    
    public void Modificar(cJuego pJuego) throws cException
    {
        pJuego u = new pJuego();
        u.modificar(pJuego);
    }
    
    public cJuego buscarTodo() throws cException
    {
        pJuego u = new pJuego();
        return u.buscarTodo();
    }
        
    public void ComenzarPartida(PatronObserver pPObserver,Bingo pB) throws InterruptedException, cException
    {
        Utilidades.EstadoJuego = Utilidades.EnumeradoEstadoJuego.Activado;
        b = pB;
        PObserver = pPObserver;
        vJuego Vistaj = new vJuego(PObserver);
        PObserver.addObserver(Vistaj);
        Vistaj.setVisible(true);
        
        ArrayList<Integer> Bolillas = PObserver.getListaDeNumeros();
        while(PObserver.getGanador()==null)
        {
            int indice = (int) (Math.random() * Bolillas.size());
            int Enviar = Bolillas.get(indice);
            Bolillas.remove(indice);
            TirarBolla(Enviar);
        }
        TerminarJuego();
    }
    
    private void TirarBolla(int pNumero) throws InterruptedException
    {
        PObserver.setBolillaSorteada(pNumero);
        Thread.sleep(1000);
    }
    
    private void TerminarJuego() throws cException
    {
        cUsuario u = PObserver.getGanador();
        u.setSaldo(PObserver.getPozo()+u.getSaldo());
        b.ModificarUsuario(u);
        
        // <editor-fold defaultstate="collapsed" desc=" Descuento A Perdedores ">
        ArrayList<vJugador> ventanas = PObserver.getVentanasJugando();
        for(int i = 0; i< ventanas.size();i++)
        {
            cUsuario ur = ventanas.get(i).usu;
            if(ur != u)
            {
                b.ModificarUsuario(ur);
            }
        }
        // </editor-fold>
    }
    
}
