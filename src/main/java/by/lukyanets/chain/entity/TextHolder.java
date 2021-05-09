package by.lukyanets.chain.entity;

import java.util.Collection;
import java.util.function.Function;

public interface TextHolder {

    String getText();

    TextHolder split(Function<String, Collection<String>> splitter);
}
