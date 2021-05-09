package by.lukyanets.chain.entity;

import java.util.Collection;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class Token implements TextHolder {
    private final String text;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public TextHolder split(Function<String, Collection<String>> splitter) {
        return new Paragraph(splitter.apply(text).stream().map(Token::new).collect(toList()));
    }

    public Token(String text) {
        this.text = text;
    }
}
