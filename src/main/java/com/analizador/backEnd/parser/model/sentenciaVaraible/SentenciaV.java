package com.analizador.backEnd.parser.model.sentenciaVaraible;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.parser.model.Raiz;
import com.analizador.backEnd.parser.model.importacion.Modulos;

//// sentecia de varibles

public class SentenciaV {

    int estado = 0;
    ExpresionV expresiones = new ExpresionV();
    boolean pila = true;
    Token lexema;

    public void scanSentenciaV(Token lexema, Raiz raiz) {

        /// solicitar sigente lexema:
        /// se analiza si no es un salto de linea

        while (pila) {

            if (pila) {
                /// solicitar lexema
                this.lexema = lexema;

            }

            if (!expresiones.scanExpresion(lexema, this) ) {
                /// solicitar siguente lexema
                pila = false;

                System.out.println(" hay problemas");
            }
        }

    }

}
