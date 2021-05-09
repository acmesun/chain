package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;
import by.lukyanets.chain.entity.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReadProcessor extends ChainedProcessor {
    public FileReadProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        try {
            String fileData = String.join(" ", Files.readAllLines(Paths.get(toProcess.getText())));
            return new Token(fileData);
        } catch (IOException e) {
            return null;
        }
    }
}
