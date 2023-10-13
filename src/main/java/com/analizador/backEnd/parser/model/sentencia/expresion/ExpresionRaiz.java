package com.analizador.backEnd.parser.model.sentencia.expresion;


import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;

public class ExpresionRaiz {

    private ExpresionLogica expresionLogica = new ExpresionLogica();


    public boolean scanExpresion(int nivelIdentacion ,ListaEnlazada tmpListToken){

        
        /// puede vernir solo una expresion logica 
        expresionLogica.scanExpresionLogica(tmpListToken);
        


        return false;

    }
    

    
}
