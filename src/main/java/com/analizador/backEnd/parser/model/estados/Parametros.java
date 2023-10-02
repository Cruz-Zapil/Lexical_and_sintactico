package com.analizador.backEnd.parser.model.estados;

import com.analizador.backEnd.lexer.Token;

public class Parametros {

    int estado = 0;
    boolean pila = false;
    Parametro parametro = new Parametro();



    public boolean scanParametros(Token lexema , Def def) {

        switch (estado) {

            case 0:

                if (parametro.scanParametro(lexema, this)) {
                    def.setPila(true);
                    return true;
                }

            case 1:

                return true;

            case 2:

                return true;

            case 3:

                return true;

            default:
                break;
        }

        return false;

    }

}
