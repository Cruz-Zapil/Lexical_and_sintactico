package com.analizador.frontEnd.accionesBotton.utils;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Message {
    // Ventana emergente de entrada de texto
    public static String mostrarEntradaTexto(String mensaje, String titulo) {
        return JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
    }

    // Ventana emergente de confirmación
    public static boolean mostrarConfirmacion(String mensaje, String titulo) {
        int opcion = JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
        return opcion == JOptionPane.YES_OPTION;
    }

    public static void mostrarConfirmacion(IOException e, String titulo) {
    }

    /// ventana de mensaje con icono
    public static void mostrarMensajeError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarMensajeInfo(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarMensajeWaring(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }

   

}
