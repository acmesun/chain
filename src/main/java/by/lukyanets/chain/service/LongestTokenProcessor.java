package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Paragraph;
import by.lukyanets.chain.entity.TextHolder;
import by.lukyanets.chain.entity.Token;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LongestTokenProcessor extends ChainedProcessor {
    public LongestTokenProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        return getSentences(toProcess)
                .stream()
                .max(Comparator.comparingInt(this::findLongestWord))
                .orElseThrow();
    }

    private List<? extends TextHolder> getSentences(TextHolder holder) {
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

    private int findLongestWord(TextHolder sentence) {
        return ((Paragraph) sentence).getInnerTexts().stream().mapToInt(it -> it.getText().length()).max().orElseThrow();
    }


}
