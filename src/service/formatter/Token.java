package src.service.formatter;

import src.enums.TokenType;

public class Token {
    TokenType type;
    String value;
    String url;

    public Token(TokenType type) {
        this.type = type;
        this.value = "";
        this.url = "";
    }

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
        this.url = "";
    }

    public Token(TokenType type, String value, String url) {
        this.type = type;
        this.value = value;
        this.url = url;
    }
}
