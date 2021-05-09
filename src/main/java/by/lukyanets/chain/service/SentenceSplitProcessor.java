package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SentenceSplitProcessor extends ChainedProcessor{

    public SentenceSplitProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        return null;
    }
}
