package com.analizador.frontEnd.accionesBotton;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;
import com.analizador.frontEnd.accionesBotton.utils.LogicaArchivos;
import com.analizador.frontEnd.accionesBotton.utils.Message;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.frontEnd.VentanPrincipal;
import com.analizador.frontEnd.compnents.ConstructorBotton;
import com.analizador.frontEnd.paneles.panelEscritura.Panel1;
import com.analizador.frontEnd.paneles.panelEscritura.Panel1Escritura;
import com.analizador.frontEnd.paneles.panelGrafico.PanelGrafico;
import com.analizador.frontEnd.paneles.panelReporte.PanelReporte;

public class AccionBoton implements java.awt.event.ActionListener {

    private Panel1 panel1 = new Panel1();
    private PanelGrafico panelGrafico = new PanelGrafico();
    private PanelReporte panelReporte ;
    private ListaEnlazada listaTokens;

    @Override
    public void actionPerformed(ActionEvent event) {

        Object fuente = event.getSource();

        if (fuente instanceof ConstructorBotton) {

            ConstructorBotton botones = (ConstructorBotton) event.getSource();

            if (botones.getText().equals("Archivo")) {
                // messaje
                message();

            } else if (botones.getText().equals("Grafico")) {
                System.out.println("Grafico ");

                LogicaArchivos logicaArchivos = new LogicaArchivos();
                String rutaCarpeta = logicaArchivos.obtenerRutaCarpeta();
                if (rutaCarpeta != null) {
                    VentanPrincipal.addPanelIzquiedo(panelGrafico);
                    LogicaArchivos.lecturaGraficos = rutaCarpeta;
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una carpeta para guardar los graficos");
                }

            } else if (botones.getText().equals("Play")) {
                /// boton para obtener texto en TextPane
                try {
                    listaTokens = new ConectarLexer().conectarLexer(Panel1Escritura.getText());
                    Message.mostrarMensajeInfo("Texto Leido...", "Info.");
                } catch (IOException e) {
                    Message.mostrarConfirmacion(e, "Error");
                    e.printStackTrace();
                }

            } else if (botones.getText().equals("Limpiar")) {
                /// limpiar
                Panel1Escritura.setText("");
            } else if (botones.getText().equals("Ayuda")) {
                /// ayuda
                System.out.println(" help");
            } else if (botones.getText().equals("Acerca")) {
                System.out.println(" acerda de");

            } else if (botones.getText().equals("Tabla")) {
                System.out.println(" mostra tabla ");
                /// conectar con tabla
                VentanPrincipal.addPanelDerecho(panelReporte =  new PanelReporte());
                if (listaTokens!= null) {
                }else {
                    Message.mostrarMensajeError(" Error no tiene Tokens", "ERROR!!");
                    
                }
            }
        }
    }

    public void message() {
        String[] options = { "Abrir Archivo", "Nuevo", "Cancelar" };
        int choice = JOptionPane.showOptionDialog(
                null,
                "Attencion: ",
                "Seleccione una opción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            // Acción para "Abrir Archivo"
            VentanPrincipal.addPanelIzquiedo(panel1);
            Panel1Escritura.setText(new LogicaArchivos().fileChoser());
        } else if (choice == 1) {
            // Acción para "Nuevo"
            VentanPrincipal.addPanelIzquiedo(panel1);
        }
    }

}
