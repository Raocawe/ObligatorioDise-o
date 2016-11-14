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
public class cJuego implements IObjetoFabrica {
    
    // <editor-fold defaultstate="collapsed" desc=" Singleton ">
    private static cJuego SingleJuego = null;
    
    public static IObjetoFabrica ObtenerInstancia ()
    {
        if (SingleJuego == null) {
            SingleJuego = new cJuego();
        }
        return SingleJuego;
    }    
    // </editor-fold>

    private int CantidadFilas;
    private int CantidadColumnas;
    private int cantidadMaximaCartonesXJuegadores;
    private int ValorCarton;
    
    public cJuego(){}
    
    // <editor-fold defaultstate="collapsed" desc=" GetSet ">
    /**
     * @return the CantidadFilas
     */
    public int getCantidadFilas() {
        return CantidadFilas;
    }

    /**
     * @param CantidadFilas the CantidadFilas to set
     */
    public void setCantidadFilas(int CantidadFilas) {
        this.CantidadFilas = CantidadFilas;
    }

    /**
     * @return the CantidadColumnas
     */
    public int getCantidadColumnas() {
        return CantidadColumnas;
    }

    /**
     * @param CantidadColumnas the CantidadColumnas to set
     */
    public void setCantidadColumnas(int CantidadColumnas) {
        this.CantidadColumnas = CantidadColumnas;
    }

    /**
     * @return the cantidadMaximaCartonesXJuegadores
     */
    public int getCantidadMaximaCartonesXJuegadores() {
        return cantidadMaximaCartonesXJuegadores;
    }

    /**
     * @param cantidadMaximaCartonesXJuegadores the cantidadMaximaCartonesXJuegadores to set
     */
    public void setCantidadMaximaCartonesXJuegadores(int cantidadMaximaCartonesXJuegadores) {
        this.cantidadMaximaCartonesXJuegadores = cantidadMaximaCartonesXJuegadores;
    }

    /**
     * @return the ValorCarton
     */
    public int getValorCarton() {
        return ValorCarton;
    }

    /**
     * @param ValorCarton the ValorCarton to set
     */
    public void setValorCarton(int ValorCarton) {
        this.ValorCarton = ValorCarton;
    }
    // </editor-fold>
    
}
