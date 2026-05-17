package src.service.formatter;

import java.util.ArrayList;
import java.util.List;

import src.enums.TokenType;
import src.service.formatter.Token;

public class Tokenizer {
    private String content;
    private int cursor = 0;
    private boolean isStart = true;
    private List<Token> tokens;
    private StringBuilder tempString;

    public Tokenizer(String content) {
        init(content);
    }

    public void init(String content) {
        this.content = content;
        content = content.replace("\r\n", "\n");
        content = content.replace("&", "&amp;");
        content = content.replace("<", "&lt;");
        content = content.replace(">", "&gt;");
    }

    public List<Token> tokenize() {
        tokens = new ArrayList<Token>();
        tempString = new StringBuilder();

        while (!isEnd()) {
            if (tokenizeNewLine())
                continue;
            if (tokenizeHeader())
                continue;
            if (tokenizeBold())
                continue;
            if (tokenizeItalic())
                continue;
            if (tokenizeLink())
                continue;
            addTemp(current());
        }
        flushTemp();

        return tokens;
    }

    private void addTemp(char character) {
        tempString.append(character);
        next(1);
    }

    private void flushTemp() {
        if (tempString.isEmpty()) {
            return;
        }

        tokens.add(new Token(TokenType.TEXT, tempString.toString()));
        tempString.setLength(0);
    }

    private boolean isEnd() {
        return cursor >= content.length();
    }

    private void next(int n) {
        for (int i = 0; i < n; i++) {
            if (current() == '\n') {
                isStart = true;
            } else {
                isStart = false;
            }

            cursor++;
        }
    }

    private boolean peek(String sample) {
        return content.startsWith(sample, cursor);
    }

    private char current() {
        return content.charAt(cursor);
    }

    private String readUntil(char end) {
        StringBuilder string = new StringBuilder();

        while (!isEnd()) {
            if (current() == end) {
                next(1);

                return string.toString();
            }

            string.append(current());
            next(1);
        }

        return null;
    }

    private boolean tokenizeNewLine() {
        if (!peek("\n")) {
            isStart = false;
            return false;
        }

        next(1);

        isStart = true;

        flushTemp();
        tokens.add(new Token(TokenType.NEWLINE));

        return true;
    }

    private boolean tokenizeHeader() {
        if (!isStart || !peek("#")) {
            return false;
        }

        int weight = 0;
        int rollback = cursor;

        while (!isEnd() && current() == '#') {
            next(1);
            weight++;
        }

        switch (weight) {
            case 1:
                flushTemp();
                tokens.add(new Token(TokenType.H2));
                break;
            case 2:
                flushTemp();
                tokens.add(new Token(TokenType.H3));
                break;
            case 3:
                flushTemp();
                tokens.add(new Token(TokenType.H4));
                break;
            case 4:
                flushTemp();
                tokens.add(new Token(TokenType.H5));
                break;
            default:
                cursor = rollback;
                return false;
        }

        return true;
    }

    private boolean tokenizeBold() {
        if (!peek("**")) {
            return false;
        }

        next(2);

        flushTemp();
        tokens.add(new Token(TokenType.BOLD));

        return true;
    }

    private boolean tokenizeItalic() {
        if (!peek("_")) {
            return false;
        }

        next(2);

        flushTemp();
        tokens.add(new Token(TokenType.ITALIC));

        return true;
    }

    private boolean tokenizeLink() {
        if (!peek("[")) {
            return false;
        }

        int rollback = cursor;

        next(1);

        String text = readUntil(']');

        if (text == null) {
            cursor = rollback;
            return false;
        }

        if (!peek("(")) {
            cursor = rollback;
            return false;
        }

        next(1);

        String url = readUntil(')');

        if (url == null) {
            cursor = rollback;
            return false;
        }

        flushTemp();
        tokens.add(new Token(TokenType.LINK, text, url));

        return true;
    }
}
