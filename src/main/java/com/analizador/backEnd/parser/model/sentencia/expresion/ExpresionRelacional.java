package com.analizador.backEnd.parser.model.sentencia.expresion;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;

public class ExpresionRelacional {

    private ExpresionAditiva expresionAditiva = new ExpresionAditiva();

    public boolean scanRelacional(ListaEnlazada tmpListTokens){

        //// SOLO SE CONECTA CON LA EXPRESION ADITIVA
        
        System.out.println(" expreison relacional ");
        
           
        
        /// DEPUES ANALIZA LA POSIBILIDAD DE UN COMPRADOR Y OTRA EXPRESION ADITIVA 


        return expresionAditiva.scanExpresionAditiva(tmpListTokens);

    }


    
}
