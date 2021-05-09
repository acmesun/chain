package by.lukyanets.chain.service;

public class ChainCreator {

    public ChainedProcessor createChain() {
        var words = new WordSplitProcessor(null);
        var paragraphs = new ParagraphSplitProcessor(words);
        return new FileReadProcessor(paragraphs);
    }
}
