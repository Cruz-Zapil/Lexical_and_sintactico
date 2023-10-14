package com.analizador.backEnd.parser.model.sentencia.expresion;

import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;

public class ExpresionAnd {


    private ExpresionNot expresionNot = new ExpresionNot();


    public boolean scanExpresionAnd(ListaEnlazada tmpListToken){
        
        System.out.println(" expresion and");
        if (expresionNot.scanExpresionNot(tmpListToken)) {
        
            return true;
        }
        

        /// LO QUE VIENE ES UN CICLO Y UN NOT


        return false;
    }
    
}
