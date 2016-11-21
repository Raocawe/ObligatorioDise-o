/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Common.cException;
import Common.cJuego;
import Common.cUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cristian castro
 */
public class pJuego extends pPersistencia{
    
    public pJuego()
    {
        super.getInstancia();
    }
    
    @Override
    public void modificar(Object o) throws cException {
        try{
            cJuego pJuego =(cJuego) o;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
                    String updateSql="UPDATE juego SET " +
                    "CantidadFilas=" + pJuego.getCantidadFilas()+ "," +
                    "CantidadColumnas=" + pJuego.getCantidadColumnas()+ "," +
                    "CantidadMaximaCartones=" + pJuego.getCantidadMaximaCartonesXJuegadores()+ "," +
                    "ValorCarton=" + pJuego.getValorCarton();
                    System.out.println(updateSql);
                    st.executeUpdate(updateSql);
                    super.cerrarConexion();
        }catch(SQLException e){
            throw new cException("ERROR AL INTENTAR MODIFICAR CLIENTE:" + e.getMessage());
        }
    }
<<<<<<< HEAD
    
    public cJuego buscarTodos(Object o)throws cException{
=======
        
    public cJuego buscarTodo()throws cException{
>>>>>>> 47dc42d846762745c7e020b03000e9887d41aedc
        try{
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String selectSql="SELECT * FROM juego ";
            System.out.println(selectSql);
            ResultSet rs=st.executeQuery(selectSql);
            cJuego p = null;
            while(rs.next()){
                p = new cJuego();
                p.setCantidadColumnas(rs.getInt("CantidadColumnas"));
                p.setCantidadFilas(rs.getInt("CantidadFilas"));
                p.setCantidadMaximaCartonesXJuegadores(rs.getInt("CantidadMaximaCartones"));
                p.setValorCarton(rs.getInt("ValorCarton"));
            }
            super.cerrarConexion();
            if (p != null){
                return p;
            }else{
                return null;
            }
        }catch(SQLException e){throw new cException("Error al buscar accion:" + e.getMessage());}
    }
    
}
