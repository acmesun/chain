package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;

import java.util.Arrays;

public class ParagraphSplitProcessor extends ChainedProcessor {
    public ParagraphSplitProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        return toProcess.split(str -> Arrays.asList(str.split("\t| {4}")));
    }
}
