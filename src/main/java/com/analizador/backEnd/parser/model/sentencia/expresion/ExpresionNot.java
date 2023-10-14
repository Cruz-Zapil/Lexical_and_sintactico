package com.analizador.backEnd.parser.model.sentencia.expresion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;

public class ExpresionNot {

    private ExpresionRelacional expresionRelacional = new ExpresionRelacional();
    
    public boolean scanExpresionNot(ListaEnlazada tmpListToken){

        /// PUEDE QUE VENGA UN NOT 

        Token tmpToken = tmpListToken.getSiguiente();
        System.out.println(" scanNot: "+ tmpToken.getTokenType());

        if(tmpToken.getTokenType().equals( Keyword.NOT)){
            tmpListToken.eliminarPrimero();
            System.out.println(" se obtuno un not" );
        }

      

        /// SI NO VIENE NOT VA DIRECTO A RELACIONAL 
        if (expresionRelacional.scanRelacional(tmpListToken)){
            return true;

        }    
   




        return false;
    }
    
}
