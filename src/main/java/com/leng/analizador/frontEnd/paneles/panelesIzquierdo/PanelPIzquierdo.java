package com.leng.analizador.frontEnd.paneles.panelesIzquierdo;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.leng.analizador.frontEnd.paneles.ConstructorPanel;

public class PanelPIzquierdo extends ConstructorPanel {

    public PanelPIzquierdo() {

        super(new Color(46, 64, 83), 646, 645);

        Border borde = BorderFactory.createLineBorder(new Color(32, 32, 32));

        // Aplicar el borde al JPanel
        this.setBorder(borde);
        this.setLayout(null);
        this.setLocation(0, 35);

        addComponents();
    }

    public void addComponents() {
        this.repaint();
        this.revalidate();

    }

}
