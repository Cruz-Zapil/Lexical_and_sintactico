package com.analizador.backEnd.parser.model.sentencia.expresion;

import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;

public class ExpresionRaiz {

    private ExpresionLogica expresionLogica = new ExpresionLogica();

    public boolean scanExpresion(int nivelIdentacion, ListaEnlazada tmpListToken) {

        System.out.println(" expresion  ");
        /// puede vernir solo una expresion logica
        if (expresionLogica.scanExpresionLogica(tmpListToken)) {
            return true;
        }

        return false;

    }

}
