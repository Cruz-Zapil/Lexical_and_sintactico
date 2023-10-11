package com.analizador.frontEnd.accionesBotton.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LogicaArchivos {

    private JFileChooser miBuscador;
    String RUTA;
    private String rutaFichero = "src/main/java/com/practica2/ficheros/";
    public static String lecturaGraficos="";


    public String fileChoser() {

        String textoLeido="";
        miBuscador = new JFileChooser(".");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Python (.py)", "py");

        miBuscador.setFileFilter(filtro);

        int valor = miBuscador.showOpenDialog(miBuscador);
        if (valor == JFileChooser.APPROVE_OPTION) {
            textoLeido="";
            textoLeido = leerArchivoExterior(miBuscador.getSelectedFile().getAbsolutePath());
            System.out.println(miBuscador.getSelectedFile().getAbsolutePath());
           
        }
        return textoLeido;
    }

    public String obtenerRutaCarpeta() {
        JFileChooser miBuscador = new JFileChooser(".");
        miBuscador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Solo seleccionar directorios
    
        int valor = miBuscador.showOpenDialog(miBuscador);
        if (valor == JFileChooser.APPROVE_OPTION) {
            String rutaCarpeta = miBuscador.getSelectedFile().getAbsolutePath();
            System.out.println(rutaCarpeta);
            return rutaCarpeta;
        }
        
        return null; // Retorna null si la selección fue cancelada
    }
    

    public String leerArchivoExterior(String ruta) {

        FileReader lector = null;
        BufferedReader br = null;
        this.RUTA = ruta;

        String lectura = "";
        String contenido = "";

        try {
            lector = new FileReader(ruta);
            br = new BufferedReader(lector);
            while ((lectura = br.readLine()) != null) {
                contenido += lectura + "\n";

            }
            br.close();
            lector.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
        return contenido;
    }

    public void escribirArchivo(String texto, String ruta, boolean reescribir) {
        System.out.println(" rutas firchero " + rutaFichero + ruta);
        try {
            File archivo = new File(rutaFichero + ruta);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            FileWriter escritor = new FileWriter(archivo, reescribir);
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.write(texto);
            buffer.close();
            escritor.close();
        } catch (IOException error) {
            System.out.println(error);
        }
    }

}
