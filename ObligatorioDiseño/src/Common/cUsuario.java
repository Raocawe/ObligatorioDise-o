/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

/**
 *
 * @author cristian castro
 */
public class cUsuario implements IObjetoFabrica {
    
    private static cUsuario SingleUsuario = null;
    
    public static IObjetoFabrica ObtenerInstancia ()
    {
        if (SingleUsuario == null) {
            SingleUsuario = new cUsuario();
        }
        return SingleUsuario;
    }
    
}
