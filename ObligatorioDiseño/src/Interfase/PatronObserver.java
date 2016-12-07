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
   
    
}
