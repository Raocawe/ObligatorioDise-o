/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import static Common.Utilidades.*;
import Common.cException;
import Common.cJuego;
import Common.cUsuario;
import Dominio.Bingo;
import static Dominio.Bingo.getInstancia;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class vJugador extends javax.swing.JFrame implements Observer{

    Bingo b = getInstancia();;
    cUsuario usu ;
    cJuego j;
    int CantidadCartones;
    int CantXCarton;
    DefaultTableModel[] Tablas;
    JTable[] Tablass;
            
    public vJugador(){}
            
    public vJugador(cUsuario pusu) throws cException {
        usu = pusu;
        j = b.buscarTodo();
        
        initComponents();
        
        // <editor-fold defaultstate="collapsed" desc=" Compra De Cartones ">
        String Resultado = "Testeando";
        while(Validar(Resultado) != EnumeradosVentana.Ok)
        {
            Resultado = (JOptionPane.showInputDialog(this, "¿Con Cuantos Cartones Jugara?", "1 -"+j.getCantidadMaximaCartonesXJuegadores()));
            if(Validar(Resultado) == EnumeradosVentana.Ok)
            {
                break;
            }
                
            if(Validar(Resultado) == EnumeradosVentana.NoNumero || Validar(Resultado) == EnumeradosVentana.NoValido){ 
               JOptionPane.showMessageDialog(this, "Ingrese Un Numero Entre"
                    + "\n 1 - "+ Integer.toString(VentanasAbiertas)); 
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Su Saldo No Es Suficiente");
                Resultado = "Testeando";
            }
        }
        CantidadCartones = Integer.parseInt(Resultado);
        
        
        // </editor-fold>
        
        ManejoTablas();
        
        VentanasLogueadas++;
        if(VentanasAbiertas==VentanasLogueadas)
        {
            b.ComenzarPartida();
        }
    }
    
    private EnumeradosVentana Validar(String pResultado) throws cException
    {
        if(!isNumeric(pResultado))
        {
            return EnumeradosVentana.NoNumero;
        }
        if(Integer.parseInt(pResultado)>j.getCantidadMaximaCartonesXJuegadores()&&Integer.parseInt(pResultado)<1)
        {
            return EnumeradosVentana.NoValido;
        }
        if(!b.CompraDeCarton(VentanasAbiertas, usu))
        {
            return EnumeradosVentana.NoSaldo;
        }
        return EnumeradosVentana.Ok;
    }
    
    private void ManejoTablas()
    {      
        int CantFi = j.getCantidadFilas();
        int CantC = j.getCantidadColumnas();
        tblCarton2.setVisible(false);
        tblCarton3.setVisible(false);
        tblCarton4.setVisible(false);
        Tablas = new DefaultTableModel[CantidadCartones];
        Tablass = new JTable[CantidadCartones];
        
        //<editor-fold defaultstate="collapsed"  desc="CargaVariablesTablas">
        tblCarton1.setVisible(true);
        DefaultTableModel tb1 = (DefaultTableModel) this.tblCarton1.getModel();
        Tablas[0] = tb1;
        Tablass[0] = tblCarton1;                                    //FinTabla1
        
        DefaultTableModel tb2 = (DefaultTableModel) this.tblCarton2.getModel();
         if(CantidadCartones>=2){
             tblCarton2.setVisible(true);
             Tablas[1] = tb2;
             Tablass[1] = tblCarton2;
         }                                                          //FinTabla2
         
        DefaultTableModel tb3 = (DefaultTableModel) this.tblCarton3.getModel();
        if(CantidadCartones>=3){
            tblCarton3.setVisible(true);
            Tablas[2] = tb3;
            Tablass[2] = tblCarton3;
        }                                                           //FinTabla3
        
        DefaultTableModel tb4 = (DefaultTableModel) this.tblCarton4.getModel();
        if(CantidadCartones==4){
            tblCarton4.setVisible(true);
            Tablas[3] = tb4;
            Tablass[3] = tblCarton4;
        }                                                           //FinTabla4
        //</editor-fold>
        
        CantXCarton = CantFi * CantC;
        int CantNumAleatorio = CantXCarton* CantidadCartones;
        
        //<editor-fold defaultstate="collapsed"  desc="CargandoArrayNumeros">
        ArrayList<Integer> ListaNumeros = new ArrayList<Integer>();
        for(int i=0;i<CantNumAleatorio;i++)
        {
            ListaNumeros.add(i);
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed"  desc="CargarTabla">
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        String[] colum = new String[CantC];
        for(int tab=0; tab<Tablas.length;tab++){//recorre las tablas a listar
            
            for (int x = 0 ; x < CantFi ; x++ ){//recorre las filas de la tabla
                if(x==0){
                    for(int t = 0; t<colum.length;t++){//carga los valores de la fila
                    int entero = (int) (Math.random()*ListaNumeros.size());  
                    Tablas[tab].addColumn(ListaNumeros.get(entero));
                    ListaNumeros.remove(entero);
                    }
                }
                else
                {  
                    for(int t = 0; t<colum.length;t++){//carga los valores de la fila
                        int entero = (int) (Math.random()*ListaNumeros.size());
                        colum[t] = String.valueOf(ListaNumeros.get(entero));     
                        ListaNumeros.remove(entero);
                    }
                    Tablas[tab].addRow(colum);    
                } 
            }  
            
            Tablass[tab].setModel(Tablas[tab]); 
            Tablass[tab].getTableHeader().setBackground(Color.white);
            for(int t = 0; t<colum.length;t++){//Alinea las celdas al centro
                   Tablass[tab].getColumnModel().getColumn(t).setCellRenderer(tcr);
            }
            
        }
                //</editor-fold>
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarton3 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCarton4 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCarton1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCarton2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtPozo = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCarton3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCarton3);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 300, 130));

        tblCarton4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblCarton4);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 300, 120));

        tblCarton1.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        tblCarton1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCarton1.setSurrendersFocusOnKeystroke(true);
        jScrollPane3.setViewportView(tblCarton1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 300, 130));

        tblCarton2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblCarton2);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 300, 120));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel1.setText("Pozo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, -1));

        txtPozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPozoActionPerformed(evt);
            }
        });
        getContentPane().add(txtPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 70, 30));

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 70, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel2.setText("Monto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Rectangulo.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPozoActionPerformed
        //
    }//GEN-LAST:event_txtPozoActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

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
            java.util.logging.Logger.getLogger(vJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vJugador().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblCarton1;
    private javax.swing.JTable tblCarton2;
    private javax.swing.JTable tblCarton3;
    private javax.swing.JTable tblCarton4;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtPozo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
