/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.text.SimpleDateFormat;

/**
 *
 * @author cristian castro
 */
public class Utilidades {
       
    public static int VentanasAbiertas = 0;
    public static int VentanasLogueadas = 0;
    
    public static enum EnumeradosTipo {
    
    Admin,Usuario
    
    }
    
     public static enum EnumeradosVentana {
        
    NoNumero,NoValido,NoSaldo,Ok
    
    }
    
    public static enum EnumeradosFabrica {
        
    Usuario,Juego
    
    }
    
    public static enum tipoRet{
    CantFilaE,CantColumE,Precio,CartonesE,OK
    }
    
    public static SimpleDateFormat FormatoFecha = new SimpleDateFormat("yyyy-mm-dd");
    
    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
