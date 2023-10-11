package com.analizador.frontEnd.paneles.panelGrafico;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.analizador.frontEnd.accionesBotton.utils.LogicaArchivos;
import com.analizador.frontEnd.compnents.Item;
import com.analizador.frontEnd.graficos.InicioGrafico;
import java.awt.Image;

public class AuxiGrafico extends JPanel {

    public AuxiGrafico() {

        this.setLayout(new BorderLayout());

        this.setBounds(50, 30, 500, 370);
        this.setVisible(true);
        setcomponentes1();
    }

    public void setcomponentes1() {

        JComboBox<Item> comboBox = new JComboBox<>(createItems());
        comboBox.setRenderer(new ItemListRenderer());
        comboBox.addActionListener(new ItemSelectionListener(comboBox, this));

        this.add(comboBox, BorderLayout.NORTH);
        // Agregar el JLabel para la imagen

    }

    // Método para cargar una imagen en el JLabel
    public void cargarImagen(String rutaImagen) {
        removeAll();

        setcomponentes1();

        ImageIcon imagenIco2 = new ImageIcon(rutaImagen);
        Image imagen = imagenIco2.getImage();

        // Ajusta la imagen al tamaño del JPanel
        int panelAncho = this.getWidth() - 10;
        Image imagenEscalada = imagen.getScaledInstance(panelAncho, 90, Image.SCALE_SMOOTH);

        ImageIcon imagenEscaladaIcon = new ImageIcon(imagenEscalada);
        JLabel imagenLabe = new JLabel();
        imagenLabe.setHorizontalAlignment(SwingConstants.CENTER);
        imagenLabe.setIcon(imagenEscaladaIcon);
        this.add(imagenLabe, BorderLayout.CENTER);

        repaint();
        revalidate();
    }

    private static DefaultComboBoxModel<Item> createItems() {
        DefaultComboBoxModel<Item> model = new DefaultComboBoxModel<>();
        model.addElement(new Item("Mostrar Graficas"));
        model.addElement(new Item("Palabras clave",
                new String[] { "and", "as", "assert", "break", "class", "continue", "def", "elif", "or", "not", "if",
                        "else", "while", "except", "finally", "for", "from", "global", "import", "lambda", "pass",
                        "in", "range", "return", "input", "int", "float", "str",
                        "bool", "True", "False", "None", "is", "nonlocal", "raise", "try", "with", "yield" }));
        model.addElement(new Item("Identificadores", new String[] { "_Mi_Numero", "Identificador", "clave_Num" }));
        model.addElement(new Item("Aritmetifcos", new String[] { "+", "-", "**", "/", "%", "*" }));
        model.addElement(new Item("Comparacion", new String[] { "==", "!=", ">", "<", ">=", "<=" }));
        model.addElement(new Item("Logicos", new String[] { "and", "or", "not" }));
        model.addElement(new Item("Asignacion", new String[] { "=", "*=", "-=" }));

        return model;
    }

}

class ItemSelectionListener implements ActionListener {
    
    private JComboBox<Item> comboBox;


    private JPanel panelAuxi;

    public ItemSelectionListener(JComboBox<Item> comboBox, JPanel panelAuxi) {
        this.comboBox = comboBox;
        this.panelAuxi = panelAuxi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<?> source = (JComboBox<?>) e.getSource();
        Item selected = (Item) source.getSelectedItem();
        if (selected != null && selected.getSubItems().length > 0) {
            JPopupMenu popupMenu = new JPopupMenu();
            for (String subItem : selected.getSubItems()) {
                JMenuItem menuItem = new JMenuItem(subItem);
                menuItem.addActionListener(new SubItemActionListener(subItem, panelAuxi)); // Agregar un ActionListener
                                                                                           // al
                // JMenuItem
                popupMenu.add(menuItem);
            }
            popupMenu.show(source, 0, source.getHeight());
        }
    }


    public JComboBox<Item> getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox<Item> comboBox) {
        this.comboBox = comboBox;
    }

}

class SubItemActionListener implements ActionListener {
    private String subItem;
    private JPanel panelAuxi;

    public SubItemActionListener(String subItem, JPanel panelAuxi) {
        this.subItem = subItem;
        this.panelAuxi = panelAuxi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Realizar la acción deseada con el subítem seleccionado
        // JOptionPane.showMessageDialog(null, "Has seleccionado: " + subItem);
        new InicioGrafico().insertar(subItem);
        ((AuxiGrafico) panelAuxi).cargarImagen(LogicaArchivos.lecturaGraficos+"/"+subItem + ".jpg");
    }
}
