package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ChainedProcessor implements Processor {
    private final Processor next;
    private final Logger logger = LogManager.getLogger(ChainedProcessor.class);


    public ChainedProcessor(Processor next) {
        this.next = next;
    }

    @Override
    public TextHolder process(TextHolder toProcess) {
        logger.warn("Null checking");
        TextHolder processed = processInner(toProcess);
        return next == null || processed == null ? processed : next.process(processed);
    }

    protected abstract TextHolder processInner(TextHolder toProcess);
}
