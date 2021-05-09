package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Paragraph;
import by.lukyanets.chain.entity.TextHolder;

import java.util.Comparator;

import static java.util.stream.Collectors.toList;

public class SortBySizeProcessor extends ChainedProcessor {
    public SortBySizeProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        if (toProcess instanceof Paragraph) {
            var inner = ((Paragraph) toProcess).getInnerTexts();
            return new Paragraph(inner.stream().sorted(Comparator.comparingInt(TextHolder::size)).collect(toList()));
        }
        return toProcess;
    }
}
