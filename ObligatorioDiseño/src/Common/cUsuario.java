/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Common.Utilidades.EnumeradosTipo;

/**
 *
 * @author cristian castro
 */
public class cUsuario implements IObjetoFabrica {
    
    // <editor-fold defaultstate="collapsed" desc=" Singleton ">
    private static cUsuario SingleUsuario = null;
    
    public static IObjetoFabrica ObtenerInstancia ()
    {
        if (SingleUsuario== null) {
            SingleUsuario = new cUsuario();
        }
        return SingleUsuario;
    }
    // </editor-fold>

    private int IdUsuario;
    private String Nombre;
    private String Apellido;
    private String Contraseña;
    private String Usuario;
    private int Saldo;
    private EnumeradosTipo Tipo;
    
    public cUsuario(){}

    // <editor-fold defaultstate="collapsed" desc=" GetSet ">
        /**
     * @return the IdUsuario
     */
    public int getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the Contraseña
     */
    public String getContraseña() {
        return Contraseña;
    }

    /**
     * @param Contraseña the Contraseña to set
     */
    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Saldo
     */
    public int getSaldo() {
        return Saldo;
    }

    /**
     * @param Saldo the Saldo to set
     */
    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }
    
    /**
     * @return the Tipo
     */
    public EnumeradosTipo getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(EnumeradosTipo Tipo) {
        this.Tipo = Tipo;
    }
    // </editor-fold>

}
