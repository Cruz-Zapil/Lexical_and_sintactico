package com.analizador.backEnd.parser.model.sentencia.expresion;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;

public class ExpresionRelacional {

    private ExpresionAditiva expresionAditiva = new ExpresionAditiva();

    public void scanRelacional(ListaEnlazada tmpListTokens){

        //// SOLO SE CONECTA CON LA EXPRESION ADITIVA
        
        expresionAditiva.scanExpresionAditiva(tmpListTokens);

        /// DEPUES ANALIZA LA POSIBILIDAD DE UN COMPRADOR Y OTRA EXPRESION ADITIVA 




    }


    
}
