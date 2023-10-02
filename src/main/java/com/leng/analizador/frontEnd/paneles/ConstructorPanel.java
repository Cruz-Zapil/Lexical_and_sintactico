package com.leng.analizador.frontEnd.paneles;

import javax.swing.JPanel;
import java.awt.Color;

public class ConstructorPanel extends JPanel {

    public ConstructorPanel( Color colorFondo , int ancho, int alto ) {

        this.setBackground( colorFondo );
        this.setSize( ancho, alto );
        this.setVisible( true );
      
    }    
    
}