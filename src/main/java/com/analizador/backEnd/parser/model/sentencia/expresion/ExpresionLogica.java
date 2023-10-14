package com.analizador.backEnd.parser.model.sentencia.expresion;

import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;

public class ExpresionLogica {

    private ExpresionOr expresionOr = new ExpresionOr();

    public boolean scanExpresionLogica(ListaEnlazada tmpsListaToken){


        ///// RECORDAR QUE ESTO ES UN CICLO

        System.out.println(" expresion logica ");
        if (expresionOr.scanExpresionOr(tmpsListaToken) ) {
       
            return true;
        }
       

        //// LO QUE VIENE ES UN CICLO Y UN OR 
        


        return false;
    }
    
}
