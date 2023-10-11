package com.analizador.backEnd.parser.model.importacion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.BloqueCodigo;
import com.analizador.backEnd.lexer.dictionary.simples.Delimitador;

public class Modulos {

    int estados = 0;
    Modulo modulo = new Modulo();
    boolean pila = true;
  

    public boolean scanModulos(Token lexema, Importacion modulos, ListaEnlazada lista) {
     
        if (pila) {


            if (estados == 1 && lexema.getTokenType().equals(BloqueCodigo.NEWLINE)) {

                System.out.println("termino de linea: "+ lexema.getLexeme());
               // Auxiliar.setLexema(lista.getPosicionDeToken(lexema) + 1, " enviado desde modulos NL");
               
               estados = 0;

                return false;

            } else {

                switch (estados) {
                    case 0:

                        if (modulo.scanModulo(lexema, this, lista)) {
                            estados = 1;
                          //  Auxiliar.setLexema(lista.getPosicionDeToken(lexema) + 1, " enviado desde modulos Id");

                            return true;
                        } else {
                            System.out.println("fffff ");
                            return false;
                        }

                        

                    case 1:

                        if (lexema.getTokenType().equals(Delimitador.COMA)) {
                            estados = 0;
                           //  Auxiliar.setLexema(lista.getPosicionDeToken(lexema) + 1, " enviado desde modulos coma");
                
                            return true;
                        } else {
                            /// deberia mostrar un error
                            System.out.println(" error en el modulo");
                            return false;
                        }

                    default:
                        break;
                }
            }

        }

        return false;

    }

}
