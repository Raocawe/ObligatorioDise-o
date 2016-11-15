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
                    "cNombre='" + pJuego.get() + "'" +
                    " WHERE IdUsuario=" +  pJuego.getId();
                    System.out.println(updateSql);
                    st.executeUpdate(updateSql);
                    super.cerrarConexion();
        }catch(SQLException e){
            throw new cException("ERROR AL INTENTAR MODIFICAR CLIENTE:" + e.getMessage());
        }
    }
    
    @Override
    public void eliminar(Object o) throws cException {
        try{
            cJuego pCliente =(cJuego) o;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String deleteSql="DELETE FROM juego " +
                    " WHERE cId=" +  pJuego.getId();
            System.out.println(deleteSql);
            st.executeUpdate(deleteSql);
            super.cerrarConexion();
        }
        catch(SQLException e)
        {
            throw new cException("ERROR AL INTENTAR ELIMINAR CLIENTE:" + e.getMessage());
        }
    }
    
    public cJuego buscarTodo()throws cException{
        try{
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String selectSql="SELECT * FROM juego ";
            if (pJuego.getId() !=0){
                selectSql=selectSql + " WHERE cId=" + pJuego.getId();
            }
            System.out.println(selectSql);
            ResultSet rs=st.executeQuery(selectSql);
            pJuego = null;
            while(rs.next()){
                pJuego = new cJuego();
                int num;
                num = rs.getInt("cId");
                pJuego.setId(num);
                pJuego.setNombre(rs.getString("cNombre"));
            }
            super.cerrarConexion();
            if (pJuego != null){
                return pJuego;
            }else{
                return null;
            }
        }catch(SQLException e){throw new cException("Error al buscar accion:" + e.getMessage());}
    }
    
}
