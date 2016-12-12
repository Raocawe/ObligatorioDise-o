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
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class vJugador extends javax.swing.JFrame implements Observer{

    JFrame Esta;
    Bingo b = getInstancia();;
    public cUsuario usu ;
    cJuego j;
    int descuento;
    int CantidadCartones = 0;
    int CantXCarton;
    DefaultTableModel[] Tablas;
    JTable[] Tablass;
    ArrayList<Integer>[] ControlDeBusqueda;
    ArrayList<Integer> numerosTabla;
    PatronObserver PObserver;
            
    public vJugador(){}
            
    public vJugador(cUsuario pusu,PatronObserver pPObserver) throws cException {
        usu = pusu;
        j = b.buscarTodo();
        PObserver = pPObserver;
        PObserver.setVentanasJugando(this);
        
        initComponents();
        
        Esta = this;
        this.setTitle(usu.getNombre());
        cerrar();
                
        // <editor-fold defaultstate="collapsed" desc=" Compra De Cartones ">
        String Resultado = "Testeando";
        while(Validar(Resultado) != EnumeradosVentana.Ok)
        {
            Resultado = (JOptionPane.showInputDialog(this, "¿Indique con cuantos catones desea jugar?", "1 -"+j.getCantidadMaximaCartonesXJuegadores()));
            if(Validar(Resultado) == EnumeradosVentana.Ok)
            {
                break;
            }
                
            if(Validar(Resultado) == EnumeradosVentana.NoNumero){ 
               JOptionPane.showMessageDialog(this, "Ingrese un valor numerico entre 1 - "+j.getCantidadMaximaCartonesXJuegadores(),"Advertencia",JOptionPane.INFORMATION_MESSAGE); 
            }
            else if(Validar(Resultado) == EnumeradosVentana.NoValido){ 
               JOptionPane.showMessageDialog(this, "No puede participar con mas de "+j.getCantidadMaximaCartonesXJuegadores()+" cartones","Advertencia",JOptionPane.INFORMATION_MESSAGE); 
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Saldo","Advertencia",JOptionPane.INFORMATION_MESSAGE);
                Resultado = "Testeando";
            }
        }
        CantidadCartones = Integer.parseInt(Resultado);      
        
        // </editor-fold>
        
        ManejoTablas();
        
        PObserver.setCartonesEnJuego(CantidadCartones);
        lblMonto.setText(String.valueOf(usu.getSaldo()));        
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
        descuento = Integer.parseInt(pResultado);
        if(!b.CompraDeCarton(descuento, usu))
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
        
        ArrayList<Integer>  ListaNumeros = CargarLista();
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        ControlDeBusqueda = new ArrayList[CantidadCartones];
        
        String[] colum = new String[CantC];
        for(int tab=0; tab<Tablas.length;tab++){//recorre las tablas a listar
            numerosTabla = new ArrayList<Integer>();
            for (int x = 0 ; x < CantFi ; x++ ){//recorre las filas de la tabla
                if(x==0){
                    
                    for(int t = 0; t<colum.length;t++){//carga los valores de la fila
                    int indice = (int) (Math.random()*ListaNumeros.size()); 
                    int entero = ListaNumeros.get(indice);
                    Tablas[tab].addColumn(entero);
                    numerosTabla.add(entero);
                    CargarListaSorteados(entero);
                    ListaNumeros.remove(indice);
                    }
                }
                else
                {  
                    for(int t = 0; t<colum.length;t++){//carga los valores de la fila
                        int indice = (int) (Math.random()*ListaNumeros.size()); 
                        int entero = ListaNumeros.get(indice);
                        colum[t] = String.valueOf(entero); 
                        numerosTabla.add(entero);
                        CargarListaSorteados(entero);
                        ListaNumeros.remove(indice);
                    }
                    Tablas[tab].addRow(colum);    
                } 
            }
            ControlDeBusqueda[tab] = numerosTabla;
            Tablass[tab].setModel(Tablas[tab]); 
            Tablass[tab].getTableHeader().setBackground(Color.white);
            for(int t = 0; t<colum.length;t++){//Alinea las celdas al centro
                   Tablass[tab].getColumnModel().getColumn(t).setCellRenderer(tcr);
            }
            
        }
                //</editor-fold>
    }
    
    private ArrayList<Integer> CargarLista()
    {
        ArrayList<Integer> ListaNumeros = new ArrayList<Integer>();
        for(int i=1;i<=100;i++)
        {
            ListaNumeros.add(i);
        }
        return ListaNumeros;
    }
    
    private void CargarListaSorteados(int pNumero)
    {
        ArrayList<Integer> lista = PObserver.getListaDeNumeros();
        boolean encontrado = false;
        for(Integer x : lista)
        {
            if(x==pNumero)
            {
                encontrado = true;
            }
        }
        if(encontrado==false)
        {
            lista.add(pNumero);
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblPozo = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 300, 120));

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

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 300, 120));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel1.setText("Pozo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        jLabel2.setText("Monto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Rectangulo.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        lblPozo.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        lblPozo.setText(".");
        getContentPane().add(lblPozo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, -1, -1));

        lblMonto.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        lblMonto.setText(".");
        getContentPane().add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblPozo;
    private javax.swing.JTable tblCarton1;
    private javax.swing.JTable tblCarton2;
    private javax.swing.JTable tblCarton3;
    private javax.swing.JTable tblCarton4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if(PObserver.getGanador()==null)// Pregunta si existe un ganador
        {
            if(PObserver.getVentanasJugando().size()>1) // se fija si alguien esta jugando solo
            {
                if(lblPozo.getText().toString().equals(".")||PObserver.getPozo()!=(Integer.parseInt(lblPozo.getText().toString())))
                {
                    lblPozo.setText(String.valueOf(PObserver.getPozo()));
                }
                else
                {
                    BuscarNumero(PObserver.getBolillaSorteada()); // si todo sigue normal, se busca si saco esa bolilla
                }
            }
            else
            {
               PObserver.setGanador(PObserver.getVentanasJugando().get(0).usu);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "El usuario " +PObserver.getGanador().getNombre()+ " a ganado");
        }
    }
    
    public void BuscarNumero(int pNumero)
    {
        for(int i =0;i<Tablass.length;i++)//recorren las tablas en busca del numero
        {
            for(int t=0;t<ControlDeBusqueda[i].size();t++)
            {
                if(ControlDeBusqueda[i].get(t)==pNumero)
                {
                   ControlDeBusqueda[i].remove(t);
                   BuscarEnTabla(Tablass[i],pNumero);
                   break;
                }
            }
            if(ControlDeBusqueda[i].isEmpty())// Comprobamos si gano
            {
                PObserver.setGanador(usu);
            }           
        }
    }
    
    private void BuscarEnTabla(JTable tabla,int pNumero)//MAGIA 
    {
        for(int i=-1;i<tabla.getRowCount();i++)
        {
            for(int t=0;t<tabla.getColumnCount();t++)
            {
               if(i>-1){
               String integ = (String)tabla.getValueAt(i, t);
                    if(integ.split("").length<3){
                         int intr = Integer.parseInt(integ);
                         if(intr == pNumero)
                         {
                             String format = "<html><font color=red><b>-- "+ integ +" --</b></font></html>";
                             tabla.setValueAt(format, i, t);
                             return;
                         }
                    }
               }
               else
               {
                   String integ = tabla.getColumnName(t);
                    if(integ.split("").length<3){
                         int intr = Integer.parseInt(integ);
                         if(intr == pNumero)
                         {
                             JTableHeader th = tabla.getTableHeader();
                             String format = "<html><font color=red><b>-- "+ integ +" --</b></font></html>";
                             tabla.getColumn(integ).setHeaderValue(format);
                             th.repaint();
                             return;
                         }
                    }
               }
            }
         }
     }
    
    public void cerrar()
    {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                int Decision = JOptionPane.showConfirmDialog(Esta,"¿Esta seguro de abandonar la partida\nPerdera su saldo y resivira una amoretacion?","Advertencia",JOptionPane.YES_NO_OPTION);
                if(Decision == JOptionPane.YES_OPTION)
                {
                    dispose();
                    PObserver.getVentanasJugando().remove(Esta);
                    try {
                        PObserver.calcularPozo();
                    } catch (cException ex) {
                        Logger.getLogger(vJugador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    usu.setSaldo(usu.getSaldo()+descuento);
                    try {
                        b.ModificarUsuario(usu);
                    } catch (cException ex) {
                        Logger.getLogger(vJugador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
 }

