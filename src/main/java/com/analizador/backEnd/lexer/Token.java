package com.analizador.backEnd.lexer;


public class Token<Token extends Enum<Token>> {

    public static final Enum EOF = null;

    private Token tokenType;
    private String lexeme;
    private int line;
    private long charBegin;
    private int type;
    private String claseToken;

    /// Constructores
    public Token(Token tokenType, String claseToken, String lexeme, int line, long charBegin) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.line = line;
        this.charBegin = charBegin;
        this.claseToken = claseToken;
    }

    public Token(int type, String claseToken ,String lexeme, int line, long charBegin) {
        this.type = type;
        this.lexeme = lexeme;
        this.line = line;
        this.charBegin = charBegin;
        this.claseToken = claseToken;

        comprobacion(this.type, lexeme);

    }

    public void comprobacion(int type, String lexeme) {

        new TokenAuxi().comprobacion(type, lexeme, this);
    }

    //// getters and setters

    public Token getTokenType() {
        return tokenType;
    }

    public String getClaseToken() {
        return claseToken;
    }

    public void setClaseToken(String claseToken) {
        this.claseToken = claseToken;
    }

    public void setTokenType(Token token) {
        this.tokenType = token;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        // Reemplazar saltos de línea en el lexema por "\n"
        String lexemeWithEscapedNewlines = lexeme.replace("\n", "\\n");
    
        // Reemplazar retorno de carro en el lexema por "\r"
        lexemeWithEscapedNewlines = lexemeWithEscapedNewlines.replace("\r", "\\r");
    
        // Reemplazar tabulaciones en el lexema por "\t"
        lexemeWithEscapedNewlines = lexemeWithEscapedNewlines.replace("\t", "\\t");
    
        return "Token [tokenType=" + claseToken + "." + tokenType + ", lexeme=" + lexemeWithEscapedNewlines +
                ", line=" + line + ", charBegin=" + charBegin + "]";
    }
    

}
