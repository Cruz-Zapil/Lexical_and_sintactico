package com.analizador.frontEnd.paneles;

import javax.swing.JPanel;
import com.analizador.frontEnd.accionesBotton.AccionBoton;
import com.analizador.frontEnd.compnents.ConstructorBotton;


import java.awt.Color;


    public class PanelMenu extends JPanel {

        private ConstructorBotton[] botones = new ConstructorBotton[8];
        private String[] etiquetas = {"Archivo", "Grafico", "Play", "Limpiar", "Acerca", "Ayuda", "Tabla", "Sintactico"};
        private AccionBoton accionBoton = new AccionBoton();
    
        public PanelMenu( Color textColor) {
            this.setLayout(null);
            this.setBounds(0, 0, 1200, 40);
            this.setBackground(new Color(210, 180, 140));
    
            setComponentes(textColor);
            this.setVisible(true);
        }
    
        public void setComponentes(Color textColor) {
            for (int i = 0; i < botones.length; i++) {
                botones[i] = new ConstructorBotton(etiquetas[i], textColor, new Color(210, 180, 140), Color.BLACK, 0 + (i * 100), 0, accionBoton);
                this.add(botones[i]);
            }
            revalidate();
            repaint();
        }
    }
    
