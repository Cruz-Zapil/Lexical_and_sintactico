package com.analizador.frontEnd.accionesBotton;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.AFD.Lexer;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.frontEnd.accionesBotton.utils.Message;

public class ConectarLexer {

    /// tabla general
    /// crear una tabla por bloque de codigo 
    private ListaEnlazada listaTokens = new ListaEnlazada();
    private ListaEnlazada listaErrorLexico = new ListaEnlazada();
    

    public ListaEnlazada conectarLexer(String codigo) throws IOException {

        if (codigo != null && !codigo.equals("")) {
            Reader extraerTexto = new StringReader(codigo);
            Lexer lexer = new Lexer(extraerTexto);
            Token token = lexer.yylex();

            while (token.getTokenType() != Constante.EOF) {

                if (token.getTokenType() != Constante.ErrorLexico) {
                    
                    listaTokens.insertarAlFinal(token);
                    token = lexer.yylex();
                }else {
                    listaErrorLexico.insertarAlFinal(token);
                    token= lexer.yylex();
                }


            }
            /// insertamos el token final de archivo que es EOF
            listaTokens.insertarAlFinal(token);
            listaErrorLexico.insertarAlFinal(token);

        } else {
            Message.mostrarMensajeError("La entrada de texto esta vacia", " Error!!!");
        }

        return listaTokens;
    }

}
