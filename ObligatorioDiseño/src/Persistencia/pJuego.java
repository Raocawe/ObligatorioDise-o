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
    public void agregar(Object o) throws cException {
        try{
            cJuego unCliente = (cJuego)o;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
               String insertSql="INSERT INTO cliente(cId,cNombre)" +
               "VALUES(" + unCliente.getId() + " ,'" + unCliente.getNombre()  + "')";
               System.out.println(insertSql);
               st.executeUpdate(insertSql);
               super.cerrarConexion();
        }catch(SQLException e){
            throw new cException("ERROR AL INTENTAR INGRESAR CLIENTE:" + e.getMessage());
        }
    }
    
    @Override
    public void modificar(Object o) throws cException {
        try{
            cJuego unJuego = (cJuego)o;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
                    String updateSql="UPDATE juego SET " +
                    "cNombre='" + unJuego.getNombre() + "'" +
                    " WHERE cId=" +  unJuego.getId();
                    System.out.println(updateSql);
                    st.executeUpdate(updateSql);
                    super.cerrarConexion();
        }catch(SQLException e){
            throw new cException("ERROR AL INTENTAR MODIFICAR CLIENTE:" + e.getMessage());
        }
    }
    
    public cJuego buscarTodos(Object o)throws cException{
        try{
             cJuego unJuego = (cJuego)o;

            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String selectSql="SELECT * FROM juego ";
            if (unJuego.getId() !=0){
                selectSql=selectSql + " WHERE cId=" + unJuego.getId();
            }
            System.out.println(selectSql);
            ResultSet rs=st.executeQuery(selectSql);
            unJuego = null;
            while(rs.next()){
                unJuego = new cJuego();
                int num;
                num = rs.getInt("cId");
                unJuego.setId(num);
                unJuego.setNombre(rs.getString("cNombre"));
            }
            super.cerrarConexion();
            if (unJuego != null){
                return unJuego;
            }else{
                return null;
            }
        }catch(SQLException e){throw new cException("Error al buscar accion:" + e.getMessage());}
    }
    
}
