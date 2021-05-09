package by.lukyanets.chain.service;

public class ChainCreator {

    public ChainedProcessor createChain() {
        var words = new WordSplitProcessor(null);
        var sentences = new SentenceSplitProcessor(words);
        var paragraphs = new ParagraphSplitProcessor(sentences);
        return new FileReadProcessor(paragraphs);
    }

    public ChainedProcessor createChainParagraphsSorted() {
        var words = new WordSplitProcessor(null);
        var sorted = new SortBySizeProcessor(words);
        var sentences = new SentenceSplitProcessor(sorted);
        var paragraphs = new ParagraphSplitProcessor(sentences);
        return new FileReadProcessor(paragraphs);
    }

    public ChainedProcessor createChainLongestWord() {
        var longestWord = new LongestTokenProcessor(null);
        var words = new WordSplitProcessor(longestWord);
        var sentences = new SentenceSplitProcessor(words);
        var paragraphs = new ParagraphSplitProcessor(sentences);
        return new FileReadProcessor(paragraphs);
    }

    public ChainedProcessor createChainSentenceFilter() {
        var filter = new SentenceLengthFilterProcessor(null, 25);
        var words = new WordSplitProcessor(filter);
        var sentences = new SentenceSplitProcessor(words);
        var paragraphs = new ParagraphSplitProcessor(sentences);
        return new FileReadProcessor(paragraphs);
    }

    public ChainedProcessor createChainWordCount() {
        var counts = new WordCountProcessor(null);
        var words = new WordSplitProcessor(counts);
        var sentences = new SentenceSplitProcessor(words);
        var paragraphs = new ParagraphSplitProcessor(sentences);
        return new FileReadProcessor(paragraphs);
    }
}
