package com.analizador.frontEnd;

import javax.swing.JFrame;

import com.analizador.frontEnd.paneles.ConstructorPanel;
import com.analizador.frontEnd.paneles.panelesDerecho.PanelPDerecho;
import com.analizador.frontEnd.paneles.panelesIzquierdo.PanelMenu;
import com.analizador.frontEnd.paneles.panelesIzquierdo.PanelPIzquierdo;

public class VentanaPrincipal extends JFrame {

    private static PanelPDerecho panelPDerecho;
    private static PanelPIzquierdo panelPIzquierdo;

    public VentanaPrincipal() {
        this.setTitle("Analizador Léxico");
        this.setSize(1178, 684);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // agregar panel de menu
        
        PanelMenu panelMenu = new PanelMenu();
        this.add(panelMenu);
        addPanels();

    }

    public void addPanels() {
        panelPIzquierdo = new PanelPIzquierdo();
        panelPDerecho = new PanelPDerecho();

        this.add(panelPIzquierdo);
        this.add(panelPDerecho);
    }

    public static void addPanelDerecho(ConstructorPanel newPanelDe) {
        panelPDerecho.removeAll();
        panelPDerecho.add(newPanelDe);
        panelPDerecho.repaint();
        panelPDerecho.revalidate();

    }

    public static void addPanelIzquierdo(ConstructorPanel newPanelIz) {

        panelPIzquierdo.removeAll();
        panelPIzquierdo.add(newPanelIz);
        panelPIzquierdo.repaint();
        panelPIzquierdo.revalidate();

    }

}
