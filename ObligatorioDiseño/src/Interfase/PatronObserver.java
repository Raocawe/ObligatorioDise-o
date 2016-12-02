/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Kingdel
 */
public class PatronObserver extends Observable{
    
    private int BolaSorteada;
    
    public void setBolaSorteada(int pB)
    {
        pB = BolaSorteada;
        setChanged();
	notifyObservers();
    }   

    public int getBolaSorteada() {
        return BolaSorteada;
    }
    
}
