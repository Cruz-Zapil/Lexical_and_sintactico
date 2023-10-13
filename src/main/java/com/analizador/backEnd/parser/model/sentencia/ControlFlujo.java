package com.analizador.backEnd.parser.model.sentencia;



import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;

public class ControlFlujo {

    private Token lexema;
    private  int identacion;


    public boolean scanControlFlujo(int identacion , ListaEnlazada tmpListTokens){

        this.identacion = identacion;

        if (lexema.getTokenType().equals(Keyword.BREAK)) {
            
        }else if (lexema.getTokenType().equals(Keyword.CONTINUE)){

        }else if (lexema.getTokenType().equals(Keyword.PASS)){

        }

        
        

        return false;
    }
    
}
