package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.HolderType;
import by.lukyanets.chain.entity.Node;
import by.lukyanets.chain.entity.TextHolder;

import java.util.Comparator;

import static by.lukyanets.chain.entity.HolderType.PARAGRAPH;
import static java.util.stream.Collectors.toList;

public class SortBySizeProcessor extends ChainedProcessor {
    public SortBySizeProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        if (toProcess instanceof Node) {
            var inner = ((Node) toProcess).getInnerTexts();
            return new Node(inner.stream().sorted(Comparator.comparingInt(TextHolder::size)).collect(toList()), PARAGRAPH);
        }
        return toProcess;
    }
}
