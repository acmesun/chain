package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Paragraph;
import by.lukyanets.chain.entity.TextHolder;
import by.lukyanets.chain.entity.Token;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class SentenceLevelProcessor extends ChainedProcessor {
    public SentenceLevelProcessor(Processor next) {
        super(next);
    }

    protected List<? extends TextHolder> getSentences(TextHolder holder) {
        if (holder instanceof Paragraph) {
            var inner = ((Paragraph) holder).getInnerTexts();
            if (inner.size() > 0 && inner.get(0) instanceof Token) {
                // In that case we already reached 'sentence level', inner contains only tokens.
                return List.of(holder);
            }
            return inner.stream().flatMap(it -> getSentences(it).stream()).collect(toList());
        }
        return List.of();
    }

}
