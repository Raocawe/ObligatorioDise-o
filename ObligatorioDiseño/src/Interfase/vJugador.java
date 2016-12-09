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
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class vJugador extends javax.swing.JFrame implements Observer{

    Bingo b = getInstancia();;
    cUsuario usu ;
    cJuego j;
    int CantidadCartones;
    int CantXCarton;
    JTable[] Tablas;
            
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
    
    public void ManejoTablas()
    {      
        int CantFi = j.getCantidadFilas();
        int CantC = j.getCantidadColumnas();
        Integer[] filas = new Integer[CantFi];
        Integer[] columnas = new Integer[CantC];
        tblCarton2.setVisible(false);
        tblCarton3.setVisible(false);
        tblCarton4.setVisible(false);
        Tablas = new JTable[CantidadCartones];
        //<editor-fold defaultstate="collapsed"  desc="CargaDeTablas">
        tblCarton1.setVisible(true);
        DefaultTableModel tb1 = (DefaultTableModel) this.tblCarton1.getModel();
        tb1.addColumn(columnas);
        tb1.addRow(filas);
        tblCarton1.setModel(tb1);
        Tablas[0] = tblCarton1;                                                //FinTabla1
        
        DefaultTableModel tb2 = (DefaultTableModel) this.tblCarton2.getModel();
         if(CantidadCartones>=2){
             tb2.addColumn(columnas);
             tb2.addRow(filas);
             tblCarton2.setModel(tb2);
             Tablas[1] = tblCarton2;
         }                                                          //FinTabla2
         
        DefaultTableModel tb3 = (DefaultTableModel) this.tblCarton3.getModel();
        if(CantidadCartones>=3){
            tb3.addColumn(columnas);
            tb3.addRow(filas);
            tblCarton3.setModel(tb3);
            Tablas[2] = tblCarton3;
        }                                                           //FinTabla3
        
        DefaultTableModel tb4 = (DefaultTableModel) this.tblCarton4.getModel();
        if(CantidadCartones==4){
            tb4.addColumn(columnas);
            tb4.addRow(filas);
            tblCarton4.setModel(tb4);
            Tablas[3] = tblCarton4;
        }                                                           //FinTabla4
        //</editor-fold>
        CantXCarton = CantFi * CantC;
        int CantNumAleatorio = CantXCarton* CantidadCartones;
        //<editor-fold defaultstate="collapsed"  desc="CargandoArray">
        ArrayList<Integer> ListaNumeros = new ArrayList<Integer>();
        for(int i=0;i<CantNumAleatorio;i++)
        {
            ListaNumeros.add(i);
        }
        //</editor-fold>
        int Tabla=0;
        boolean aux = false;
        
        while(Tablas[Tabla]!=null){
            for (int x = 0 ; x < CantC ; x++ ){
                for(int i = 0 ; i < CantFi ; i++){
                    int entero = ListaNumeros.get((int) (Math.random()*CantNumAleatorio + 1));
                    if(SeleccionarTabla(i,Tabla))
                    {
                        Tabla++;
                        aux = true;
                        break;
                    }
                    Tablas[Tabla].setValueAt(entero, i, x);
                }
                if(aux==true)
                {aux = false;
                break;}
            }
        }
        
        
        
        /*
        tb1.setValueAt(entero,CantFi,CantC);
        
         int[][] matrizNumAlea = new int[CantC][CantFi];
            for (int x = 0 ; x < CantC ; x++ ){
                for(int i = 0 ; i < CantFi ; i++){
                    matrizNumAlea[x][i] = (int) (Math.random()*CantNumAleatorio + 1);
                   
                }
            }
        */
    }
        public boolean SeleccionarTabla(int Cantidad,int pTabla)
        {
            if(CantXCarton==Cantidad)
            {
                return true;
            }
            return false;
        }
          
           
            
                
             
   
        //unaLinea.setCantidad(parseInt(txtCantidad.getText().toString()));
          //  unaLinea.setElProducto((cProducto)comboProductos.getItemAt(comboProductos.getSelectedIndex()).getValor());
            //DefaultTableModel tb = (DefaultTableModel) this.tblLineasFactura.getModel();
            //tb.addRow(new Object[]{new Integer(unaLinea.getId()), new Integer(unaLinea.getElProducto().getId()),new String(unaLinea.getElProducto().getNombre()), new Integer(unaLinea.getCantidad()) });

    //@Override
    //public void update(Observable o, Object arg) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        
        
        
    

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblCarton3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tblCarton3);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 307, 114));

        tblCarton4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane2.setViewportView(tblCarton4);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 307, 114));

        tblCarton1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblCarton1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, 307, 114));

        tblCarton2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane4.setViewportView(tblCarton2);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 307, 114));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel1.setText("Pozo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        txtPozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPozoActionPerformed(evt);
            }
        });
        getContentPane().add(txtPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 70, 30));

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 70, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel2.setText("Monto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

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
