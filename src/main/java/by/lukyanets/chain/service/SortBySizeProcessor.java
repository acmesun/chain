package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Node;
import by.lukyanets.chain.entity.TextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

import static by.lukyanets.chain.entity.HolderType.PARAGRAPH;
import static java.util.stream.Collectors.toList;

public class SortBySizeProcessor extends ChainedProcessor {
    private final Logger logger = LogManager.getLogger(SortBySizeProcessor.class);
    public SortBySizeProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        logger.info("Data sorted by size.");
        if (toProcess instanceof Node) {
            var inner = ((Node) toProcess).getInnerTexts();
            return new Node(inner.stream().sorted(Comparator.comparingInt(TextHolder::size)).collect(toList()), PARAGRAPH);
        }
        return toProcess;
    }
}
