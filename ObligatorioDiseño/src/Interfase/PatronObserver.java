/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import Common.cUsuario;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author cristian castro
 */
public class PatronObserver extends Observable{
    
    private cUsuario Ganador;
    private int BolillaSorteada;
    private int Pozo;
    private int CartonesEnJuego;
    private ArrayList<vJugador> VentanasJugando;

    public int getBolillaSorteada() {
        return BolillaSorteada;
    }

    public void setBolillaSorteada(int BolillaSorteada) {
        this.BolillaSorteada = BolillaSorteada;
        setChanged();
        notifyObservers();
    }

    public int getPozo() {
        return Pozo;
    }

    public void setPozo(int Pozo) {
        this.Pozo = Pozo;
        setChanged();
        notifyObservers();
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
        setChanged();
        notifyObservers();
    }

    public cUsuario getGanador() {
        return Ganador;
    }

    public void setGanador(cUsuario Ganador) {
        this.Ganador = Ganador;
        setChanged();
        notifyObservers();
    }
   
    
}
