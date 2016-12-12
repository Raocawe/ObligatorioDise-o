/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import Common.cException;
import Common.cUsuario;
import Dominio.Bingo;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author cristian castro
 */
public class PatronObserver extends Observable{
    
    private Bingo b = new Bingo();
    private ArrayList<Integer> ListaDeNumeros = new ArrayList<Integer>();       //Numeros que si o si saldran sorteados
    private cUsuario Ganador = null;
    private int BolillaSorteada;
    private int Pozo;
    private int CartonesEnJuego = 0;
    private int CartonesIniciles;
    private int VentanasIniciales;
    private ArrayList<vJugador> VentanasJugando = new ArrayList<vJugador>();
    private int CantidadCartones = 0;

    // <editor-fold defaultstate="collapsed" desc=" FuncionesQueNotifican ">
    public void setBolillaSorteada(int BolillaSorteada) {
        this.BolillaSorteada = BolillaSorteada;
        setChanged();
        notifyObservers();
    }
    
    public void setGanador(cUsuario Ganador) {
        this.Ganador = Ganador;
        setChanged();
        notifyObservers();
    }
    
    public void setPozo(int Pozo) {
        this.Pozo = Pozo;
        setChanged();
        notifyObservers();
    }
    // </editor-fold>
    
    public int getBolillaSorteada() {
        return BolillaSorteada;
    }

    public int getPozo() {
        return Pozo;
    }

    public int getCartonesEnJuego() {
        return CartonesEnJuego;
    }

    public void setCartonesEnJuego(int CartonesEnJuego) {
        this.CartonesEnJuego += CartonesEnJuego;
    }

    public ArrayList<vJugador> getVentanasJugando() {
        return VentanasJugando;
    }

    public void setVentanasJugando(vJugador VentanasJugando) {
        this.VentanasJugando.add(VentanasJugando);
    }

    public cUsuario getGanador() {
        return Ganador;
    }

    public int getCantidadCartones() {
        return CantidadCartones;
    }

    public void setCantidadCartones(int CantidadCartones) {
        this.CantidadCartones = CantidadCartones;
    }

    public int getVentanasIniciales() {
        return VentanasIniciales;
    }

    public void setVentanasIniciales(int VentanasIniciales) {
        this.VentanasIniciales = VentanasIniciales;
    }

    public int getCartonesIniciles() {
        return CartonesIniciles;
    }

    public void setCartonesIniciles(int CartonesIniciles) {
        this.CartonesIniciles = CartonesIniciles;
    }
   
    public void calcularPozo() throws cException
    {
        int valorCarton = b.buscarTodo().getValorCarton();
        int retorno = (CartonesIniciles*valorCarton)+(CartonesEnJuego*valorCarton);
        setPozo(retorno);
    }

    public ArrayList<Integer> getListaDeNumeros() {
        return ListaDeNumeros;
    }

    public void setListaDeNumeros(ArrayList<Integer> ListaDeNumeros) {
        this.ListaDeNumeros = ListaDeNumeros;
    }
    
}
