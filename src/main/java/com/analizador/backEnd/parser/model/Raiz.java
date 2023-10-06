package com.analizador.backEnd.parser.model;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.almacenamieto.Nodo;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;
import com.analizador.backEnd.parser.model.clase.Clase;
import com.analizador.backEnd.parser.model.funcion.Funciondef;
import com.analizador.backEnd.parser.model.importacion.Importacion;
import com.analizador.backEnd.parser.model.sentencia.Sentencia;
import com.analizador.backEnd.parser.model.sentenciaVaraible.SentenciaV;

public class Raiz {

    /// parar el ciclo

    boolean enCiclo = true;

    ListaEnlazada lista = new ListaEnlazada();

    boolean importacion = false;
    boolean sentencia = false;
    boolean funcion = false;
    boolean clase = false;

    boolean sentenciaV = false;

    Importacion importacionClass = new Importacion();
    Funciondef funcionCalss = new Funciondef();
    Sentencia sentenciaClass = new Sentencia();
    Clase claseClass = new Clase();

    SentenciaV sentenciaVClass = new SentenciaV();

    public void scanRaiz(ListaEnlazada listaLexema) {

        this.lista = listaLexema;

        while (enCiclo) {

            Token lexema = lista.eliminarPrimero();
            System.out.println("comenzar:  "+ lexema.getLexeme());


            if (lexema.getTokenType() != Constante.EOF) {

                if (importacion == false && sentencia == false && sentenciaV == false && funcion == false
                        && clase == false) {

                    if (lexema.getTokenType().equals(Keyword.IMPORT)) {

                        System.out.println(" aqui debe ser import: " + lexema.getLexeme());

                        /// siguente lexema
                        importacion = true;

                        if (!importacionClass.scanImport(lexema, this, lista)) {
                            importacionClass = new Importacion();
                            importacion = false;
                        }

                    } else if (lexema.getLexeme().equals("class")) {

                        clase = true;
                    } else if (lexema.getTokenType().equals(Keyword.DEF)) {

                        System.out.println(" aqui debe ser def fucion");

                        if (!funcionCalss.scanFuncionDef(lexema, this, lista)) {
                            funcionCalss = new Funciondef();
                            funcion = false;
                        }

                        funcion = true;

                    } else if (lexema.getLexeme().equals(Constante.ID)) {
                        /// se nececista arreglar esto
                        System.out.println(" puede que sea una sentencia de variables");

                        sentenciaVClass.scanSentenciaV(lexema, this);

                        sentenciaV = true;

                    }

                } else {

                    if (importacion == true) {

                        // importacionClass.scanImport(lexema, this, lista);

                        if (lexema.getTokenType().equals(Keyword.IMPORT)) {

                            System.out.println("--- import: " + lexema.getLexeme() + "-------");

                            if (!importacionClass.scanImport(lexema, this, lista)) {
                                importacionClass = new Importacion();
                                importacion = false;
                            }
                            importacion = true;
                        }

                    } else if (sentencia == true) {

                        sentenciaClass.scanSentencia(lexema, this);

                    } else if (funcion == true) {

                        if (lexema.getTokenType().equals(Keyword.DEF)) {

                            System.out.println(" aqui debe ser def fucion");
                            funcion = true;

                            if (!funcionCalss.scanFuncionDef(lexema, this, lista)) {
                                funcionCalss = new Funciondef();
                                funcion = false;
                            }


                        }

                    } else if (clase == true) {

                        claseClass.scanClase(lexema, this, lista);

                    } else if (sentenciaV == true) {
                        sentenciaClass.scanSentencia(lexema, this);
                    }

                }

            } else {

                enCiclo = false;

            }

        }

    }


}
