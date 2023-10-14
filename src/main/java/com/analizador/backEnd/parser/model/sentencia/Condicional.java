package com.analizador.backEnd.parser.model.sentencia;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;
import com.analizador.backEnd.lexer.dictionary.simples.Delimitador;
import com.analizador.backEnd.parser.model.sentencia.expresion.ExpresionRaiz;

public class Condicional {

    private Token lexema;
    private boolean pila = true;
     //// tener en cuneta la identacion
    private int identacion = 0;
    private ExpresionRaiz expresionRaiz = new ExpresionRaiz();

    public boolean scanCondicinal(int identacions, ListaEnlazada listToken) {

        /// se tiene eliminar el token anterior

        this.lexema = listToken.getPrimerElemento();
        this.identacion = identacions;

        if (this.lexema.getTokenType().equals(Keyword.IF)) {

            /// si es verdad que hay un if
            /// teine que venir expresion:
            listToken.eliminarPrimero();
            System.out.println(" estamos en if condicional");

            if (expresionRaiz.scanExpresion(this.identacion, listToken)) {
                
                System.out.println(" se encontro un if y se envia a scan condicional");
                this.lexema = listToken.eliminarPrimero();
                if (this.lexema.getTokenType().equals(Delimitador.DOS_PUNTOS)) {
                    
                    System.out.println(" conectar con bloque ");


                }else {
                    System.err.println(" error sintactico ");
                    return false;
                }
            }
            

        } else {
            System.out.println(" erro no es una condicion: ");

        }

        return false;
    }

}
