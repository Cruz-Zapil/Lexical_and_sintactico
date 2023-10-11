package com.analizador.frontEnd.paneles.panelReporte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.frontEnd.accionesBotton.utils.Message;

public class PanelReporte extends JPanel {

    //// panel de lot text area
    public static DefaultTableModel model;

    /// menu

    private JMenuBar menuBar;
    private JMenu archivoMenu;
    private AccionMenu accionMenu = new AccionMenu();
    private static ListaEnlazada listaToken;

    public PanelReporte(ListaEnlazada listaToken) {

        PanelReporte.listaToken = listaToken;

        this.setBackground(new Color(245, 245, 220));
        this.setBounds(0, 0, 600, 660);
        this.setLayout(null);
        this.setBorder(new LineBorder(Color.BLACK, 1)); // Establece un borde al panel

        agregrarTabla();
        inicializarMenu();

    }

    private void inicializarMenu() {
        menuBar = new JMenuBar();
        // border
        menuBar.setBorder(new LineBorder(Color.BLACK, 1));
        // color
        menuBar.setBackground(new Color(173, 216, 230));

        archivoMenu = new JMenu("Lista de Codigo");
        archivoMenu.setFont(new Font("Arial", Font.PLAIN, 14));

        menuBar.add(archivoMenu);
        menuBar.setBounds(25, 30, 250, 30);
        recorer();
        this.add(menuBar);
    }

    public void recorer() {
        /// crear objeto item
        JMenuItem item;
        /// agregar una lista a mi tabla
        item =  new JMenuItem("Tabla Global");
        item.addActionListener(accionMenu);
        archivoMenu.add(item);

        ArrayList<String> datosLeidos = leerArchivo();

        for (String dato : datosLeidos) {

             item = new JMenuItem(dato);

            item.setFont(new Font("Arial", Font.PLAIN, 14));

            item.addActionListener(accionMenu);
            archivoMenu.add(item);
        }

        // Refresca la barra de menú
    }

    
    /// lista para mi menu

    private ArrayList<String> leerArchivo() {
        // Simula la lectura de un archivo y devuelve los datos como una lista
        ArrayList<String> datos = new ArrayList<>();
        datos.add("Item 1");
        datos.add("Item 2");
        datos.add("Item 3");
        return datos;
    }

    public void agregrarTabla() {
        model = new DefaultTableModel();
        model.addColumn("Simbolo");
        model.addColumn("Tipo");
     //  model.addColumn("Valor");
        model.addColumn("Linea");
        model.addColumn("Columna");

        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 13)); // Cambia la fuente
        table.setRowHeight(30); // Cambia la altura de las filas
        table.setIntercellSpacing(new Dimension(0, 0)); // Elimina el espaciado entre celdas
        table.setLocation(0, 0);

        // Personaliza el encabezado de la tabla
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14)); // Cambia la fuente del encabezado
        header.setBackground(new Color(255, 182, 193)); // Cambia el color de fondo del encabezado
        header.setForeground(Color.black); // Cambia el color del texto del encabezado

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Elimina el borde del JScrollPane
        scrollPane.setPreferredSize(new Dimension(500, 400)); // Establece el tamaño preferido
        scrollPane.setBounds(25, 100, 550, 475);

        this.add(scrollPane);
    }


    public static void agregarDatosGlobal(){
       
        for (Token dato : listaToken.getDatos()) {

            model.addRow(new Object[] {dato.getLexeme(),dato.getTokenType() ,dato.getLine(), dato.getCharBegin()});
        }
        Message.mostrarMensajeInfo("Se mostraron todos los datos ", " Informacion:");

    }

}
