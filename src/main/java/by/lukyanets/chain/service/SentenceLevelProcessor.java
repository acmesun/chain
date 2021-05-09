package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Node;
import by.lukyanets.chain.entity.TextHolder;
import by.lukyanets.chain.entity.Token;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class SentenceLevelProcessor extends ChainedProcessor {
    public SentenceLevelProcessor(Processor next) {
        super(next);
    }

    protected List<? extends TextHolder> getSentences(TextHolder holder) {
        if (holder instanceof Node) {
            var inner = ((Node) holder).getInnerTexts();
            return Stream.concat(inner.stream().flatMap(it -> getSentences(it).stream()), Stream.of(holder))
                    .filter(it -> it.getType() == SENTENCE)
                    .collect(toList());
        }
        return List.of();
    }

}
