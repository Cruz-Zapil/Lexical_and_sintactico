package com.analizador.frontEnd.paneles.panelReporte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PanelReporte extends JPanel {

    //// panel de lot text area
    public static DefaultTableModel model;

    public PanelReporte() {

        this.setBackground(new Color(245, 245, 220));
        this.setBounds(0, 0, 600, 660);
        this.setLayout(null);
        this.setBorder(new LineBorder(Color.BLACK, 1)); // Establece un borde al panel

        agregrarTabla();
        agregarMenu();

    }

    public void agregrarTabla() {
        model = new DefaultTableModel();
        model.addColumn("Simbolo");
        model.addColumn("Tipo");
        model.addColumn("Valor");
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

    public void agregarMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu archivoMenu = new JMenu("Archivo");

        archivoMenu.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente simple
        archivoMenu.setForeground(Color.BLACK); // Texto en color negro
        archivoMenu.setBorderPainted(true); // Elimina el borde
        archivoMenu.setIcon(new ImageIcon("icono.png")); // Icono simplificado
        archivoMenu.setBackground(new Color(210, 180, 140)); // Fondo con el color deseado
        archivoMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Borde con el color y grosor deseado

        JMenuItem abrirMenuItem = new JMenuItem("Abrir");
        abrirMenuItem.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente simple
        abrirMenuItem.setForeground(Color.BLACK); // Texto en color negro
        abrirMenuItem.setIcon(new ImageIcon("icono_abrir.png")); // Icono simplificado

        JMenuItem guardarMenuItem = new JMenuItem("Guardar");

        abrirMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Agregar la lógica para abrir un archivo aquí
                JOptionPane.showMessageDialog(null, "Abrir archivo...");
            }
        });

        guardarMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Agregar la lógica para guardar datos aquí
                JOptionPane.showMessageDialog(null, "Guardar datos...");
            }
        });

        archivoMenu.add(abrirMenuItem);
        archivoMenu.add(guardarMenuItem);

        menuBar.add(archivoMenu);
        menuBar.setBounds(25, 30, 550, 25);
        this.add(menuBar);
    }

    public static void agregarDatos() {

        //// agregar datos
        model.addRow(new Object[] { "Juan", 25 });
        model.addRow(new Object[] { "María", 30 });
        model.addRow(new Object[] { "Carlos", 22 });

    }

}
