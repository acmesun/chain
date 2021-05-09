package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Paragraph;
import by.lukyanets.chain.entity.TextHolder;

import static java.util.stream.Collectors.toList;

public class SentenceLengthFilterProcessor extends SentenceLevelProcessor {
    private final int minLength;

    public SentenceLengthFilterProcessor(Processor next, int minLength) {
        super(next);
        this.minLength = minLength;
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        var filtered = getSentences(toProcess)
                .stream()
                .filter(it -> it.size() >= minLength)
                .collect(toList());
        return new Paragraph(filtered);
    }
}
