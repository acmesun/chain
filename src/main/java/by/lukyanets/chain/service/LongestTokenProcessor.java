package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Paragraph;
import by.lukyanets.chain.entity.TextHolder;

import java.util.Comparator;

public class LongestTokenProcessor extends SentenceLevelProcessor {
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

    private int findLongestWord(TextHolder sentence) {
        return ((Paragraph) sentence).getInnerTexts().stream().mapToInt(it -> it.getText().length()).max().orElseThrow();
    }


}
