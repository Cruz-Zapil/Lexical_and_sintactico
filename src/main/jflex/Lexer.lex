package com.analizador.backEnd.lexer.AFD;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.dictionary.BloqueCodigo;
import com.analizador.backEnd.lexer.dictionary.Constante;

%%

%class Lexer
%public
%type Token

%{

private int contador;
private boolean lex=false;
private boolean saltoLinea = false;

int contarIndentacion(String texto) {
    int tmp = 0;
    int identacion=0;
    for (char c : texto.toCharArray()) {
        if (c == ' ') {
            tmp++;
        } else if (c == '\t') {
            tmp+=4; // Ajusta la cantidad de espacios por tabulación según tus preferencias
        } else {
            break;
        }

        if(tmp==4){
            tmp=0;
            identacion++;
        }
    }
    return identacion;
}

%}

%init{
    contador = 1;
%init}

%eofval{
    return new Token(Constante.EOF, null, null, yyline, yychar);
%eofval}

%line

%char

digit = [0-9]
letter = [a-zA-Z]

%%

// Acciones de todo el código

"#".* { /* Ignore comentarios */ }
"#".*[\n] { /* Ignore comentarios con salto de línea */ 
if(lex){       
    return new Token(BloqueCodigo.NEWLINE, "BloqueCodigo", "\n", yyline, yychar);
}
}

// Token de palabras reservadas
{letter}+ {contador++; lex=true; saltoLinea=false; return new Token(0, yytext(), yyline, yychar);}

// Tokens de constantes
[_a-zA-Z][_a-zA-Z0-9]* {contador++; lex=true; saltoLinea=false; return new Token(Constante.ID, "Constante", yytext(), yyline, yychar);}
{digit}+ {contador++; lex=true; saltoLinea=false; return new Token(Constante.INT,  "Constante",yytext(), yyline, yychar);}
"\""[^\n]*"\"" {contador++; lex=true; saltoLinea=false; return new Token(Constante.STRING, "Constante", yytext(), yyline, yychar);}
"\'"[^\n]*"\'" {contador++; lex=true; saltoLinea=false; return  new Token(Constante.STRING, "Constante", yytext(), yyline, yychar);}
{digit}+"."{digit}+ {contador++; lex=true; saltoLinea=false; return new Token(Constante.DOUBLE, "Constante", yytext(), yyline, yychar);}

// Tokens de bloque de código

("\n"|"\r\n") {
    contador++;
    if(!saltoLinea){
        lex=false;
    return new Token(BloqueCodigo.NEWLINE, "BloqueCodigo", yytext(), yyline, yychar);
    }
}

////// token de bloqueCodigo
("    ")+ {
    if(!saltoLinea){
    int indentacionActual = contarIndentacion(yytext());
    contador++;
    return new Token(BloqueCodigo.IDENTACION, indentacionActual, yytext(), yyline, yychar);
    }
}

[\t] {
     if(!saltoLinea){
    int indentacionActual = contarIndentacion(yytext());
    contador++;
    return new Token(BloqueCodigo.IDENTACION, indentacionActual, yytext(), yyline, yychar);
    }
}



//// token operador doble
("**"|"--"|"++") {contador++; lex=true; saltoLinea = false; return new Token(1, yytext(),yyline, yychar);}

//// token de Aritmetico
("+"|"-"|"*"|"/"|"%"|"^") {contador++; lex=true; saltoLinea = false; return new Token(2, yytext(),yyline, yychar);}

//// token de Relacionales
("=="|"!="|"<"|">"|"<="|">=") {contador++; lex=true; saltoLinea = false; return new Token(3, yytext(),yyline, yychar);}

///// token delimitador
("("|")"|"{"|"}"|"["|"]"|";"|":"|"."|","|"="|"->"|"@") {contador++; lex=true; saltoLinea = false; return new Token(4, yytext(), yyline, yychar);}

//// token de Logicos
("and"|"or"|"not") {contador++; lex=true; saltoLinea = false; return new Token(5, yytext(),yyline, yychar);}

/// token de asignacion
("="|"+="|"-="|"*=") {contador++; lex=true; saltoLinea = false; return new Token(6, yytext(),yyline,yychar);}

(" ")+ {/*ignore*/}
// Token de símbolos no reconocidos
[^] {
    contador++;
    saltoLinea = false;
    lex=true;
    return new Token(Constante.SIMBOLO_NO_RECONOCIDO, "null", yytext(), yyline, yychar);
}
