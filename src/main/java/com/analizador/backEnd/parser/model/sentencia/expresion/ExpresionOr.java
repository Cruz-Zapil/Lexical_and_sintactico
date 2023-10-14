package com.analizador.backEnd.parser.model.sentencia.expresion;

import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;

public class ExpresionOr {

    private ExpresionAnd expresionAnd = new ExpresionAnd();

    public boolean scanExpresionOr(ListaEnlazada tmpListaTokens){


        //// RECORDAR QUE ESTO ES UN CICLO

        System.out.println(" expreson or");
        if (expresionAnd.scanExpresionAnd(tmpListaTokens)) {
            return true;
        }
        

        // LO QUE VIENE ES UN CICLO Y UN AND
        



        return false;
    }
    
}
