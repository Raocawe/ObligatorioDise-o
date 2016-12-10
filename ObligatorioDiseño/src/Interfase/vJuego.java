/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import java.util.Observer;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin
 */
public class vJuego extends javax.swing.JFrame implements Observer{

    PatronObserver PObserver;
    
    public vJuego() {
        initComponents();
    }
    
    public vJuego(PatronObserver pPObserver) {
        PObserver = pPObserver;
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumSor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSortearNumero = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        Pozo = new javax.swing.JLabel();
        txtPozo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNumSor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtNumSor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 30, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel2.setText("Numero Sorteado");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        btnSortearNumero.setFont(new java.awt.Font("Yu Mincho", 2, 24)); // NOI18N
        btnSortearNumero.setText("Empezar Juego");
        btnSortearNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortearNumeroActionPerformed(evt);
            }
        });
        getContentPane().add(btnSortearNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, -1));

        jTable2.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Numeros Sorteados"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 250, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TituloBingo.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 330, 250));

        Pozo.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        Pozo.setText("Pozo");
        getContentPane().add(Pozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        txtPozo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        getContentPane().add(txtPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 70, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSortearNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortearNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSortearNumeroActionPerformed

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
            java.util.logging.Logger.getLogger(vJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pozo;
    private javax.swing.JButton btnSortearNumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtNumSor;
    private javax.swing.JTextField txtPozo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(java.util.Observable o, Object arg) {
       if(PObserver.getGanador()==null)
        {
            PObserver.getBolillaSorteada();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "El Juego A Finalizado");
        }
    }

}
