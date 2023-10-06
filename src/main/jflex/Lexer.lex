package com.analizador.backEnd.lexer.AFD;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.dictionary.BloqueCodigo;
import com.analizador.backEnd.lexer.dictionary.Constante;

%%

%class Lexer
%public
%type Token

%{

private int contador;
private int currentIndent = 0;
private Stack<Integer> indentStack = new Stack<>();
private boolean saltoLinea = false;
private List<Token> dedentTokens = new ArrayList<>();

int contarIndentacion(String texto) {
    int contador = 0;
    for (char c : texto.toCharArray()) {
        if (c == ' ') {
            contador++;
        } else if (c == '\t') {
            contador += 4; // Ajusta la cantidad de espacios por tabulación según tus preferencias
        } else {
            break;
        }
    }
    return contador;
}

void dedentTokens() {
    while (!indentStack.isEmpty() && currentIndent < indentStack.peek()) {
        currentIndent = indentStack.pop();
        contador++;
        dedentTokens.add(new Token(BloqueCodigo.DEDENT, "BloqueCodigo", "", yyline, yychar));
    }
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
"#".*[\n] { /* Ignore comentarios con salto de línea */ }

// Token de palabras reservadas
{letter}+ {contador++; saltoLinea=false; return new Token(0, yytext(), yyline, yychar);}

// Tokens de constantes
[_a-zA-Z][_a-zA-Z0-9]* {contador++; saltoLinea=false; return new Token(Constante.ID, "Constante", yytext(), yyline, yychar);}
{digit}+ {contador++; saltoLinea=false; return new Token(Constante.INT, yytext(), "Constante", yyline, yychar);}
"\""[^\n]*"\"" {contador++; saltoLinea=false; return new Token(Constante.STRING, "Constante", yytext(), yyline, yychar);}
"\'"[^\n]*"\'" {contador++; saltoLinea=false; return  new Token(Constante.STRING, "Constante", yytext(), yyline, yychar);}
{digit}+"."{digit}+ {contador++; saltoLinea=false; return new Token(Constante.DOUBLE, "Constante", yytext(), yyline, yychar);}

// Tokens de bloque de código

("\n"|"\r\n") {
    int indentacionActual = contarIndentacion(yytext());
    if (indentacionActual > currentIndent) {
        // Aumento de indentación
        indentStack.push(currentIndent);
        currentIndent = indentacionActual;
    } else if (indentacionActual < currentIndent) {
        // Dedentación
        while (indentacionActual < currentIndent) {
            currentIndent = indentStack.pop();
            contador++;
            dedentTokens.add(new Token(BloqueCodigo.DEDENT, "BloqueCodigo", "", yyline, yychar));
        }
    }
    contador++;
    saltoLinea = true;
    return new Token(BloqueCodigo.NEWLINE, "BloqueCodigo", yytext(), yyline, yychar);
}

("    ") {
    int indentacionActual = contarIndentacion(yytext());
    if (indentacionActual > currentIndent) {
        // Aumento de indentación
        indentStack.push(currentIndent);
        currentIndent = indentacionActual;
    } else if (indentacionActual < currentIndent) {
        // Dedentación
        while (indentacionActual < currentIndent) {
            currentIndent = indentStack.pop();
            contador++;
            dedentTokens.add(new Token(BloqueCodigo.DEDENT, "BloqueCodigo", "", yyline, yychar));
        }
    }
    contador++;
    saltoLinea = false;
    return new Token(BloqueCodigo.IDENTACION, "BloqueCodigo", yytext(), yyline, yychar);
}

[\t] {
    int indentacionActual = contarIndentacion(yytext());
    if (indentacionActual > currentIndent) {
        // Aumento de indentación
        indentStack.push(currentIndent);
        currentIndent = indentacionActual;
    } else if (indentacionActual < currentIndent) {
        // Dedentación
        while (indentacionActual < currentIndent) {
            currentIndent = indentStack.pop();
            contador++;
            dedentTokens.add(new Token(BloqueCodigo.DEDENT, "BloqueCodigo", "", yyline, yychar));
        }
    }
    contador++;
    saltoLinea = false;
    return new Token(BloqueCodigo.IDENTACION, "BloqueCodigo", yytext(), yyline, yychar);
}


////// token de bloqueCodigo
("\r\n"|"\n") {contador++; return new Token(BloqueCodigo.NEWLINE,"BloqueCodigo", yytext(), yyline, yychar);}
("    ") {contador++; return new Token(BloqueCodigo.IDENTACION,"BloqueCodigo", yytext(), yyline, yychar);}
[\t] {contador++; return new Token(BloqueCodigo.IDENTACION,"BloqueCodigo", yytext(), yyline, yychar);}

//// token operador doble
("**"|"--"|"++") {contador++; return new Token(1, yytext(),yyline, yychar);}

//// token de Aritmetico
("+"|"-"|"*"|"/"|"%"|"^") {contador++; return new Token(2, yytext(),yyline, yychar);}

//// token de Relacionales
("=="|"!="|"<"|">"|"<="|">=") {contador++; return new Token(3, yytext(),yyline, yychar);}

///// token delimitador
("("|")"|"{"|"}"|"["|"]"|";"|":"|"."|","|"="|"->"|"@") {contador++; return new Token(4, yytext(), yyline, yychar);}

//// token de Logicos
("and"|"or"|"not") {contador++; return new Token(5, yytext(),yyline, yychar);}

/// token de asignacion
("="|"+="|"-="|"*=") {contador++; return new Token(6, yytext(),yyline,yychar);}

(" ")+ {/*ignore*/}
// Token de símbolos no reconocidos
[^] {
    contador++;
    saltoLinea = false;
    return new Token(Constante.SIMBOLO_NO_RECONOCIDO, "null", yytext(), yyline, yychar);
}
