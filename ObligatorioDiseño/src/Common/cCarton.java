/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Persistencia.pPersistencia;

/**
 *
 * @author cristian castro
 */
public class cCarton implements IObjetoFabrica{
    
    private static cCarton SingleCarton = null;
    
    public static IObjetoFabrica ObtenerInstancia ()
    {
        if (SingleCarton == null) {
            SingleCarton = new cCarton();
        }
        return SingleCarton;
    }    
}
