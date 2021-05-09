package by.lukyanets.chain.entity;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Paragraph implements TextHolder {
    private final List<? extends TextHolder> innerText;

    public Paragraph(List<? extends TextHolder> innerText) {
        this.innerText = innerText;
    }

    @Override
    public String getText() {
        return innerText.stream().map(TextHolder::getText).collect(Collectors.joining(" "));
    }

    public TextHolder split(Function<String, Collection<String>> splitter) {
        var paragraphs = innerText.stream().map(text -> text.split(splitter)).collect(toList());
        return new Paragraph(paragraphs);
    }
}
