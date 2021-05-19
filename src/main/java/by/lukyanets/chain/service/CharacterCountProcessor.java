package by.lukyanets.chain.service;

import by.lukyanets.chain.entity.Node;
import by.lukyanets.chain.entity.TextHolder;
import by.lukyanets.chain.entity.Token;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

import static by.lukyanets.chain.entity.HolderType.CHAPTER;
import static by.lukyanets.chain.entity.HolderType.PARAGRAPH;

public class CharacterCountProcessor extends SentenceLevelProcessor {
    private final Logger logger = LogManager.getLogger(CharacterCountProcessor.class);

    public CharacterCountProcessor(Processor next) {
        super(next);
    }

    @Override
    protected TextHolder processInner(TextHolder toProcess) {
        logger.info("Inner process to find count of vowels and consonants information.");
        var counts = getSentences(toProcess).stream()
                .map(it -> new Node(List.of(it, new Token(getCounts(it.getText().toLowerCase()))), PARAGRAPH))
                .collect(Collectors.toList());
        return new Node(counts, CHAPTER);
    }

    private String getCounts(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (isLetter(c)) {
                if (isVowel(c)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return String.format("Consonants: %d; Vowels: %d", consonants, vowels);
    }

    private boolean isLetter(char c) {
        switch (c) {
            case ' ':
            case ',':
            case '.':
            case '?':
            case '!':
            case ':':
            case '-':
            case '_':
            case '+':
            case '<':
            case '>':
            case '=':
            case '\\':
            case '/':
            case '"':
            case '\'':
                return false;
            default:
                return true;
        }
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'а':
            case 'е':
            case 'и':
            case 'у':
            case 'о':
            case 'ы':
            case 'э':
            case 'ю':
            case 'я':
            case 'ё':
                return true;
            default:
                return false;
        }
    }
}
