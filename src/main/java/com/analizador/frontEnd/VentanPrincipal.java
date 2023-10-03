package com.analizador.frontEnd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.analizador.frontEnd.compnents.ConstructorPanel;

public class VentanPrincipal extends javax.swing.JFrame {

    private static JPanel panelCentral;

    Panel3 panel3;

    public VentanPrincipal() {

        panelCentral = new JPanel();
        panel3 = new Panel3( Color.BLACK, new Color(210, 180, 140));

        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Analizador Léxico");
        this.setSize(600, 700);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);

        panelCentral.setBounds(0, 40, 600, 660);
        panelCentral.setLayout(null);

        this.add(panelCentral);
        this.add(panel3);
        moddPanel();

    }

public void moddPanel() {
    panelCentral.setBackground(new Color(245, 245, 220));

    JLabel label = new JLabel("Hello");
    label.setFont(new Font("Monospaced", Font.ITALIC, 50));

    // obtiene las dimensiones del panelCentral
    Dimension panelSize = panelCentral.getSize();

    // Calcula las coordenadas para centrar el JLabel
    int labelWidth = label.getPreferredSize().width;
    int labelHeight = label.getPreferredSize().height;
    int x = (panelSize.width - labelWidth) / 2;
    int y = (panelSize.height - labelHeight) / 2;

    label.setBounds(x, y, labelWidth, labelHeight);

    // Alinea el texto en el centro horizontalmente
    label.setHorizontalAlignment(SwingConstants.CENTER);

    panelCentral.add(label);
    panelCentral.repaint();
}


    public static void addPanel(ConstructorPanel panel1) {

        panelCentral.removeAll();
        panelCentral.add(panel1);
        panelCentral.repaint();
        panelCentral.revalidate();
    }
}
