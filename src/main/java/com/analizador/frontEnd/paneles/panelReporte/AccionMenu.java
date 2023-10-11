package com.analizador.frontEnd.paneles.panelReporte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import com.analizador.frontEnd.accionesBotton.utils.Message;

public class AccionMenu implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {

        Object fuente = event.getSource();

        if (fuente instanceof JMenuItem) {

            

            JMenuItem item = (JMenuItem) event.getSource();
            
            if (item.getText().equals("Tabla Global")) {
                
             PanelReporte.agregarDatosGlobal();

            } else {
                Message.mostrarMensajeInfo(" no es una tabla blogal ¡", " kjasñdfj");
            }

        }else {
            Message.mostrarMensajeInfo(" hoalñ"," else ");
        }
    }

}
