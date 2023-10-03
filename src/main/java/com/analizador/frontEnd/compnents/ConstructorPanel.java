package com.analizador.frontEnd.compnents;


import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class ConstructorPanel extends JPanel {

    private JLabel titulo;

        public ConstructorPanel(Color colorFondo/* , String etiqueta */) {
        this.setLayout(null);
        this.setBounds(0, 0, 600, 660);
        this.setBackground(colorFondo);
        
        titulo = new JLabel();
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
     //   titulo.setForeground(color);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setBounds(50, 20, 500, 30);
        this.add(titulo);
     
        this.setVisible(true);

    }

    
}
