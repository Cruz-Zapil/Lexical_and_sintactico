package com.analizador.backEnd.parser.model.importacion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.dictionary.BloqueCodigo;
import com.analizador.backEnd.lexer.dictionary.simples.Delimitador;

public class Modulos {

    int estados = 0;
    Modulo modulo = new Modulo();
    boolean pila = true;

    public boolean scanModulos(Token lexema, Importacion modulos) {
        if (pila) {

            if (estados == 1 && lexema.getLexeme().equals(BloqueCodigo.NEWLINE)) {

                System.out.println(" se termino la primera linea");

                return false;

            }

            switch (estados) {
                case 0:

                    if (modulo.scanModulo(lexema, this)) {
                        estados = 1;
                        return true;
                    } else {
                        pila = false;
                        System.out.println(" por el momento hay un error");
                    }

                    break;

                case 1:

                    if (lexema.getLexeme().equals(Delimitador.COMA)) {
                        estados = 0;
                        return true;
                    } else {
                        /// deberia mostrar un error
                        System.out.println(" error en el modulo");
                        return false;
                    }

                default:
                    break;
            }
        }

        return false;

    }

}
