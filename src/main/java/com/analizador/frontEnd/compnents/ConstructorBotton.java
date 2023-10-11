package com.analizador.frontEnd.compnents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder; 

public class ConstructorBotton extends javax.swing.JButton {


    public ConstructorBotton(String texto , Color colorBorder, Color backgroud, Color font , int x, int y, ActionListener accionBoton){
        super(texto);        
        Border border = BorderFactory.createLineBorder(colorBorder);
        Border margin = new EmptyBorder(15, 30, 15, 30);

        Font fuentePersonalizada = new Font("Arial", Font.PLAIN, 10); 
        
        this.setBorder(new CompoundBorder(border, margin));
        this.setBackground(backgroud);
        this.setForeground(font);
        this.setFont(fuentePersonalizada);
        
        this.setBounds(x, y, 100,40);
        this.setVisible(true);
        this.addActionListener(accionBoton);
    }
    
    
}
