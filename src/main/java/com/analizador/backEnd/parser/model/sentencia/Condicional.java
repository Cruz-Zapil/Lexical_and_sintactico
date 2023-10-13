package com.analizador.backEnd.parser.model.sentencia;

import org.stringtemplate.v4.compiler.CodeGenerator.region_return;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;

public class Condicional {

    Token lexema;
    boolean pila = true;
    //// tener en cuneta la identacion
    int identacion =0;

    public boolean scanCondicinal(int identacion ,ListaEnlazada listToken){

        /// se tiene eliminar el token anterior
        
        this.lexema = listToken.eliminarPrimero();
        this.identacion = identacion;

        if (this.lexema.getTokenType().equals(Keyword.IF)) {
            
            /// si es verdad que hay un if
            /// teine que venir expresion:
            

            
            


            
        }else {
            System.out.println(" erro no es una condicion: ");

        }
        

        return false;
    }

    
}
