/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Common.cException;
import Common.cUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author cristian castro
 */
public class pUsuario extends pPersistencia{
    
    public pUsuario()
    {
        super.getInstancia();
    }
    
    @Override
    public void agregar(Object o) throws cException {
        try{
            cUsuario unCliente = (cUsuario)o;
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
            cUsuario unCliente = (cUsuario)o;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
                    String updateSql="UPDATE cliente SET " +
                    "cNombre='" + unCliente.getNombre() + "'" +
                    " WHERE cId=" +  unCliente.getId();
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
            cUsuario unCliente = (cUsuario)o;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String deleteSql="DELETE FROM cliente " +
                    " WHERE cId=" +  unCliente.getId();
            System.out.println(deleteSql);
            st.executeUpdate(deleteSql);
            super.cerrarConexion();
        }
        catch(SQLException e)
        {
            throw new cException("ERROR AL INTENTAR ELIMINAR CLIENTE:" + e.getMessage());
        }
    }
    
    public cUsuario buscar(Object o)throws cException{
        try{
             cUsuario unCliente = (cUsuario)o;

            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String selectSql="SELECT * FROM cliente ";
            if (unCliente.getId() !=0){
                selectSql=selectSql + " WHERE cId=" + unCliente.getId();
            }
            System.out.println(selectSql);
            ResultSet rs=st.executeQuery(selectSql);
            unCliente = null;
            while(rs.next()){
                unCliente = new cCliente();
                int num;
                num = rs.getInt("cId");
                unCliente.setId(num);
                unCliente.setNombre(rs.getString("cNombre"));
            }
            super.cerrarConexion();
            if (unCliente != null){
                return unCliente;
            }else{
                return null;
            }
        }catch(SQLException e){throw new cException("Error al buscar accion:" + e.getMessage());}
    }
    
}
