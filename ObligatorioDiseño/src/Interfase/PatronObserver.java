/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author cristian castro
 */
public class PatronObserver extends Observable{
    
    private int BolillaSorteada;
    private int Pozo;
    private int CartonesEnJuego;
    private int VentanasJugando;
    private boolean Termino = false;

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

    public boolean isTermino() {
        return Termino;
    }

    public void setTermino(boolean Termino) {
        this.Termino = Termino;
        setChanged();
        notifyObservers();
    }

    public int getCartonesEnJuego() {
        return CartonesEnJuego;
    }

    public void setCartonesEnJuego(int CartonesEnJuego) {
        this.CartonesEnJuego = CartonesEnJuego;
        setChanged();
        notifyObservers();
    }

    public int getVentanasJugando() {
        return VentanasJugando;
    }

    public void setVentanasJugando(int VentanasJugando) {
        this.VentanasJugando = VentanasJugando;
        setChanged();
        notifyObservers();
    }
   
    
}
