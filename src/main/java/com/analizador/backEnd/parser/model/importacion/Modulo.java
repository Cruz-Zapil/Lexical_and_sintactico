package com.analizador.backEnd.parser.model.importacion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;
import com.analizador.backEnd.parser.model.Auxiliar;

public class Modulo {

    int estados = 0;
    boolean pila = false;

    public boolean scanModulo(Token lexema, Modulos modulos, ListaEnlazada lista) {

        
        if (estados == 0) {

            if (lexema.getTokenType().equals(Constante.ID)) {
                estados = 1;
                System.out.println("deber ir un id: "+ lexema.getLexeme());
              //  Auxiliar.setLexema(lista.getPosicionDeToken(lexema)+1, " enviado desde mosdulo Id");
                return true;
            } else {
                /// deberia mostrar un error
                System.out.println(" error en el modulo id");
                return false;
            }

        } else if (estados == 1) {
            if (lexema.getTokenType().equals(Keyword.AS)) {
              //  Auxiliar.setLexema(lista.getPosicionDeToken(lexema)+1, " enviado desde modulo as");
                System.out.println("----deberia ser una as: "+ lexema.getLexeme());
                estados = 0;
                return true;
            } else {
                /// deberia mostrar un error
                System.out.println(" error en el modulo as");
                return false;
            }
            

        }

        return false;

    }

}
