package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;

import java.util.Arrays;

import static by.lukyanets.chain.entity.HolderType.SENTENCE;

public class WordSplitProcessor extends ChainedProcessor {
    public WordSplitProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        return toProcess.split(str -> Arrays.asList(str.split(" ")), SENTENCE);
    }
}
