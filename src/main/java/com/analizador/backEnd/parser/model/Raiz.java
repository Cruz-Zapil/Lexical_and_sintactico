package com.analizador.backEnd.parser.model;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.parser.model.clase.Clase;
import com.analizador.backEnd.parser.model.funcion.Funcion;
import com.analizador.backEnd.parser.model.importacion.Importacion;
import com.analizador.backEnd.parser.model.sentencia.Sentencia;
import com.analizador.backEnd.parser.model.sentenciaVaraible.SentenciaV;

public class Raiz {

    boolean importacion = false;
    boolean sentencia = false;
    boolean funcion = false;
    boolean clase = false;

    boolean sentenciaV = false;

    Importacion importacionClass = new Importacion();
    Funcion funcionCalss = new Funcion();
    Sentencia sentenciaClass = new Sentencia();
    Clase claseClass = new Clase();
    
    SentenciaV sentenciaVClass= new SentenciaV();
    

    public boolean scanRaiz(Token lexema) {

        if (importacion == false && sentencia == false && sentenciaV ==false  && funcion == false && clase == false) {

            if (lexema.getLexeme().equals("import")) {
                
                /// siguente lexema
                importacionClass.scanImport(lexema, this);
                
                importacion = true;

            } else if (lexema.getLexeme().equals("class")) {

                clase = true;
            } else if (lexema.getLexeme().equals("def")) {
                funcion = true;

            } else if (lexema.getLexeme().equals(Constante.ID)) {
                /// se nececista arreglar esto
                System.out.println(" puede que sea una sentencia de variables");

                sentenciaVClass.scanSentenciaV(lexema, this);

                sentenciaV = true;


            }

        } else {

            if (importacion == true) {

                importacionClass.scanImport(lexema, this);

            } else if (sentencia == true) {

                sentenciaClass.scanSentencia(lexema, this);

            } else if (funcion == true) {

                funcionCalss.scanFuncion(lexema, this);

            } else if (clase == true) {

                claseClass.scanClase(lexema, this);

            } else if (sentenciaV == true){
                sentenciaClass.scanSentencia(lexema, this);
            }

        }

        return false;

    }

}
