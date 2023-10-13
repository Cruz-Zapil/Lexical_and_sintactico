package com.analizador.backEnd.parser.model.sentencia.expresion;

import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;

public class ExpresionAnd {


    private ExpresionNot expresionNot = new ExpresionNot();


    public boolean scanExpresionAnd(ListaEnlazada tmpListToken){
        
        expresionNot.scanExpresionNot(tmpListToken);

        /// LO QUE VIENE ES UN CICLO Y UN NOT


        return false;
    }
    
}
