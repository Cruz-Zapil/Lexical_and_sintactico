package com.analizador.frontEnd.paneles.panelEscritura;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Panel1Escritura extends JPanel {

    /// panel que recibe texto o se escribe texto 
    private static JTextPane textAreaImput;

    public Panel1Escritura() {

        this.setLayout(new BorderLayout());

        // Crear dos JTextAreas
        textAreaImput = new JTextPane();

        // Crear un JScrollPane
        JScrollPane scrollPane = new JScrollPane();

        // Agregar los JTextAreas al JScrollPane
        scrollPane.setViewportView(textAreaImput);
        scrollPane.setRowHeaderView(new LineNumberTextPane(textAreaImput));
        addScrollSync(scrollPane, textAreaImput);

        // Agregar el JScrollPane al panel
        this.add(scrollPane);
        this.setBounds(50, 30, 500, 550);
        this.setVisible(true);

    }

    private static void addScrollSync(JScrollPane sourceScrollPane, JTextPane targetTextArea1) {

        sourceScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
               // int value = e.getValue();
                targetTextArea1.scrollRectToVisible(new Rectangle(targetTextArea1.getSize()));

            }
        });
    }

    public static void setText(String text) {
        textAreaImput.setText(text);
    }

    public static String getText() {
      //  System.out.println("texto de contenido: " + textAreaImput.getText());
        return textAreaImput.getText();
    }

    public static void setTextColor(String text, Color color) {
        StyledDocument doc = textAreaImput.getStyledDocument();
        Style style = doc.addStyle("coloredStyle", null);
        StyleConstants.setForeground(style, color);

        try {
            doc.insertString(doc.getLength(), text, style);
           // doc.insertString(doc.getLength(), null, null); // Add a new line after colored text
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

}

class LineNumberTextPane extends JTextPane {

    private JTextPane textPane;

    public LineNumberTextPane(JTextPane textPane) {
        this.textPane = textPane;
        setEditable(false);
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(30, Integer.MAX_VALUE));
        updateLineNumbers();

        textPane.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                // Este método es relevante para cambios en atributos del estilo del texto
            }
        });
    }

    private void updateLineNumbers() {
        StyledDocument doc = textPane.getStyledDocument();
        int totalLines = doc.getDefaultRootElement().getElementCount();
        StringBuilder lineNumbers = new StringBuilder();
        for (int i = 1; i <= totalLines; i++) {
            lineNumbers.append(i).append('\n');
        }

        setText(lineNumbers.toString());
    }

}
