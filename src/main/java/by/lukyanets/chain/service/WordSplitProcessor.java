package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import static by.lukyanets.chain.entity.HolderType.SENTENCE;

public class WordSplitProcessor extends ChainedProcessor {
    private final Logger logger = LogManager.getLogger(WordCountProcessor.class);

    public WordSplitProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        logger.info("Word splitting process.");
        return toProcess.split(str -> Arrays.asList(str.split(" ")), SENTENCE);
    }
}
