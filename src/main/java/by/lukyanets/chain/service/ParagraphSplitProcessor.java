package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import static by.lukyanets.chain.entity.HolderType.CHAPTER;

public class ParagraphSplitProcessor extends ChainedProcessor {
    private final static String PARAGRAPH_SPLIT_REGEX = "\t| {4}";
    private final Logger logger = LogManager.getLogger(ParagraphSplitProcessor.class);

    public ParagraphSplitProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        logger.info("Paragraphing process.");
        return toProcess.split(str -> Arrays.asList(str.split(PARAGRAPH_SPLIT_REGEX)), CHAPTER);
    }
}
