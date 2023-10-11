package com.analizador.frontEnd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.analizador.frontEnd.compnents.ConstructorPanel;
import com.analizador.frontEnd.paneles.PanelMenu;
import com.analizador.frontEnd.paneles.panelReporte.PanelReporte;

public class VentanPrincipal extends JFrame {

    // panel izquierdo principal
    private static JPanel panelIzquierdo;
    /// panel derecho principal
    private static JPanel panelDerecho;
    // panel superio izquierdo menu
    private PanelMenu panelMenu;

    /// agregar menu de tabla:

    /// borde de mi panel principal y margen
    Border border = BorderFactory.createLineBorder(Color.BLACK);
    Border margin = new EmptyBorder(15, 30, 15, 30);

    public VentanPrincipal() {

        panelIzquierdo = new JPanel();
        panelMenu = new PanelMenu(Color.BLACK);
        panelDerecho = new JPanel();

        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Analizador Léxico");
        this.setSize(1200, 700);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);

        /// atributos de panel izquierdo
        panelIzquierdo.setBounds(0, 40, 600, 660);
        panelIzquierdo.setLayout(null);

        /// atributos de panel derecho
        panelDerecho.setBounds(600, 40, 600, 660);
      //  panelDerecho.setBorder(new CompoundBorder(border, margin));
        panelDerecho.setLayout(null);

        this.add(panelIzquierdo);
        this.add(panelMenu);
        this.add(panelDerecho);

        moddPanel();

    }

    public void moddPanel() {
        panelIzquierdo.setBackground(new Color(245, 245, 220));
        panelDerecho.setBackground(new Color(245, 245, 220));

        JLabel label = new JLabel("Hello");
        label.setFont(new Font("Monospaced", Font.ITALIC, 50));

        // obtiene las dimensiones del panelCentral
        Dimension panelSize = panelIzquierdo.getSize();

        // Calcula las coordenadas para centrar el JLabel
        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height;
        int x = (panelSize.width - labelWidth) / 2;
        int y = (panelSize.height - labelHeight) / 2;

        label.setBounds(x, y, labelWidth, labelHeight);

        // Alinea el texto en el centro horizontalmente
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panelIzquierdo.add(label);
        panelIzquierdo.repaint();
    }

    public static void addPanelIzquiedo(ConstructorPanel panelIzquierdoE) {

        panelIzquierdo.removeAll();
        panelIzquierdo.add(panelIzquierdoE);
        panelIzquierdo.repaint();
        panelIzquierdo.revalidate();
    }

    public static void addPanelDerecho(PanelReporte panelReporte) {
        panelDerecho.removeAll();
        panelDerecho.add(panelReporte);
        panelDerecho.repaint();
        panelDerecho.revalidate();

    }
}
