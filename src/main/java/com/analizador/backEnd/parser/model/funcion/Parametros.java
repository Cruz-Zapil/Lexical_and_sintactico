package com.analizador.backEnd.parser.model.funcion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.simples.Delimitador;

public class Parametros {

    boolean pila = true;
    int estado = 0;
    Token lexema;

    public boolean scanParametros(Token lexema, ListaEnlazada listLexema) {

       // this.lexema = lexema;

        while (pila) {

            if (lexema.getTokenType().equals(Constante.ID) && estado ==0 ) {

                if (listLexema.getSiguiente().getTokenType().equals(Delimitador.COMA)) {
                    this.lexema = listLexema.eliminarPrimero();
                    this.lexema= listLexema.eliminarPrimero();
                    estado=1;    
                                  
                } else {
                    return false;
                }

                if (lexema.getTokenType().equals(Constante.ID)) {
                    estado=0;                    
                }else{
                    System.out.println(" sintasis error se esperaba id ");
                    return false;
                }

            } else  {
                return false;

            }
        }

        return false;
    }

}
