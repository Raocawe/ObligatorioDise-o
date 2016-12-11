/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import Common.Utilidades;
import Common.Utilidades.EnumeradoEstadoJuego;
import static Common.Utilidades.VentanasAbiertas;
import Common.Utilidades.tipoRet;
import Common.cException;
import Common.cJuego;
import Dominio.Bingo;
import Dominio.dHilo;
import Dominio.dSupervisor;
import Interfase.vLogin;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author MartinH
 */
public class vAdmin extends javax.swing.JFrame{

    Thread[] Threads; 
    
    int CantCarMax;
    int CantColumn;
    int CantFilas;
    int Precio = 0;
    private Proxy Prox;
    
    public vAdmin(Proxy pProx) {
        Prox = pProx;
        initComponents();
        Utilidades.EstadoJuego = EnumeradoEstadoJuego.Getion;
    }
    
    public vAdmin(){}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        ComboxJ = new javax.swing.JComboBox();
        btnAgregarJug = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantFilas = new javax.swing.JTextField();
        txtCantColumn = new javax.swing.JTextField();
        txtCantCarJug = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnGuardarConfig = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ComboxJ.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        ComboxJ.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4" }));
        ComboxJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboxJActionPerformed(evt);
            }
        });
        jPanel1.add(ComboxJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 80, 50));

        btnAgregarJug.setFont(new java.awt.Font("Yu Mincho", 2, 24)); // NOI18N
        btnAgregarJug.setText("Comenzar Partida");
        btnAgregarJug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarJugActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 430));

        jTabbedPane1.addTab("Jugar", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Monospaced", 2, 24)); // NOI18N
        jLabel1.setText("Configuraciones");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel2.setText("Filas Carton");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel3.setText("Columnas Carton");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel4.setText("Cantidad Cartones");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel5.setText("Precio");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));
        jPanel2.add(txtCantFilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 30, 30));
        jPanel2.add(txtCantColumn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 30, 30));
        jPanel2.add(txtCantCarJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 30, 30));
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 30, 30));

        btnGuardarConfig.setFont(new java.awt.Font("Yu Mincho", 2, 24)); // NOI18N
        btnGuardarConfig.setText("Guardar Configuraciones");
        btnGuardarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarConfigActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel6.setText("por Jugadores");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -90, -1, -1));

        jTabbedPane1.addTab("Configuraciones", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    
    
    private void btnAgregarJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarJugActionPerformed
        Utilidades.EstadoJuego = EnumeradoEstadoJuego.Activado;
        vLogin p;
        // <editor-fold defaultstate="collapsed" desc=" AberturaDePantallas ">     
        String CantJ = (String) ComboxJ.getSelectedItem();
        VentanasAbiertas = Integer.valueOf(CantJ);
        Threads = new Thread[VentanasAbiertas];
        
        for(int i=0; i<VentanasAbiertas; i++)
        { 
           p = new vLogin(Prox);
           p.setVisible(true);
           
           Thread y = new Thread(new dHilo(p));
           Threads[i] = y;
           y.start();
        }
        Thread y = new Thread(new dSupervisor(Threads,Prox.getOPatron()));
        y.start();
        // </editor-fold>

        this.setVisible(false);
    }//GEN-LAST:event_btnAgregarJugActionPerformed


    private void btnGuardarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarConfigActionPerformed
        
        CantCarMax = Integer.parseInt(this.txtCantCarJug.getText().toString());
        CantColumn = Integer.parseInt(this.txtCantColumn.getText().toString());
        Precio = Integer.parseInt(this.txtPrecio.getText().toString());
        CantFilas = Integer.parseInt(this.txtCantFilas.getText().toString());
        
        tipoRet resultado = Validar();
        if(resultado == tipoRet.OK)
        {
            Bingo b = Bingo.getInstancia();
            cJuego j = (cJuego)b.CrearObjeto(Utilidades.EnumeradosFabrica.Juego);
            j.setCantidadColumnas(CantColumn);
            j.setCantidadFilas(CantFilas);
            j.setCantidadMaximaCartonesXJuegadores(CantCarMax);
            j.setValorCarton(Precio);
            
            try {
                b.ModificarConfiguracion(j);
                JOptionPane.showMessageDialog(this, "Configuraciones Modificadas", "Login", JOptionPane.INFORMATION_MESSAGE);
            } catch (cException ex) {
                Logger.getLogger(vAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(resultado == tipoRet.CantColumE)
        {
            JOptionPane.showMessageDialog(this, "ERROR 'CantidadColumnas' No Cumple Con Las Reglas\n"
                    + "Valor(1-5)", "Login", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(resultado == tipoRet.CantFilaE)
        {
            JOptionPane.showMessageDialog(this, "ERROR 'CantidadFilas' No Cumple Con Las Reglas\n"
                    + "Valor(1-5)", "Login", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(resultado == tipoRet.CartonesE)
        {
            JOptionPane.showMessageDialog(this, "ERROR 'CantidadDeCartonesPorJugador' \nNo Cumple Con Las Reglas"
                    + "Valor(1-4)", "Login", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(resultado == tipoRet.Precio)
        {
            JOptionPane.showMessageDialog(this, "ERROR 'Precio' No Cumple Con Las Reglas\n"
                    + "Ingrese un valor mayor a cero", "Login", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarConfigActionPerformed

    private void ComboxJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboxJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboxJActionPerformed
    
    public tipoRet Validar()
    {
        if(CantCarMax<5&&CantCarMax>0)
        {
            if(CantColumn<6&&CantColumn>0)
            {
                if(CantFilas<6&&CantFilas>0)
                {
                    if(Precio > 0)
                    {
                        return tipoRet.OK;
                    }
                    return tipoRet.Precio;
                }
                return tipoRet.CantFilaE;
            }
            return tipoRet.CantColumE;
        }
        return tipoRet.CartonesE;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboxJ;
    private javax.swing.JButton btnAgregarJug;
    private javax.swing.JButton btnGuardarConfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtCantCarJug;
    private javax.swing.JTextField txtCantColumn;
    private javax.swing.JTextField txtCantFilas;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
