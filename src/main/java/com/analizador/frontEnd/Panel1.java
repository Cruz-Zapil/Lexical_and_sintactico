package com.analizador.frontEnd;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.analizador.frontEnd.compnents.ConstructorPanel;

import java.awt.Font;
import java.awt.Color;


public class Panel1 extends ConstructorPanel {

    //// panel de lot text area 

    private Panel1Escritura panel1Escritura;
    private static JTextPane areaTextError;

    public Panel1() {
        super(new Color(245, 245, 220));
      
        panel1Escritura = new Panel1Escritura();
        setcomponentes1();
    }

    public void setcomponentes1() {
        areaTextError = new JTextPane();
        areaTextError.setBounds(50, 430, 500, 150);
        areaTextError.setBackground(Color.black);
        areaTextError.setFont(new Font("Arial", Font.BOLD, 15));
        areaTextError.setForeground(Color.red);
        areaTextError.setEditable(false);
    
        // Configurar el panel de desplazamiento para el área de texto de errores
        JScrollPane scrollBarError = new JScrollPane(areaTextError);
        scrollBarError.setBounds(50, 430, 500, 150);
    
        this.add(panel1Escritura);
        this.add(scrollBarError);  // Agregar el JScrollPane al panel principal
    }
    


     public static void setTextReport(String text, Color color) {
        StyledDocument doc = areaTextError.getStyledDocument();
        Style style = doc.addStyle("coloredStyle", null);
        StyleConstants.setForeground(style, color);

        try {
            doc.insertString(doc.getLength(), text, style);
            doc.insertString(doc.getLength(), "\n", null); // Add a new line after colored text
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

}
