package com.analizador.backEnd.parser.model.sentencia;
import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.BloqueCodigo;
import com.analizador.backEnd.lexer.dictionary.simples.Delimitador;
import com.analizador.backEnd.parser.model.sentencia.expresion.ExpresionRaiz;

public class Asignacion {


    private ExpresionRaiz expresionRaiz;

    /// primero viene una expresion 

    public boolean scanAsigancion(ListaEnlazada listTokens){
        
        System.out.println(" desde asignacion "+ listTokens.getPrimerElemento().toString());
        if (expresionRaiz.scanExpresion(0, listTokens)) {
            Token tmp= listTokens.eliminarPrimero();
            if (tmp.getTokenType().equals(Delimitador.ASIGNACION)) {
                System.out.println(" es una asignacion");
                return new ExpresionRaiz().scanExpresion(0, listTokens);                
                
            }else if(tmp.getTokenType().equals(BloqueCodigo.NEWLINE)) {
                System.out.println(" si fue una asigancion");
                return true;

            }
            
        }else {
            System.out.println(" deber haber un error en asignacion ");
        }
        




        return false;

        
    }



    /// puede venier o no un igual



    /// puede o no venir una expreision 


    
}
