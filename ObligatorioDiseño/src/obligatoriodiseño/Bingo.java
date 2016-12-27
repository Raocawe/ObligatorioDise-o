/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatoriodiseño;

import Common.Utilidades;
import Common.cException;
import Common.cJuego;
import static Dominio.Bingo.getInstancia;
import Interfase.PatronObserver;
import Interfase.Proxy;
import Interfase.vLogin;

/**
 *
 * @author cristian castro
 */
public class Bingo {

    public static void main(String[] args) throws cException {
        PatronObserver patronO = new PatronObserver();
        Proxy proxy = new Proxy(patronO);
        vLogin Login = new vLogin(proxy);        
        Login.setVisible(true);
    }
   
}
