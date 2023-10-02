package com.leng.analizador.frontEnd.paneles.panelesIzquierdo;

import java.awt.Color;
import java.awt.FlowLayout;

import com.leng.analizador.frontEnd.actionButtons.AccionButtons;
import com.leng.analizador.frontEnd.paneles.ConstructorPanel;
import com.leng.analizador.frontEnd.paneles.bottons.ConstructorBottons;

public class PanelMenu extends ConstructorPanel {

    private ConstructorBottons[] buttons;
    private String[] buttonTexts = { "Archivo", "Gráfico", "Play", "Limpiar", "Acerca", "Ayuda", "Salir" };

    public PanelMenu() {

        super(new Color( 28, 40, 51  ), 645, 35); 
        setLayout(new FlowLayout(FlowLayout.LEFT));

        addBottons();
    }
    
    public void addBottons() {
        buttons = new ConstructorBottons[buttonTexts.length];        
        for (int i = 0; i < buttonTexts.length; i++) {
            buttons[i] = new ConstructorBottons(buttonTexts[i], new Color(   28, 40, 51 ), 0 + (i * 100), 0, new AccionButtons());
            this.add(buttons[i]);
        }

    }

}