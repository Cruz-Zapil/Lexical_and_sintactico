package com.analizador.backEnd.lexer.dictionary.concatenables;


public enum Keyword {

    AND("and"),
    AS("as"),
    ASSERT("assert"),
    BREAK("break"),
    PRINT("print"),
    CLASS("class"),
    CONTINUE("continue"),
    DEF("def"),
    DEL("del"),
    ELIF("elif"),
    ELSE("else"),
    EXCEPT("except"),
    FALSE("False"),
    FINALLY("finally"),
    FOR("for"),
    FROM("from"),
    GLOBAL("global"),
    IF("if"),
    IMPORT("import"),
    IN("in"),
    IS("is"),
    LAMBDA("lambda"),
    NONE("None"),
    NONLOCAL("nonlocal"),
    NOT("not"),
    OR("or"),
    PASS("pass"),
    RAISE("raise"),
    RETURN("return"),
    TRUE("True"),
    TRY("try"),
    WHILE("while"),
    WITH("with"),
    YIELD("yield"),
    EOF("EOF");
    /// tomar en cuenta que true y false, son palabras reservadas pero tambien son
    /// tipos de contrates
   private String simbolo;
    private Keyword(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }


    public static Keyword probandoKW(String simbolo){

        for (Keyword key : Keyword.values()) {

            if (key.getSimbolo().equals(simbolo)) {
                return key;
            }
        }
        return null ;      
        
    }


}
