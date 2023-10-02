package com.analizador.frontEnd.paneles.bottons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ConstructorBottons extends JButton {

    public ConstructorBottons(String text, Color fondo, int ancho, int largo, ActionListener accionesBotton) {

        this.setText(text);
        this.setBackground(fondo);

        Border borde1 = BorderFactory.createLineBorder(Color.black);
        Border borde2 = BorderFactory.createEmptyBorder(5, 5, 5, 5); // Margen interior
        Border bordeCompuesto = BorderFactory.createCompoundBorder(borde1, borde2);

        Font fuentePersonalizada = new Font("Arial", Font.PLAIN, 13);

        this.setBorder(bordeCompuesto);

        this.setFont(fuentePersonalizada);
        this.setBounds(ancho, largo, 100, 40);
        this.setForeground(Color.white);
        this.addActionListener(accionesBotton);

    }

}
