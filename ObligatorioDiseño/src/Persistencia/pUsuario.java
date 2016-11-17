/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Common.Utilidades;
import Common.Utilidades.EnumeradosTipo;
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
               String insertSql="INSERT INTO usuario(Saldo,Nombre,Apellido,Usuario,Contraseña,Tipo,IdUsuario)" +
               "VALUES(" + pCliente.getSaldo()+ " ,'" + pCliente.getNombre()  + "','" + pCliente.getApellido()  + "','" + pCliente.getUsuario()  + "',"
                       + "'" + pCliente.getContraseña()+ "','" + pCliente.getTipo().toString() + "'," + generarIdUsuario()  + ")";
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
                    String updateSql="UPDATE usuario SET " +
                    "Nombre='" + pCliente.getNombre() + "'" +
                    "Apellido='" + pCliente.getApellido() + "'" +
                    "Usuario='" + pCliente.getUsuario() + "'" +
                    "Contraseña='" + pCliente.getContraseña() + "'" +
                    "Saldo=" + pCliente.getSaldo() +
                    "Tipo='" + pCliente.getTipo().toString() + "'" +
                    " WHERE IdUsuario=" +  pCliente.getIdUsuario();
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
                    " WHERE IdUsuario=" +  pCliente.getIdUsuario();
            System.out.println(deleteSql);
            st.executeUpdate(deleteSql);
            super.cerrarConexion();
        }
        catch(SQLException e)
        {
            throw new cException("ERROR AL INTENTAR ELIMINAR CLIENTE:" + e.getMessage());
        }
    }
    
    public int generarIdUsuario()throws cException{
        try{
            int num;
            int id;
            num = 100;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String selectSql="SELECT MAX(IdUsuario) FROM usuario";
            System.out.println(selectSql);
            ResultSet rs=st.executeQuery(selectSql);
            while(rs.next()){
                num = rs.getInt("MAX(IdUsuario)");
                num = num +1;
            }
            super.cerrarConexion();
            return num;
        }catch(SQLException e){throw new cException("Error al buscar el código:" + e.getMessage());}
    }
    
    public cUsuario buscarUsuario(cUsuario pCliente)throws cException{
        try{

            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String selectSql="SELECT * FROM usuario ";
            if (pCliente.getIdUsuario() !=0){
                selectSql=selectSql + " WHERE Usuario='" + pCliente.getUsuario()+ "' and Contraseña ='"+ pCliente.getContraseña()+"'";
            }
            System.out.println(selectSql);
            ResultSet rs=st.executeQuery(selectSql);
            pCliente = null;
            while(rs.next()){
                pCliente = new cUsuario();
                int num;
                num = rs.getInt("IdUsuario");
                pCliente.setIdUsuario(num);
                pCliente.setNombre(rs.getString("Nombre"));
                pCliente.setApellido(rs.getString("Apellido"));
                pCliente.setUsuario(rs.getString("Usuario"));
                pCliente.setContraseña(rs.getString("Contraseña"));
                pCliente.setTipo(EnumeradosTipo.Usuario);
                pCliente.setSaldo(rs.getInt("Saldo"));
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
             cUsuario pCliente = (cUsuario)o;
            super.abrirConexion();
            Statement st= super.getDistribuidora().createStatement();
            String selectSql="SELECT * FROM usuario ";
            if (pCliente.getIdUsuario() !=0){
                selectSql=selectSql + " WHERE IdUsuario=" + pCliente.getIdUsuario() + "and Tipo ='"+ EnumeradosTipo.Admin.toString()+"'";
            }
            System.out.println(selectSql);
            ResultSet rs=st.executeQuery(selectSql);
            pCliente = null;
            while(rs.next()){
                pCliente = new cUsuario();
                int num;
                num = rs.getInt("IdUsuario");
                pCliente.setIdUsuario(num);
                pCliente.setNombre(rs.getString("Nombre"));
                pCliente.setApellido(rs.getString("Apellido"));
                pCliente.setUsuario(rs.getString("Usuario"));
                pCliente.setContraseña(rs.getString("Contraseña"));
                pCliente.setTipo(EnumeradosTipo.Admin);
                pCliente.setSaldo(rs.getInt("Saldo"));
            }
            super.cerrarConexion();
            if (pCliente != null){
                return pCliente;
            }else{
                return null;
            }
        }catch(SQLException e){throw new cException("Error al buscar accion:" + e.getMessage());}
    }
    
}
