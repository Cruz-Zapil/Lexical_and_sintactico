package com.analizador.frontEnd.accionesBotton;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.swing.JOptionPane;
import com.analizador.frontEnd.accionesBotton.utils.LogicaArchivos;
import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.AFD.Lexer;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.parser.model.Auxiliar;
import com.analizador.backEnd.parser.model.Raiz;
import com.analizador.frontEnd.Panel1;
import com.analizador.frontEnd.Panel1Escritura;
import com.analizador.frontEnd.Panel2;
import com.analizador.frontEnd.VentanPrincipal;
import com.analizador.frontEnd.compnents.ConstructorBotton;

public class AccionBoton implements java.awt.event.ActionListener {

    private Panel1 panel1 = new Panel1();
    private Panel2 panel2 = new Panel2();

      ListaEnlazada listaTokens = new ListaEnlazada();
     Raiz raiz = new Raiz();

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
                    VentanPrincipal.addPanel(panel2);
                    LogicaArchivos.lecturaGraficos = rutaCarpeta;
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una carpeta para guardar los graficos");
                }

            } else if (botones.getText().equals("Play")) {
                /// boton para obtener texto en TextPane
        
                System.out.println("Play");
                
                
                try {
                    conectarLexer(Panel1Escritura.getText());
                } catch (IOException e) {
                
                    System.out.println("error en conectar lexer");
                    e.printStackTrace();
                }

            } else if (botones.getText().equals("Limpiar")) {
                /// limpiar
                Panel1Escritura.setText("");
            } else if (botones.getText().equals("Ayuda")) {

                System.out.println(" help");
            } else if (botones.getText().equals("Acerca")) {
                System.out.println(" acerda de");

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
            VentanPrincipal.addPanel(panel1);
            Panel1Escritura.setText(new LogicaArchivos().fileChoser());
        } else if (choice == 1) {
            // Acción para "Nuevo"
            VentanPrincipal.addPanel(panel1);
        }
    }

    /// conectar con mi automata finito determinista


    public void conectarLexer(String codigo ) throws IOException {

        if ( codigo != null) {

            Reader extraerTexto = new StringReader(codigo);

            Lexer lexer = new Lexer(extraerTexto);
            Token token = lexer.yylex(); 
            
            while (token.getTokenType() != Constante.EOF) {

                /// almacenar tokens

               listaTokens.insertarAlFinal(token);

               System.out.println(" en lista: " + listaTokens.obtenerUltimo());

                token = lexer.yylex();


            }
        }else{

            System.out.println("no hay texto");
        }

        /// conectar con la siguente face...

        Token tmp = listaTokens.getPrimero().getLexema();
        Auxiliar.siguenteLexema(listaTokens.obtenerPosicionDeToken(tmp));
        raiz.scanRaiz( tmp, listaTokens );
        



    }
}
