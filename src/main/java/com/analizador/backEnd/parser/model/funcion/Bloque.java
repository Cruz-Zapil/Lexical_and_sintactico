package com.analizador.backEnd.parser.model.funcion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.BloqueCodigo;
import com.analizador.backEnd.parser.model.sentencia.RaizSentencia;

public class Bloque {

    private int estado = 0;
    private Token lexema;
    private RaizSentencia raizSentencia = new RaizSentencia();

    /*   ********  CADA VEZ QUE ENTRA EN UN BLOQUE HAY QUE MANEJAR IDENTACION Y DEDENTACION  ***** */

    public boolean secanBloque(ListaEnlazada listLexer) {

        /// se vio antes un lexema que aun no es salto de linea
        this.lexema = listLexer.eliminarPrimero();
        System.out.println( " se solicito un salto de linea");

        if (this.lexema.getTokenType().equals(BloqueCodigo.NEWLINE)) {
           
            // es nueva linea

            this.lexema = listLexer.eliminarPrimero();
            /*
             * identacion
             * se va a conectar con sentencia Raiz.           
             */
            
             if (this.lexema.getTokenType().equals(BloqueCodigo.IDENTACION)) {

                //// es un inicio de un bloque
                /// conectar con raiz sentencia
                raizSentencia.scanSentencia( listLexer);
                
                
                
             }



        }else {

            System.out.println("  Error de sintaxis  se esperaba un salto de linea ");
        }

        return false;
    }

}
