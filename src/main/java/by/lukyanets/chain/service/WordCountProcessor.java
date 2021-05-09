package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.HolderType;
import by.lukyanets.chain.entity.Node;
import by.lukyanets.chain.entity.TextHolder;
import by.lukyanets.chain.entity.Token;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WordCountProcessor extends ChainedProcessor {
    public WordCountProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        var map = findAllWords(toProcess)
                .stream()
                .map(it -> it.getText().toLowerCase())
                .collect(Collectors.toMap(it -> it, it -> 1, Integer::sum));
        var words = map.entrySet()
                .stream().filter(it -> it.getValue() > 1)
                .map(it -> new Node(List.of(new Token(it.getKey()), new Token(it.getValue().toString())), HolderType.SENTENCE))
                .collect(toList());
        return new Node(words, HolderType.PARAGRAPH);
    }

    private List<TextHolder> findAllWords(TextHolder holder) {
        if (holder instanceof Node) {
            return ((Node) holder).getInnerTexts().stream()
                    .flatMap(it -> findAllWords(it).stream())
                    .collect(toList());
        } else {
            return List.of(holder);
        }
    }
}
