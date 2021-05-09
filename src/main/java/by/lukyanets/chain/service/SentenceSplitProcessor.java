package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;

public class SentenceSplitProcessor extends ChainedProcessor{

    public SentenceSplitProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        return null;
    }
}
