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
    
    public void agregar(Object o) throws cException {
        try{
            cUsuario pCliente =(cUsuario) o;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
               String insertSql="INSERT INTO cliente(cId,cNombre)" +
               "VALUES(" + pCliente.getId() + " ,'" + pCliente.getNombre()  + "')";
               System.out.println(insertSql);
               st.executeUpdate(insertSql);
               super.cerrarConexion();
        }catch(SQLException e){
            throw new cException("ERROR AL INTENTAR INGRESAR CLIENTE:" + e.getMessage());
        }
    } 
    
    public void modificar(Object o) throws cException {
        try{
            cUsuario pCliente =(cUsuario) o;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
                    String updateSql="UPDATE cliente SET " +
                    "cNombre='" + pCliente.getNombre() + "'" +
                    " WHERE cId=" +  pCliente.getId();
                    System.out.println(updateSql);
                    st.executeUpdate(updateSql);
                    super.cerrarConexion();
        }catch(SQLException e){
            throw new cException("ERROR AL INTENTAR MODIFICAR CLIENTE:" + e.getMessage());
        }
    }
    
    public void eliminar(Object o) throws cException {
        try{
            cUsuario pCliente =(cUsuario) o;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String deleteSql="DELETE FROM cliente " +
                    " WHERE cId=" +  pCliente.getId();
            System.out.println(deleteSql);
            st.executeUpdate(deleteSql);
            super.cerrarConexion();
        }
        catch(SQLException e)
        {
            throw new cException("ERROR AL INTENTAR ELIMINAR CLIENTE:" + e.getMessage());
        }
    }
    
    public cUsuario buscarUsuario(cUsuario pCliente)throws cException{
        try{

            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String selectSql="SELECT * FROM cliente ";
            if (pCliente.getId() !=0){
                selectSql=selectSql + " WHERE cId=" + pCliente.getId();
            }
            System.out.println(selectSql);
            ResultSet rs=st.executeQuery(selectSql);
            pCliente = null;
            while(rs.next()){
                pCliente = new cUsuario();
                int num;
                num = rs.getInt("cId");
                pCliente.setId(num);
                pCliente.setNombre(rs.getString("cNombre"));
            }
            super.cerrarConexion();
            if (pCliente != null){
                return pCliente;
            }else{
                return null;
            }
        }catch(SQLException e){throw new cException("Error al buscar accion:" + e.getMessage());}
    }
    
    public cUsuario buscarAdministrador(Object o)throws cException{
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
