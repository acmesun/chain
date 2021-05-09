package by.lukyanets.chain.entity;

import java.util.Collection;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class Token implements TextHolder {
    private final static int DEFAULT_TOKEN_SIZE = 1;
    private final String text;

    public Token(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public TextHolder split(Function<String, Collection<String>> splitter, HolderType nodeType) {
        return new Node(splitter.apply(text).stream().map(Token::new).collect(toList()), nodeType);
    }

    @Override
    public int size() {
        return DEFAULT_TOKEN_SIZE;
    }

    @Override
    public HolderType getType() {
        return HolderType.WORD;
    }

    public Token(String text) {
        this.text = text;
    }
}
