package com.analizador.backEnd.parser.model.funcion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.simples.Delimitador;

public class Parametros {

    boolean pila = true;
    int estado = 0;
    Token lexema;

    public void scanParametros(Token lexema, ListaEnlazada listLexema) {

        // this.lexema = lexema;
        if (!listLexema.getSiguiente().getTokenType().equals(Delimitador.PARENTESIS_CIERRE)) {

            while (pila) {

                this.lexema = listLexema.eliminarPrimero();

                if (this.lexema.getTokenType().equals(Constante.ID)) {

                    if (listLexema.getSiguiente().getTokenType().equals(Delimitador.COMA)) {
                        listLexema.eliminarPrimero();
                    } else {
                        /// se detiene el ciclo
                        pila = false;
                    }

                } else {
                    System.out.println(" error sintactico se esperaba un ID");
                }
            }
        } else {
            System.out.println(" se econtro un parentesis vacio toca regresar");
        }
    }

}
