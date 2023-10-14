package com.analizador.backEnd.parser.model.sentencia;




import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;

public class ControlFlujo {

    private Token lexema;
    private  int identacion;


    public boolean scanControlFlujo(int identacion , ListaEnlazada tmpListTokens){

        this.identacion = identacion;

        this. lexema = tmpListTokens.eliminarPrimero();

        if (lexema.getTokenType().equals(Keyword.BREAK)) {
            System.out.println(" control de flujo 1" + lexema.getTokenType());
            return true;            
        }else if (lexema.getTokenType().equals(Keyword.CONTINUE)){

            System.out.println(" control de flujo 2" + lexema.getTokenType() );
            return true;
        }else if (lexema.getTokenType().equals(Keyword.PASS)){

            System.out.println(" control de flujo 3" + lexema.getTokenType() );
            return true;
        }

        System.out.println(" ninguno es control de flujo ");
        
        

        return false;
    }
    
}
