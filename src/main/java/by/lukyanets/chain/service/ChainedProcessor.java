package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;

public abstract class ChainedProcessor implements Processor {
    private final Processor next;

    public ChainedProcessor(Processor next) {
        this.next = next;
    }

    @Override
    public TextHolder process(TextHolder toProcess) {
        TextHolder processed = processInner(toProcess);
        return next == null || processed == null ? processed : next.process(processed);
    }

    protected abstract TextHolder processInner(TextHolder toProcess);
}
