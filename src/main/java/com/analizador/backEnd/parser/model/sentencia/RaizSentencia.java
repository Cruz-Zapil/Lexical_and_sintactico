package com.analizador.backEnd.parser.model.sentencia;

import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.parser.model.importacion.Importacion;
import com.analizador.backEnd.parser.model.sentencia.expresion.ExpresionRaiz;

public class RaizSentencia {

    private ListaEnlazada listTokens;
    private ListaEnlazada tmpListTokens;
    private int nivelIdentacion;

    /// **** SENTENCIAS ***

    private ExpresionRaiz expresionRaiz = new ExpresionRaiz();
    private Asignacion asignacion = new Asignacion();
    private Condicional condicional = new Condicional();
    private SentenciaBucle sentenciaBucle = new SentenciaBucle();
    private ControlFlujo controlFlujo = new ControlFlujo();
    private Importacion importacion = new Importacion();
    private TryException tryException = new TryException();
    private SentenciaWith sentenciaWith = new SentenciaWith();
    private SentenciaReturn sentenciaReturn = new SentenciaReturn();
    private SenetenciaYield senetenciaYield = new SenetenciaYield();
    private SentenciaAssert sentenciaAssert = new SentenciaAssert();
    private SentenciaGlobal sentenciaGlobal = new SentenciaGlobal();
    private SentenciaNoLocal sentenciaNoLocal = new SentenciaNoLocal();

    public void scanSentencia( ListaEnlazada listTokens) {

        //// se analiza en que otros nodos o ramas se va

      
        tmpListTokens = listTokens;

        // ESTO ES UN CICLO
        // PUEDE VENIR UNA O MAS
        // VECES CADA EXPRESION
        // SE DEVERA MANEJARLO BIEN
        // PARA ACABAR CON EL CICLO
        // SE DEBERA VER LA IDENTACION


        /*
        if (nivelIdentacion == 0) {

        } else {
            System.out.println(" error sintanctico ");
        }
        */

        System.out.println( " llegamos a una scan sentencia ");

        
        if (expresionRaiz.scanExpresion(nivelIdentacion, this.tmpListTokens)) {

            // se analiza si es una expresion
            // conectar con expresion
            listTokens = tmpListTokens;

        } else if (asignacion.scanAsigancion(tmpListTokens)) {
            //// se analiza si es una asiganacion
            listTokens = tmpListTokens;

        } else if (condicional.scanCondicinal(nivelIdentacion, tmpListTokens)) {

            /// se analiza si es una sentancia condicional
            listTokens = tmpListTokens;

        } else if (sentenciaBucle.scanBucle(tmpListTokens)) {

            // se analiza si es una sentancia de bucle
            listTokens = tmpListTokens;

        } else if (controlFlujo.scanControlFlujo(nivelIdentacion,tmpListTokens)) {
            // se analiza si es una contrul de flujo
            listTokens = tmpListTokens;

        } else if (importacion.scanImport( tmpListTokens)) {

            /// se analiz asi es una importacion
            listTokens = tmpListTokens;

        } else if (tryException.scanTryException(nivelIdentacion , tmpListTokens)) {

            /// se analiza si es una try Except
            listTokens = tmpListTokens;

        } else if (sentenciaWith.scanSentenciaWhit(tmpListTokens)) {

            /// se analiza si es una with
            listTokens = tmpListTokens;

        } else if (sentenciaReturn.scanReturn(tmpListTokens)) {

            // se anali si es una return
            listTokens = tmpListTokens;

        } else if (senetenciaYield.scanSentenciaYield(tmpListTokens)) {
            // se analiza si es un yield
            listTokens = tmpListTokens;

        } else if (sentenciaAssert.scanAssert(tmpListTokens)) {

            /// se analiza si es un assert
            listTokens = tmpListTokens;

        } else if (sentenciaGlobal.scanGlobal(tmpListTokens)) {

            /// se analiza si es una sentencia global
            listTokens = tmpListTokens;

        } else if (sentenciaNoLocal.scanNoLocal(tmpListTokens)) {
            /// se analiza si es una sentencia no local
            listTokens = tmpListTokens;

        } else {

            System.out.println(" hay un errorsote");

        }

    }

}
