package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.TextHolder;
import by.lukyanets.chain.entity.Token;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReadProcessor extends ChainedProcessor {
    private final Logger logger = LogManager.getLogger(FileReadProcessor.class);

    public FileReadProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        try {
            String fileData = String.join(" ", Files.readAllLines(Paths.get(toProcess.getText())));
            return new Token(fileData);
        } catch (IOException e) {
            logger.warn("Reading from {}. New token cannot be created. Null will return", toProcess.getText());
            return null;
        }
    }
}
