package com.analizador.backEnd.parser.model;

import org.antlr.v4.parse.ANTLRParser.setElement_return;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;
import com.analizador.backEnd.parser.model.clase.Clase;
import com.analizador.backEnd.parser.model.funcion.Funciondef;
import com.analizador.backEnd.parser.model.importacion.Importacion;
import com.analizador.backEnd.parser.model.sentencia.RaizSentencia;

public class Raiz {

    /// parar el ciclo
    boolean enCiclo = true;

    ListaEnlazada lista = new ListaEnlazada();

    boolean importacion = false;
    boolean sentencia = false;
    boolean funcion = false;
    boolean clase = false;

    Importacion importacionClass = new Importacion();
    Funciondef funcionCalss = new Funciondef();
    RaizSentencia sentenciaClass = new RaizSentencia();
    Clase claseClass = new Clase();

    public void scanRaiz(ListaEnlazada listaLexema) {

        this.lista = listaLexema;

        while (enCiclo) {

            Token lexema = lista.getPrimerElemento();
            System.out.println("comenzar:  " + lexema.getLexeme());

            if (lexema.getTokenType() != Constante.EOF) {

                if (importacion == false && sentencia == false && funcion == false
                        && clase == false) {

                    if (lexema.getTokenType().equals(Keyword.IMPORT)) {

                        System.out.println(" aqui debe ser import: " + lexema.getLexeme());

                        /// siguente lexema
                        importacion = true;
                        lista.eliminarPrimero();
                        if (!importacionClass.scanImport(lista)) {
                            importacionClass = new Importacion();
                            importacion = false;
                        }

                    } else if (lexema.getLexeme().equals("class")) {

                        clase = true;
                    } else if (lexema.getTokenType().equals(Keyword.DEF)) {

                        System.out.println(" aqui debe ser def fucion");

                        if (!funcionCalss.scanFuncionDef(lista)) {
                            funcionCalss = new Funciondef();
                            lista.eliminarPrimero();
                            funcionCalss.scanFuncionDef(lista);
                            funcion = false;
                        }

                        funcion = true;

                    } else {
                        /// se nececista arreglar esto
                        System.out.println(" puede que sea una sentencia lexema: " + lexema.getTokenType());
                        
                        // sentenciaVClass.scanSentenciaV(lexema, this);
                        sentenciaClass.scanSentencia(listaLexema);
                        sentencia = true;

                    }

                } else {

                    if (importacion == true) {

                        // importacionClass.scanImport(lexema, this, lista);

                        if (lexema.getTokenType().equals(Keyword.IMPORT)) {

                            System.out.println("--- import: " + lexema.getLexeme() + "-------");
                            lista.eliminarPrimero();
                            if (!importacionClass.scanImport(lista)) {
                                importacionClass = new Importacion();
                                importacion = false;
                            }
                            importacion = true;
                        }

                    } else if (sentencia == true) {

                        sentenciaClass.scanSentencia(listaLexema);

                    } else if (funcion == true) {

                        if (lexema.getTokenType().equals(Keyword.DEF)) {

                            System.out.println(" aqui debe ser def fucion");
                            funcion = true;
                            lista.eliminarPrimero();
                            if (!funcionCalss.scanFuncionDef(lista)) {
                                funcionCalss = new Funciondef();
                                funcion = false;
                            }

                        }

                    } else if (clase == true) {

                        claseClass.scanClase(lexema, this, lista);

                    } else if (sentencia == true) {
                        sentenciaClass.scanSentencia( listaLexema);
                    }

                }

            } else {

                enCiclo = false;

            }

        }

    }

}
