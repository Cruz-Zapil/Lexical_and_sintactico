package com.analizador.backEnd.lexer;

public class Token<TokenType extends Enum<TokenType>> {

    private TokenType tokenType;
    private String lexeme;
    private int line;
    private long charBegin;

    private int type;
    private String claseToken;
    private int nivelIdent;

    /// Constructores
    public Token(TokenType tokenType, String claseToken, String lexeme, int line, long charBegin) {

        /*
        if (lexeme.equals("\n")) {
            String lexemeWithEscapedNewlines = lexeme.replace("\n", "\\n");   
            this.lexeme = lexemeWithEscapedNewlines;        
        }else {
        }       
        */
        this.lexeme = lexeme;
        this.tokenType = tokenType;
        this.line = line;
        this.charBegin = charBegin;
        this.claseToken = claseToken;
    }

    public Token(int type, String lexeme, int line, long charBegin) {
        this.type = type;
        this.lexeme = lexeme;
        this.line = line;
        this.charBegin = charBegin;

        comprobacion(this.type, lexeme);

    }

    public Token(TokenType tokenType, int nivelIdent, String lexeme, int line, long charBegin) {

        this.tokenType = tokenType;
        this.nivelIdent = nivelIdent;
        this.lexeme = lexeme;
        this.line = line;
        this.charBegin = charBegin;
    }

    public void comprobacion(int type, String lexeme) {

        new TokenAuxi().comprobacion(type, lexeme, this);
    }

    //// getters and setters

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getClaseToken() {
        return claseToken;
    }

    public void setClaseToken(String claseToken) {
        this.claseToken = claseToken;
    }

    public void setTokenType(TokenType token) {
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


    public int getNivelIdent() {
        return nivelIdent;
    }

    public void setNivelIdent(int nivelIdent) {
        this.nivelIdent = nivelIdent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public long getCharBegin() {
        return charBegin;
    }

    public void setCharBegin(long charBegin) {
        this.charBegin = charBegin;
    }

}
