package com.analizador.frontEnd.paneles.panelReporte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class AccionMenu implements ActionListener  {

    @Override
    public void actionPerformed(ActionEvent event) {

        Object fuente = event.getSource();

        if (fuente instanceof JMenuItem) {

            JMenuItem item = (JMenuItem) event.getSource();
            
            
                        
        }        
    }
    
}
