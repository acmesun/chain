package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;

import java.util.Arrays;

import static by.lukyanets.chain.entity.HolderType.CHAPTER;

public class ParagraphSplitProcessor extends ChainedProcessor {
    private final static String PARAGRAPH_SPLIT_REGEX = "\t| {4}";

    public ParagraphSplitProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        return toProcess.split(str -> Arrays.asList(str.split(PARAGRAPH_SPLIT_REGEX)), CHAPTER);
    }
}
