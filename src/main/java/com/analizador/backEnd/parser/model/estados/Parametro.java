package com.analizador.backEnd.parser.model.estados;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.simples.Delimitador;

public class Parametro {

    int estado = 0;

    public boolean scanParametro(Token lexema, Parametros parametros) {

        switch (estado) {
            case 0:

                if (lexema.getTokenType().equals(Constante.ID)) {
                    estado++;
                    return true;
                }
                break;

            case 1:

                if (lexema.getTokenType().equals(Delimitador.DOS_PUNTOS)) {
                    estado++;
                    return true;
                }
                break;

            case 2:

                if (lexema.getTokenType().equals(Constante.ID)) {
                    estado++;
                    return true;
                }
                break;

            default:
                break;
        }

        return false;

    }

}
