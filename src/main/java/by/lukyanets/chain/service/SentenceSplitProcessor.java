package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static by.lukyanets.chain.entity.HolderType.*;

public class SentenceSplitProcessor extends ChainedProcessor {
    private final Pattern BY_SENTENCE = Pattern.compile("[A-ZА-Я].+?(\\.\\.\\.|\\.|!|\\?)(?=$| +[A-Zа-я])");
    private final Logger logger = LogManager.getLogger(SentenceLevelProcessor.class);

    public SentenceSplitProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {

        return toProcess.split(this::splitBySentences, PARAGRAPH);
    }

    private List<String> splitBySentences(String text) {
        logger.info("Sentence splitting process.");
        return BY_SENTENCE.matcher(text).results()
                .map(it -> it.group(0))
                .collect(Collectors.toList());
    }
}
