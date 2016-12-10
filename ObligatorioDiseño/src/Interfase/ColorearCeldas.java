/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author cristian castro
 */
public class ColorearCeldas extends DefaultTableCellRenderer{
    
    private ArrayList<Integer> List;
    private int numero;
    
    public ColorearCeldas(ArrayList<Integer> numeros,int pnumero){List = numeros;numero =  pnumero;}
    
    @Override
    public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row, int column){
    
        JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int valor = (int)value;
        if(numero==valor)
        {
            cell.setForeground(Color.red);
            cell.setBackground(Color.green);
            List.remove(valor);
            return cell;
        }
        return cell;
    }
    
    public ArrayList<Integer> getList() {
        return List;
    }
    
}
