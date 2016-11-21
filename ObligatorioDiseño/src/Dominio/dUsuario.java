/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Common.Utilidades;
import Common.cException;
import Common.cJuego;
import Common.cUsuario;
import static Dominio.Bingo.getInstancia;
import Persistencia.pUsuario;


public class dUsuario {
    
    public void Agregar(cUsuario pUsuario) throws cException
    {
        pUsuario u = new pUsuario();
        u.agregar(pUsuario);
    }
    
    public void Modificar(cUsuario pUsuario) throws cException
    {
        pUsuario u = new pUsuario();
        u.modificar(pUsuario);
    }
    
    public void Eliminar(cUsuario pUsuario) throws cException
    {
        pUsuario u = new pUsuario();
        u.eliminar(pUsuario);
    }
    
    public cUsuario buscarAdministrador(cUsuario pUsuario) throws cException
    {
        pUsuario u = new pUsuario();
        return u.buscarAdministrador(pUsuario);
    }
    
    public cUsuario buscarUsuario(cUsuario pUsuario) throws cException
    {
        pUsuario u = new pUsuario();
        return u.buscarUsuario(pUsuario);
    }

    public boolean CompraDeCarton(int pCartones, cUsuario pUsu) throws cException
    {
        Bingo b = getInstancia();
        cJuego cJ = b.buscarTodo();
        int Costo = pCartones*cJ.getValorCarton();
       
        if(pUsu.getSaldo()>= Costo)
        {
            return true;
        }
        return false;
    }
}
