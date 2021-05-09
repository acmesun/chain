package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;

public interface Processor {

    TextHolder process(TextHolder toProcess);
}
