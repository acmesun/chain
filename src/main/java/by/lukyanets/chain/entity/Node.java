package by.lukyanets.chain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Node implements TextHolder {
    private final List<? extends TextHolder> innerText;
    private final HolderType type;

    public Node(List<? extends TextHolder> innerText, HolderType type) {
        this.innerText = innerText;
        this.type = type;
    }

    @Override
    public String getText() {
        return innerText.stream().map(TextHolder::getText).collect(Collectors.joining(" "));
    }

    @Override
    public TextHolder split(Function<String, Collection<String>> splitter, HolderType nodeType) {
        var paragraphs = innerText.stream().map(text -> text.split(splitter, nodeType)).collect(toList());
        return new Node(paragraphs, type);
    }

    @Override
    public int size() {
        return innerText.size();
    }

    @Override
    public HolderType getType() {
        return type;
    }

    public List<? extends TextHolder> getInnerTexts() {
        return new ArrayList<>(innerText);
    }

}
