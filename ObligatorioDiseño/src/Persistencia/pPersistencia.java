/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Common.cException;
import java.sql.*;

/**
 *
 * @author administrator
 */
public class pPersistencia {

    private static pPersistencia instancia;
    private Connection distribuidora;

    public pPersistencia() {
    }

    public pPersistencia getInstancia() {
        if (instancia == null) {
            instancia = new pPersistencia();
        }
        return instancia;
    }

    public void abrirConexion() throws cException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            distribuidora = DriverManager.getConnection("jdbc:mysql://localhost/admin?user=root&password=root");
            distribuidora.setAutoCommit(true);
        } catch (ClassNotFoundException e) {
            throw new cException("Problemas con el driver:" + e.getMessage());
        } catch (SQLException e1) {
            throw new cException("Problemas con la conexion:" + e1.getMessage());
        }
    }

    public void cerrarConexion() throws cException {
        try {
            distribuidora.close();
        } catch (SQLException e1) {
            throw new cException("Problemas con la conexion:" + e1.getMessage());
        }
    }

    public void setInstancia(pPersistencia val) {
        pPersistencia.instancia = val;
    }

    public Connection getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Connection val) {
        this.distribuidora = val;
    }
    
    public void agregar(Object o) throws cException {
    }

    public void modificar(Object o) throws cException {
    }

    public void eliminar(Object o) throws cException {
    }

}
