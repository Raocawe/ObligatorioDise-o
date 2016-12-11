/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Common.cException;
import Common.cJuego;
import Common.cUsuario;
import Interfase.PatronObserver;
import Interfase.vJuego;
import Persistencia.pJuego;
import java.util.ArrayList;

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
        b = pB;
        PObserver = pPObserver;
        vJuego Vistaj = new vJuego(PObserver);
        PObserver.addObserver(Vistaj);
        
        ArrayList<Integer> Bolillas = CargarLista();
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
    }
    
    private ArrayList<Integer> CargarLista()
    {
        ArrayList<Integer> ListaNumeros = new ArrayList<Integer>();
        ListaNumeros.add(00);
        for(int i=1;i<100;i++)
        {
            ListaNumeros.add(i);
        }
        return ListaNumeros;
    }
    
}
