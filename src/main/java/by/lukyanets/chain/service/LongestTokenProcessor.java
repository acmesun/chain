package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Node;
import by.lukyanets.chain.entity.TextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class LongestTokenProcessor extends SentenceLevelProcessor {
    private final Logger logger = LogManager.getLogger(LongestTokenProcessor.class);

    public LongestTokenProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        logger.info("Search for the sentence with the longest word.");
        return getSentences(toProcess)
                .stream()
                .max(Comparator.comparingInt(this::findLongestWord))
                .orElseThrow();
    }

    private int findLongestWord(TextHolder sentence) {
        return ((Node) sentence).getInnerTexts().stream().mapToInt(it -> it.getText().length()).max().orElseThrow();
    }
}
