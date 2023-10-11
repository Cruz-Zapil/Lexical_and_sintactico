package com.analizador.frontEnd.graficos;

import java.io.FileWriter;
import java.io.PrintWriter;

import com.analizador.frontEnd.accionesBotton.utils.LogicaArchivos;


class Nodos {

    private Nodos acumulativo;
    private char caracter = ' ';
    private int id;
    private static int contador = 1;
    private boolean dobleElipse = false;

    public Nodos() {
        this.acumulativo = null;
        this.id = contador++;
    }

    public void pasarCaracter(char caracter) {
        this.caracter = caracter;
    }

    public void setSiguiente(Nodos siguiente) {
        this.acumulativo = siguiente;
    }

    public void setDobleElipse(boolean dobleElipse) {
        this.dobleElipse = dobleElipse;
    }

    private String getCodigoGraphviz() {
        String forma = "ellipse";
        String estilo = "style=filled, fillcolor=seashell2";

        return "digraph grafica{\n" +
                "rankdir=LR;\n" +
                "node [shape = " + forma + ", " + estilo + "];\n" +
                getCodigoInterno() +
                "}\n";
    }

    private String getCodigoInterno() {

        String etiqueta = "";

        if (dobleElipse) {

            etiqueta = "nodo" + id + "[label=\"" + caracter
                    + "\", style=filled, fillcolor=lightblue, shape=ellipse];\n";

        } else {
            etiqueta = "nodo" + id + "[label=\"" + caracter + "\"];\n";

        }

        if (acumulativo != null) {
            etiqueta = etiqueta + acumulativo.getCodigoInterno() +
                    "nodo" + id + "->nodo" + acumulativo.id + "\n";
        }
        return etiqueta;
    }

    public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try {
            fichero = new FileWriter(LogicaArchivos.lecturaGraficos+ "/text_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
            escritor.close(); // Cierra el escritor para que el archivo se guarde correctamente
        } catch (Exception e) {
            System.err.println("Error al escribir el archivo text_grafico.dot");
        } finally {
            try {
                if (fichero != null)
                    fichero.close();
            } catch (Exception e2) {
                System.err.println("Error al cerrar el archivo text_grafico.dot");
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o " + path + " "+LogicaArchivos.lecturaGraficos+"/text_grafico.dot");

          //  System.out.println("dot -Tjpg -o " + path + " "+LogicaArchivos.lecturaGraficos+"/text_grafico.dot");

            Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }

}