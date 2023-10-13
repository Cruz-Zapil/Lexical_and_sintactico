package com.analizador.backEnd.parser.model.sentencia.expresion;

import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;

public class ExpresionNot {

    private ExpresionRelacional expresionRelacional = new ExpresionRelacional();
    
    public boolean scanExpresionNot(ListaEnlazada tmpListToken){

        /// PUEDE QUE VENGA UN NOT 



        /// SI NO VIENE NOT VA DIRECTO A RELACIONAL 
    
        expresionRelacional.scanRelacional(tmpListToken);




        return false;
    }
    
}
