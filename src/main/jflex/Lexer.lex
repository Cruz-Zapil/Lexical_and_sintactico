package com.analizador.backEnd.lexer.AFD;

import java.io.*;
import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.dictionary.*;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;

%%
%public
%class Lexer
%type Token

%{
private int contador;

%}

%init{
    contador = 1;
%init}

//// fin de fichero 
%eofval{
    return new Token(Constante.EOF,null,null,yyline, yychar);
%eofval}

%line

%char

digit = [0-9]
letter = [a-zA-Z]

%%

/// aciones de todo el codigo


"#".* {/*ignore*/}

/// token de palabras reservadas
{letter}+ {contador++; return new Token(0,null ,yytext(), yyline, yychar);}

//// token constantes 
[_a-zA-Z][_a-zA-Z0-9]* {contador++; return new Token(Constante.ID,"Constante",yytext() , yyline , yychar);}
{digit}+ {contador++; return new Token(Constante.INT, yytext(),"Constante",yyline , yychar);}
"\""[^\n]*"\"" {contador++; return new Token(Constante.STRING,"Constante",yytext(), yyline, yychar);}
"\'"[^\n]*"\'" {contador++; return new Token(Constante.STRING,"Constate",yytext(), yyline, yychar);}
{digit}+"."{digit}+ {contador++; return new Token(Constante.DOUBLE,"Constante",yytext(), yyline, yychar);}

////// token de bloqueCodigo
("\r\n"|"\n") {contador++; return new Token(BloqueCodigo.NEWLINE,"BloqueCodigo", yytext(), yyline, yychar);}
("    ") {contador++; return new Token(BloqueCodigo.IDENTACION,"BloqueCodigo", yytext(), yyline, yychar);}
[\t] {contador++; return new Token(BloqueCodigo.IDENTACION,"BloqueCodigo", yytext(), yyline, yychar);}

//// token operador doble
("**"|"--"|"++") {contador++; return new Token(1, null ,yytext(),yyline, yychar);}

//// token de Aritmetico
("+"|"-"|"*"|"/"|"%"|"^") {contador++; return new Token(2, null,yytext(),yyline, yychar);}

//// token de Relacionales
("=="|"!="|"<"|">"|"<="|">=") {contador++; return new Token(3, null,yytext(),yyline, yychar);}

///// token delimitador
("("|")"|"{"|"}"|"["|"]"|";"|":"|"."|","|"="|"->"|"@") {contador++; return new Token(4, null,yytext(), yyline, yychar);}

//// token de Logicos
("and"|"or"|"not") {contador++; return new Token(5, null,yytext(),yyline, yychar);}

/// token de asignacion
("="|"+="|"-="|"*=") {contador++; return new Token(6, null,yytext(),yyline,yychar);}

(" ")+ {/*ignore*/}

[^] {throw new IOException(" caracter no reconocido <" + yytext() + ">");}
