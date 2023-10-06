package com.analizador.backEnd.parser.model.funcion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.BloqueCodigo;

public class Bloque {

    int estado = 0;
    Token lexema;
    boolean tmp = true;

    public boolean secanBloque(Token lexema, ListaEnlazada listLexer) {

        /// se vio antes un lexema que aun no es salto de linea
        this.lexema = listLexer.eliminarPrimero();
        if (this.lexema.getTokenType().equals(BloqueCodigo.NEWLINE)) {
            // es nueva linea
      



        }

        return false;
    }

}
