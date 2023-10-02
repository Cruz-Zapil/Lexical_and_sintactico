package com.analizador.backEnd.parser.model.importacion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;

public class Modulo {

    int estados = 0;
    Modulo modulo = new Modulo();
    boolean pila = false;

    public boolean scanModulo(Token lexema, Modulos modulos) {

        if (estados == 0) {

            if (lexema.getLexeme().equals(Constante.ID)) {
                estados = 1;
                return true;
            } else {
                /// deberia mostrar un error
                System.out.println(" error en el modulo");
                return false;
            }

        } else if (estados == 1) {
            if (lexema.getLexeme().equals(Keyword.AS)) {
                estados = 0;
                return true;
            } else {
                /// deberia mostrar un error
                System.out.println(" error en el modulo");
                return false;
            }
            

        }

        return false;

    }

}
